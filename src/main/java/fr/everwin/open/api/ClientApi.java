/*
 * Copyright (C) 2019 Everwin (www.everwin.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.everwin.open.api;

import java.util.logging.Level;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.everwin.open.api.core.auth.Authentication;
import fr.everwin.open.api.core.auth.Token;
import fr.everwin.open.api.exception.AuthException;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.util.ClientRequest;
import fr.everwin.open.api.util.RequestParams;
import fr.everwin.open.api.util.SSLTrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SX REST API Client
 * @author everwin-team
 */
public class ClientApi {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ClientApi.class);

    public static final String API_VERSION_1 = "v1";
    public static final String API_VERSION_2 = "v2";

    /** Auth manager to handle api key or oauth authentication */
    private Authentication auth;

    /** The http client */
    private Client client;
    /** The uri of the server */
    private String uri = "http://localhost:8080/sx/rest";

    /** The version of the api */
    private String version = API_VERSION_2;

    /**
     * Create a new Client for the given uri and init the client from SSL or NoSSL.
     * @param uri The API base uri
     * @throws CoreException If connection failed
     */
    public ClientApi(String uri) throws CoreException {
        this.uri = uri;
        initClient();
    }

    /**
     * Create a new Client for the given uri and init the client from SSL or NoSSL.<br>
     * Set the version of the api to request : v1 or v2...
     * @param uri The API base uri
     * @param version The API version
     * @throws CoreException If connection failed
     */
    public ClientApi(String uri, String version) throws CoreException {
        this.uri = uri;
        this.version = version;
        initClient();
    }

    /**
     * Set authentication informations for OAuth
     * @param clientId The clientId
     * @param secret The clientSecret
     * @throws AuthException If authentication failed
     */
    public void setAuthInfos(String clientId, String secret) throws AuthException {
        this.auth = new Authentication.Builder().withClientInfos(clientId, secret).build();
        checkAuth();
    }

    /**
     * Set authentication informations for apiKey mode
     * @param apiKey The API key uses to authenticate
     * @throws AuthException If authentication failed
     */
    public void setApiKey(String apiKey) throws AuthException {
        this.auth = new Authentication.Builder().withApiKey(apiKey).build();
        checkAuth();
    }


    /**
     * Create the jersey client builder for SSL or NoSSL client
     * @return a ClientBuilder
     */
    private ClientBuilder createCommonClientBuilder(){
        return ClientBuilder.newBuilder()
                .register(new LoggingFeature(java.util.logging.Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
                    Level.FINE, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000))
                .register(new JacksonJsonProvider());
    }

    /**
     * Init the client instance according to the protocol of the server uri
     * @throws CoreException If http client creation failed
     */
    private void initClient() throws CoreException {
        if(client == null) {
            if (uri.startsWith("https")) {
                initSSLClient();
            } else {
                initNoSSLClient();
            }
        }
    }

    /**
     * Init the SSL client
     * @throws CoreException If http client creation failed
     */
    private void initSSLClient() throws CoreException {
        try {
            LOGGER.debug("Init SSL client");
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new SSLTrustManager()}, new java.security.SecureRandom());
            client = createCommonClientBuilder().sslContext(sslContext).hostnameVerifier((h1, h2) -> true).build();
        } catch (Exception e) {
            LOGGER.error("Error when init SSL client", e);
            throw new CoreException("Unable to create client : " + e.getMessage());
        }
    }

    /**
     * Init the no SSL client
     * @throws CoreException If http client creation failed
     */
    private void initNoSSLClient() throws CoreException {
        LOGGER.debug("Init NoSSL client");
        client = createCommonClientBuilder().build();
    }

    /**
     * Request a token to the api for the clientId and secret<br>
     * The token is store in auth
     * @throws AuthException If the authentication or token request failed
     */
    private void requestToken() throws AuthException{
        LOGGER.debug("Request oauth token");
        WebTarget webTarget = client.target(uri).path("authz/token");
        Invocation.Builder invocation = webTarget.request();

        Form form = new Form();
        form.param("grant_type", "client_credentials");
        form.param("client_id", auth.getClientId());
        form.param("client_secret", auth.getClientSecret());

        Response response = invocation.post(Entity.form(form));
        if(response.getStatus() == Response.Status.OK.getStatusCode()) {
            Token token = response.readEntity(Token.class);
            auth.setToken(token.getAccessToken());
        }else{
             throw new AuthException("Authentication error : " + response.getStatus() + " / " + response.getStatusInfo());
        }
    }

    /**
     * Check apiKey or token with given auth informations
     * @throws AuthException If authentication failed
     */
    public void checkAuth() throws AuthException {
        if (auth == null) {
            throw new AuthException("Authentication method is required !");
        } else if (auth.getType() == Authentication.TYPE_OAUTH && auth.getToken() == null) {
            requestToken();
        }
    }

    /**
     * Get the api request path which can be uri + version + resource path
     * @param path The resource path
     * @return The full resource path
     */
    private String getPath(String path){
        return path.startsWith("http") ? path : uri + "/" + version + "/" + path;
    }

    /**
     * Send a request in POST to the api with the given path.
     * The obj will be send to the api in JSON format.
     * The POST method is used to create or update partially an object.
     * @param path The request path
     * @param obj Object to send
     * @return The response of the post request
     * @throws CoreException If the post request failed
     */
    public Response post(String path, Object obj) throws CoreException {
        return new ClientRequest.Builder()
                                .client(client)
                                .auth(auth)
                                .path(getPath(path))
                                .build()
                                .post(Entity.entity(obj, MediaType.APPLICATION_JSON));
    }

    /**
     * Send a request in PUT to the api with the given path.
     * The obj will be send to the api in JSON format.
     * The PUT method is used to update a full object.
     * @param path The request path
     * @param obj  Object to send
     * @return The reponse of the put request
     * @throws CoreException If the put request failed
     */
    public Response put(String path, Object obj) throws CoreException {
        return new ClientRequest.Builder()
                .client(client)
                .auth(auth)
                .path(getPath(path))
                .build()
                .put(Entity.entity(obj, MediaType.APPLICATION_JSON));
    }

    /**
     * Send a request in GET to the api with the given path. The result will be a single object or a list.<br>
     * @param path The request path
     * @param params Request extra params
     * @return The response of the get request
     * @throws CoreException If the get request failed
     */
    public Response get(String path, RequestParams params) throws CoreException {
        return new ClientRequest.Builder()
                .client(client)
                .auth(auth)
                .params(params)
                .path(getPath(path))
                .build()
                .get();
    }

    /**
     * Send a request in DEL to the api with the given path. <br>
     * The DEL method is used to delete a single object.
     * @param path The request path
     * @return The reponse of the del request
     * @throws CoreException If the del request failed
     */
    public Response delete(String path) throws CoreException {
        return new ClientRequest.Builder()
                .client(client)
                .auth(auth)
                .path(getPath(path))
                .build()
                .delete();
    }

}
