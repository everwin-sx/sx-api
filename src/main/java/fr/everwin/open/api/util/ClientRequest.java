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

package fr.everwin.open.api.util;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.core.auth.Authentication;
import fr.everwin.open.api.exception.RequestException;

/**
 * Client request wrapper<br>
 * This wrapper can handle all REST requests.
 * @author everwin-team
 */
public class ClientRequest {

    protected static final Logger LOGGER = LogManager.getLogger();

    private String path;
    private Authentication auth;
    private Client client;
    private WebTarget webTarget;
    private String contentType = MediaType.APPLICATION_JSON;
    private MediaType accept = MediaType.APPLICATION_JSON_TYPE;

    private Map<String, String> params;

    public ClientRequest(Client client, String path){
        this.client = client;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Authentication getAuth() {
        return auth;
    }

    public void setAuth(Authentication auth) {
        this.auth = auth;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public MediaType getAccept() {
        return accept;
    }

    public void setAccept(MediaType accept) {
        this.accept = accept;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    /**
     * Create the inner WebTarget
     */
    private void createTarget(){
        webTarget = client.target(path);

        // Add auth informations
        if(auth != null) {
            if (auth.getType() == Authentication.TYPE_APIKEY) {
                webTarget = webTarget.queryParam("apikey", auth.getApiKey());
            } else {
                webTarget = webTarget.queryParam("access_token", auth.getToken());
            }
        }else{
            System.err.println("");
        }
    }

    /**
     * Update WebTarget with parameters
     */
    private void addParams(){
        if(params != null) {
            params.keySet().stream().forEach(key -> webTarget = webTarget.queryParam(key, params.get(key)));
        }
    }

    /**
     * Build and return the invocation request.
     * @return
     */
    private Invocation.Builder buildRequest(){
        return webTarget.request().header("Content-type", contentType).accept(accept);
    }

    /**
     * Build the request for the given path in JSON format. the request contains authorization informations
     * @param path The request path
     * @return
     * @throws RequestException
     */
    private Invocation.Builder create() throws RequestException {
        try {

            createTarget();
            addParams();
            return buildRequest();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new RequestException("Unable to request " + path + " : " + e.getMessage());
        }
    }

    /**
     * Make a POST
     * @param entity Entity to send
     * @return Response
     * @throws RequestException If the request failed
     */
    public Response post(Entity<?> entity) throws RequestException{
        LOGGER.debug("Make a POST to /" + path);
        return create().post(entity);
    }

    /**
     * Make a PUT
     * @param entity Entity to send
     * @return Response
     * @throws RequestException If the request failed
     */
    public Response put(Entity<?> entity) throws RequestException{
        LOGGER.debug("Make a PUT to /" + path);
        return create().put(entity);
    }

    /**
     * Make a GET
     * @return Response
     * @throws RequestException If the request failed
     */
    public Response get() throws RequestException {
        LOGGER.debug("Make a GET to /" + path);
        return create().get();
    }

    /**
     * Make a DELETE
     * @return Response
     * @throws RequestException If the request failed
     */
    public Response delete() throws RequestException {
        LOGGER.debug("Make a DELETE to /" + path);
        return create().delete();
    }

    /**
     * ClientRequest Builder
     */
    public static class Builder{
        private String path;
        private Authentication auth;
        private Client client;
        private String contentType = MediaType.APPLICATION_JSON;
        private MediaType accept = MediaType.APPLICATION_JSON_TYPE;
        private Map<String, String> params;

        public ClientRequest build(){
            ClientRequest request = new ClientRequest(client, path);
            request.setAuth(auth);
            request.setContentType(contentType);
            request.setAccept(accept);
            request.setParams(params);
            return request;
        }

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Builder path(String path){
            this.path = path;
            return this;
        }

        public Builder auth(Authentication auth){
            this.auth = auth;
            return this;
        }

        public Builder contentType(String contentType){
            this.contentType = contentType;
            return this;
        }

        public Builder accept(MediaType accept) {
            this.accept = accept;
            return this;
        }

        public Builder param(String param, String value){
            if(this.params == null){
                this.params = new HashMap<String, String>();
            }
            this.params.put(param, value);
            return this;
        }

        public Builder params(RequestParams params) {
            this.params = params != null ? params.getParams() : null;
            return this;
        }
    }

}
