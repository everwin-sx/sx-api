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

import java.io.File;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.exception.RequestException;
import fr.everwin.open.api.model.comments.Comment;
import fr.everwin.open.api.model.comments.CommentList;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.Error;
import fr.everwin.open.api.model.documents.Document;
import fr.everwin.open.api.model.documents.DocumentList;
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
     * @param objectClass The object class
     * @param listClass The object list class
     */
    public void setModels(Class<O> objectClass, Class<L> listClass){
        this.objectClass = objectClass;
        this.listClass = listClass;
    }

    /**
     * Read the response and parse the result as responseClass instance or as an Error instance
     * @param response The Web response
     * @param responseClass The responseClass result
     * @return Typed object instance of BasicObject
     * @throws RequestException If the response cannot be parsed or if the response is an error
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
     * @param href The complete url to the object
     * @return Typed object instance of BasicObject
     * @throws CoreException If the request failed
     */
    public O get(String href) throws CoreException {
        Response response = clientApi.get(href, null);
        return (O)readResponse(response, getObjectClass());
    }

    /**
     * Get the object identified by the id
     * @param id The id of the object
     * @return Typed object instance of BasicObject
     * @throws CoreException If the request failed
     */
    public O get(long id) throws CoreException {
        return get(path + "/" + id);
    }

    /**
     * Get a collection of objects. Only the first page will be returned
     * @return Typed object instance of BasicList
     * @throws CoreException If the request failed
     */
    public L query() throws CoreException {
        return query(path, null);
    }

    /**
     * Get a collection of reponseClass instance
     * @param href The full url
     * @param params Extra query params to sort, filter objects
     * @return Typed object instance of BasicList
     * @throws CoreException If the request failed
     */
    public L query(String href, RequestParams params) throws CoreException {
        Response response = clientApi.get(href, params);
        return (L)readResponse(response, getListClass());
    }

    /**
     * Get the reponseClass instance object identified by the full url
     * @param href The full url to the object resource
     * @return Typed object instance of BasicList
     * @throws CoreException If the request failed
     */
    public L query(String href) throws CoreException {
        return query(href, null);
    }

    /**
     * Get a collection of reponseClass instance.
     * @param params Extra query params to sort, filter objects
     * @return Typed object instance of BasicList
     * @throws CoreException If the request failed
     */
    public L query(RequestParams params) throws CoreException {
        return query(path, params);
    }

    /**
     * Delete the object identified by the given id
     * @param id The id of the object
     * @throws CoreException If the request failed
     */
    public void delete(long id) throws CoreException {
        Response response = clientApi.delete(path + "/" + id);
        readResponse(response, String.class);
    }

    /**
     * Post the given object to the path
     * @param path The resource path
     * @param object The instance of BasicObject to send
     * @throws CoreException If the request failed
     */
    public void post(String path, O object) throws CoreException {
        Response response = clientApi.post(path, object);
        readResponse(response, String.class);
    }

    /**
     * Create the given object and return the id
     * @param object The instance of BasicObject to send
     * @return long The id of the new object
     * @throws CoreException If the request failed
     */
    public long post(O object) throws CoreException {
        Response response = clientApi.post(path,object);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        return Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
    }

    /**
     * Update the given object
     * @param object The instance of BasicObject to send
     * @throws CoreException If the request failed
     */
    public void put(O object) throws CoreException {
        Response response = clientApi.put(path + "/" + object.getId(), object);
        readResponse(response, String.class);
    }

    /**
     * Create an object and return the new id
     * @param object The instance of BasicObject to send
     * @return long The id of the new object
     * @throws CoreException If the request failed
     */
    public long create(O object) throws CoreException {
        object.setId(post(object));
        return object.getId();
    }

    /**
     * Update object according to its id. The whole object will be updated and need to be complete
     * @param object The instance of BasicObject to send
     * @throws CoreException If the request failed
     */
    public void update(O object) throws CoreException {
        put(object);
    }

    /**
     * Update the object from its id. Only present fields in the given object will be updated.
     * @param object The instance of BasicObject to send
     * @throws CoreException If the request failed
     */
    public void updatePartially(O object) throws CoreException {
        post(path + "/" + object.getId(), object);
    }

    /**
     * Get a collection of Comments
     * @param objectId The main object linked to comments
     * @param params Extra parameters
     * @return CommentList
     * @throws CoreException If the request failed
     */
    public CommentList queryComments(long objectId, RequestParams params) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/comments", params);
        return (CommentList) readResponse(response, CommentList.class);
    }

    /**
     * Get the comment identified by its id
     * @param objectId The linked object id
     * @param id The comment id
     * @return The comment
     * @throws CoreException If the request failed
     */
    public Comment getComment(long objectId, long id) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/comments/" + id, null);
        return (Comment) readResponse(response, Comment.class);
    }

    /**
     * Create a new comment for the object identified by the objectId
     * @param objectId The id of the object to link to the comment
     * @param comment The comment to create
     * @return The id of the new comment
     * @throws CoreException If the request failed
     */
    public Date createComment(long objectId, Comment comment) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/comments", comment);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        Long id = Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
        comment.setId(id);
        //comment.setUpdatedBy((get(id)).getUpdatedBy());
        comment.setUpdatedOnTime(getComment(objectId, id).getUpdatedOnTime());
        return (getComment(objectId, id)).getUpdatedOnTime();
    }

    /**
     * Update the comment for the object identified by the objectId
     * @param objectId The id of the object linked to the comment
     * @param comment The comment to update
     * @throws CoreException If the request failed
     */
    public Date updateComment(long objectId, Comment comment) throws CoreException {
        Response response = clientApi.put(path + "/" + objectId + "/comments/" + comment.getId(), comment);
        readResponse(response, String.class);
        return getComment(objectId, comment.getId()).getUpdatedOnTime();
    }

    /**
     * Update only not null fields of the comment
     * @param objectId The id of the object to link to the comment
     * @param comment The comment to update
     * @throws CoreException If the request failed
     */
    public Date updatePartiallyComment(long objectId, Comment comment) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/comments/" + comment.getId(), comment);
        readResponse(response, String.class);
        return getComment(objectId, comment.getId()).getUpdatedOnTime();

    }

    /**
     * Delete the comment for the object identified by the objectId
     * @param objectId The id of the object linked to the comment
     * @param id The comment id to update
     * @throws CoreException If the request failed
     */
    public void deleteComment(long objectId, long id) throws CoreException {
        Response response = clientApi.delete(path + "/" + objectId + "/comments/" + id);
        readResponse(response, String.class);
    }

    /**
     * Get a collection of Doucments
     * @param params Extra parameters
     * @param objectId The linked object id
     * @return DocumentList
     * @throws CoreException If the request failed
     */
        public DocumentList queryDocument(long objectId, RequestParams params) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/documents", params);
        return (DocumentList) readResponse(response, DocumentList.class);
    }

    /**
     * Get the document identified by its id
     * @param objectId The linked object id
     * @param id The document id
     * @return The document
     * @throws CoreException If the request failed
     */
    public Document getDocument(long objectId,long id) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/documents/" + id, null);
        return (Document) readResponse(response, Document.class);
    }

    /**
     * Create a new document for the object identified by the objectId
     * @param objectId The id of the object to link to the document
     * @param document The document to create
     * @return The id of the new document
     * @throws CoreException If the request failed
     */
    public Date createDocument(long objectId, Document document) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/documents", document);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        Long id = Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
        document.setId(id);
        document.setUpdatedBy((getDocument(objectId, id)).getUpdatedBy());
        document.setUpdatedOnTime(getDocument(objectId, id).getUpdatedOnTime());
        return (getDocument(objectId, id)).getUpdatedOnTime();
    }

    /**
     * Update the comment for the object identified by the id of the document
     * @param objectId The id of the object linked to the comment
     * @param document The document to update
     * @throws CoreException If the request failed
     */
    public Date updateDocument(long objectId, Document document) throws CoreException {
        Response response = clientApi.put(path + "/" + objectId + "/documents/" + document.getId(), document);
        readResponse(response, String.class);
        return getDocument(objectId, document.getId()).getUpdatedOnTime();
    }

    /**
     * Update only not null fields of the document
     * @param objectId The id of the object linked to the comment
     * @param document The document to update
     * @throws CoreException If the request failed
     */
    public Date updatePartiallyDocument(long objectId, Document document) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/documents/" + document.getId(), document);
        readResponse(response, String.class);
        return getDocument(objectId, document.getId()).getUpdatedOnTime();
    }

    /**
     * Delete the document for the object identified by the id of the document
     * @param id The document id to update
     * @throws CoreException If the request failed
     */
    public void deleteDocument(long objectId, long id) throws CoreException {
        Response response = clientApi.delete(path + "/" + objectId + "/documents/" + id);
        readResponse(response, String.class);
    }

    /**
     * upload the document for the object identified by the id of the document
     * @param objectId The document id to upload
     * @throws CoreException If the request failed
     */
    public void uploadDocument(long objectId, Document document, File file) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/documents/" + document.getId(), file);
        readResponse(response, String.class);
    }

    /**
     * download the document for the object identified by the id of the document
     * @param objectId The document id to download
     * @throws CoreException If the request failed
     */
    public File downloadDocument(long objectId, Document document) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/documents/" + document.getId(), null);
        return (File) readResponse(response, File.class);
    }
}
