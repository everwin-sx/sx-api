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

package fr.everwin.open.api.services.core;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.exception.RequestException;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.Error;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.util.RequestParams;

/**
 * A basic service manager to handle all methods.<br>
 * Each service extends this class.
 * @author everwin-team
 */
public class BasicService<O extends BasicObject,L extends BasicList> {
    protected static final Logger LOGGER = LogManager.getLogger();
    /** The client API */
    protected ClientApi clientApi;
    /** The main path of all resources */
    protected String path;

    private Class<O> objectClass;
    private Class<L> listClass;

    /**
     * Constructor
     * @param clientApi The client API
     * @param path The main path of all resources
     */
    public BasicService(ClientApi clientApi, String path) {
        this.clientApi = clientApi;
        this.path = path;
    }

    /**
     * Set models class
     * @param objectClass
     * @param listClass
     */
    public void setModels(Class<O> objectClass, Class<L> listClass){
        this.objectClass = objectClass;
        this.listClass = listClass;
    }

    /**
     * Read the response and parse the result as responseClass instance or as an Error instance
     * @param response The Web response
     * @param responseClass The responseClass result
     * @return
     * @throws RequestException
     */
    protected Object readResponse(Response response, Class responseClass) throws RequestException {
        try {
            if(response.getStatus() == Response.Status.FOUND.getStatusCode()
                    || response.getStatus() == Response.Status.NO_CONTENT.getStatusCode()
                    || response.getStatus() == Response.Status.OK.getStatusCode()
                    || response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                return response.readEntity(responseClass);
            }else{
                throw createExceptionFromResponse(response);
            }
        } catch (RequestException e) {
            throw e;
        } catch(Exception e) {
            e.printStackTrace(System.err);
            LOGGER.error("Unparsable error : " + e.getMessage(), e);
            throw createExceptionFromResponse(response);
        }
    }

    private RequestException createExceptionFromError(Error error){
        RequestException exception = new RequestException(error.getMessage());
        exception.setCode(error.getCode());
        exception.setStatus(error.getStatus());
        exception.setDevelopperMessage(error.getDeveloperMessage());
        return exception;
    }

    private RequestException createExceptionFromResponse(Response response) {
        try{
            return createExceptionFromError(response.readEntity(Error.class));
        }catch(Exception e) {
            RequestException exception = new RequestException(response.getStatus() + " / " + response.getStatusInfo().getReasonPhrase());
            exception.setCode(response.getStatusInfo().getStatusCode());
            exception.setStatus(response.getStatus());
            return exception;
        }
    }

    protected Class<O> getObjectClass(){
        return objectClass;
    }

    protected Class<L> getListClass(){
        return listClass;
    }

    /**
     * Get the object identified by the href uri
     * @param href
     * @return
     * @throws CoreException
     */
    public O get(String href) throws CoreException {
        Response response = clientApi.get(href, null);
        return (O)readResponse(response, getObjectClass());
    }

    /**
     * Get the object identified by the id
     * @param id
     * @return
     * @throws CoreException
     */
    public O get(long id) throws CoreException {
        return get(path + "/" + id);
    }

    /**
     * Get a collection of objects. Only the first page will be returned
     * @return
     * @throws CoreException
     */
    public L query() throws CoreException {
        return query(path, null);
    }

    /**
     * Get a collection of reponseClass instance
     * @param href          The full url
     * @param responseClass
     * @param params        Extra query params to sort, filter objects
     * @return
     * @throws CoreException
     */
    public L query(String href, RequestParams params) throws CoreException {
        Response response = clientApi.get(href, params);
        return (L)readResponse(response, getListClass());
    }

    /**
     * Get the reponseClass instance object identified by the full url
     * @param href          The full url to the object resource
     * @param responseClass
     * @return
     * @throws CoreException
     */
    public L query(String href) throws CoreException {
        return query(href, null);
    }

    /**
     * Get a collection of reponseClass instance.
     * @param responseClass
     * @param params Extra query params to sort, filter objects
     * @return
     * @throws CoreException
     */
    public L query(RequestParams params) throws CoreException {
        return query(path, params);
    }

    /**
     * Delete the object identified by the given id
     * @param id
     * @throws CoreException
     */
    public void delete(long id) throws CoreException {
        Response response = clientApi.delete(path + "/" + id);
        readResponse(response, String.class);
    }

    /**
     * Post the given object to the path
     * @param object
     * @throws CoreException
     */
    public void post(String path, BasicObject object) throws CoreException {
        Response response = clientApi.post(path, object);
        readResponse(response, String.class);
    }

    /**
     * Create the given object and return the id
     * @param object
     * @return long
     * @throws CoreException
     */
    public long post(BasicObject object) throws CoreException {
        Response response = clientApi.post(path,object);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        return Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
    }

    /**
     * Update the given object
     * @param object
     * @return long
     * @throws CoreException
     */
    public void put(BasicObject object) throws CoreException {
        Response response = clientApi.put(path + "/" + object.getId(), object);
        readResponse(response, String.class);
    }

    /**
     * Create an object and return the new id
     * @param object
     * @return long
     * @throws CoreException
     */
    public long create(O object) throws CoreException {
        return post(object);
    }

    /**
     * Update object according to its id. The whole object will be updated and need to be complete
     * @param object
     * @throws CoreException
     */
    public void update(O object) throws CoreException {
        put(object);
    }

    /**
     * Update the object from its id. Only present fields in the given object will be updated.
     * @param object
     * @throws CoreException
     */
    public void updatePartially(O object) throws CoreException {
        post(path + "/" + object.getId(), object);
    }

}
