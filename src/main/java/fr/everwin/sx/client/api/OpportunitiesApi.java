package fr.everwin.sx.client.api;

import fr.everwin.sx.client.ApiClient;
import fr.everwin.sx.client.ApiException;
import fr.everwin.sx.client.ApiResponse;
import fr.everwin.sx.client.Configuration;
import fr.everwin.sx.client.Pair;
import fr.everwin.sx.client.model.Comment;
import fr.everwin.sx.client.model.CommentList;
import fr.everwin.sx.client.model.Document;
import fr.everwin.sx.client.model.DocumentList;
import fr.everwin.sx.client.model.FormDataContentDisposition;
import fr.everwin.sx.client.model.Opportunity;
import fr.everwin.sx.client.model.OpportunityList;
import fr.everwin.sx.client.model.SalesActionList;
import jakarta.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "fr.everwin.sx.openapi.codegen.CustomJavaClientCodegen", date = "2025-05-22T08:24:46.022483900+02:00[Europe/Paris]")
public class OpportunitiesApi {
  private ApiClient apiClient;

  public OpportunitiesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public OpportunitiesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create an opportunity
   * 
   * @param opportunity Opportunity (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void create(Opportunity opportunity) throws ApiException {
    createWithHttpInfo(opportunity);
  }

  /**
   * Create an opportunity
   * 
   * @param opportunity Opportunity (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createWithHttpInfo(Opportunity opportunity) throws ApiException {
    // Check required parameters
    if (opportunity == null) {
      throw new ApiException(400, "Missing the required parameter 'opportunity' when calling create");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.create", "/opportunities", "POST", new ArrayList<>(), opportunity,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a comment
   * 
   * @param id id (required)
   * @param comment Comment (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void createComment(Long id, Comment comment) throws ApiException {
    createCommentWithHttpInfo(id, comment);
  }

  /**
   * Create a comment
   * 
   * @param id id (required)
   * @param comment Comment (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createCommentWithHttpInfo(Long id, Comment comment) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling createComment");
    }
    if (comment == null) {
      throw new ApiException(400, "Missing the required parameter 'comment' when calling createComment");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/comments"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.createComment", localVarPath, "POST", new ArrayList<>(), comment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a new document for the opportunity
   * 
   * @param id id (required)
   * @param document Document (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void createDocument(Long id, Document document) throws ApiException {
    createDocumentWithHttpInfo(id, document);
  }

  /**
   * Create a new document for the opportunity
   * 
   * @param id id (required)
   * @param document Document (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createDocumentWithHttpInfo(Long id, Document document) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling createDocument");
    }
    if (document == null) {
      throw new ApiException(400, "Missing the required parameter 'document' when calling createDocument");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.createDocument", localVarPath, "POST", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete an opportunity
   * 
   * @param id id (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void delete(Long id) throws ApiException {
    deleteWithHttpInfo(id);
  }

  /**
   * Delete an opportunity
   * 
   * @param id id (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteWithHttpInfo(Long id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling delete");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.delete", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a comment
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void deleteComment(Long id, Long cid) throws ApiException {
    deleteCommentWithHttpInfo(id, cid);
  }

  /**
   * Delete a comment
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteCommentWithHttpInfo(Long id, Long cid) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteComment");
    }
    if (cid == null) {
      throw new ApiException(400, "Missing the required parameter 'cid' when calling deleteComment");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.deleteComment", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a opportunity document
   * 
   * @param id id (required)
   * @param did did (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void deleteDocument(Long id, Long did) throws ApiException {
    deleteDocumentWithHttpInfo(id, did);
  }

  /**
   * Delete a opportunity document
   * 
   * @param id id (required)
   * @param did did (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteDocumentWithHttpInfo(Long id, Long did) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteDocument");
    }
    if (did == null) {
      throw new ApiException(400, "Missing the required parameter 'did' when calling deleteDocument");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.deleteDocument", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get physical file linked to the opportunity document
   * 
   * @param id id (required)
   * @param did did (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void downloadDocument(Long id, Long did) throws ApiException {
    downloadDocumentWithHttpInfo(id, did);
  }

  /**
   * Get physical file linked to the opportunity document
   * 
   * @param id id (required)
   * @param did did (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> downloadDocumentWithHttpInfo(Long id, Long did) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling downloadDocument");
    }
    if (did == null) {
      throw new ApiException(400, "Missing the required parameter 'did' when calling downloadDocument");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents/{did}/download"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.downloadDocument", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get an opportunity by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return Opportunity
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public Opportunity getById(Long id, String fields) throws ApiException {
    return getByIdWithHttpInfo(id, fields).getData();
  }

  /**
   * Get an opportunity by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;Opportunity&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Opportunity> getByIdWithHttpInfo(Long id, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getById");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<Opportunity> localVarReturnType = new GenericType<Opportunity>() {};
    return apiClient.invokeAPI("OpportunitiesApi.getById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a comment by id
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @param fields fields (optional)
   * @return Comment
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public Comment getCommentById(Long id, Long cid, String fields) throws ApiException {
    return getCommentByIdWithHttpInfo(id, cid, fields).getData();
  }

  /**
   * Get a comment by id
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;Comment&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Comment> getCommentByIdWithHttpInfo(Long id, Long cid, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getCommentById");
    }
    if (cid == null) {
      throw new ApiException(400, "Missing the required parameter 'cid' when calling getCommentById");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<Comment> localVarReturnType = new GenericType<Comment>() {};
    return apiClient.invokeAPI("OpportunitiesApi.getCommentById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of comments for the given opportunity
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return CommentList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public CommentList getComments(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getCommentsWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of comments for the given opportunity
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;CommentList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CommentList> getCommentsWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getComments");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/comments"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "filter", filter)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<CommentList> localVarReturnType = new GenericType<CommentList>() {};
    return apiClient.invokeAPI("OpportunitiesApi.getComments", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a opportunity document by id
   * 
   * @param id id (required)
   * @param did did (required)
   * @param fields fields (optional)
   * @return Document
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public Document getDocumentById(Long id, Long did, String fields) throws ApiException {
    return getDocumentByIdWithHttpInfo(id, did, fields).getData();
  }

  /**
   * Get a opportunity document by id
   * 
   * @param id id (required)
   * @param did did (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;Document&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Document> getDocumentByIdWithHttpInfo(Long id, Long did, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDocumentById");
    }
    if (did == null) {
      throw new ApiException(400, "Missing the required parameter 'did' when calling getDocumentById");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<Document> localVarReturnType = new GenericType<Document>() {};
    return apiClient.invokeAPI("OpportunitiesApi.getDocumentById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of documents for the given opportunity
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return DocumentList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public DocumentList getDocuments(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getDocumentsWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of documents for the given opportunity
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;DocumentList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DocumentList> getDocumentsWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDocuments");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "filter", filter)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<DocumentList> localVarReturnType = new GenericType<DocumentList>() {};
    return apiClient.invokeAPI("OpportunitiesApi.getDocuments", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of sales actions for the given opportunity
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return SalesActionList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public SalesActionList getSalesActions(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getSalesActionsWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of sales actions for the given opportunity
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;SalesActionList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SalesActionList> getSalesActionsWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSalesActions");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/sales-actions"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "filter", filter)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<SalesActionList> localVarReturnType = new GenericType<SalesActionList>() {};
    return apiClient.invokeAPI("OpportunitiesApi.getSalesActions", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test products service
   * 
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public String ping() throws ApiException {
    return pingWithHttpInfo().getData();
  }

  /**
   * Test products service
   * 
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> pingWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("OpportunitiesApi.ping", "/opportunities/ping", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get an opportunity collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return OpportunityList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public OpportunityList query(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return queryWithHttpInfo(filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get an opportunity collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;OpportunityList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  * x-total-count - The total number of records <br>  * link - Link to the list <br>  * x-page-count - The total number of pages <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<OpportunityList> queryWithHttpInfo(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "filter", filter)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<OpportunityList> localVarReturnType = new GenericType<OpportunityList>() {};
    return apiClient.invokeAPI("OpportunitiesApi.query", "/opportunities", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Full update of an opportunity. If opportunity doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param opportunity Opportunity (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void update(Long id, Opportunity opportunity) throws ApiException {
    updateWithHttpInfo(id, opportunity);
  }

  /**
   * Full update of an opportunity. If opportunity doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param opportunity Opportunity (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateWithHttpInfo(Long id, Opportunity opportunity) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling update");
    }
    if (opportunity == null) {
      throw new ApiException(400, "Missing the required parameter 'opportunity' when calling update");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.update", localVarPath, "PUT", new ArrayList<>(), opportunity,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Full update of a comment. If comment doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @param comment Comment (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void updateComment(Long id, Long cid, Comment comment) throws ApiException {
    updateCommentWithHttpInfo(id, cid, comment);
  }

  /**
   * Full update of a comment. If comment doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @param comment Comment (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateCommentWithHttpInfo(Long id, Long cid, Comment comment) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateComment");
    }
    if (cid == null) {
      throw new ApiException(400, "Missing the required parameter 'cid' when calling updateComment");
    }
    if (comment == null) {
      throw new ApiException(400, "Missing the required parameter 'comment' when calling updateComment");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.updateComment", localVarPath, "PUT", new ArrayList<>(), comment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Full update of a opportunity document. If document doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param did did (required)
   * @param document Document (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void updateDocument(Long id, Long did, Document document) throws ApiException {
    updateDocumentWithHttpInfo(id, did, document);
  }

  /**
   * Full update of a opportunity document. If document doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param did did (required)
   * @param document Document (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateDocumentWithHttpInfo(Long id, Long did, Document document) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateDocument");
    }
    if (did == null) {
      throw new ApiException(400, "Missing the required parameter 'did' when calling updateDocument");
    }
    if (document == null) {
      throw new ApiException(400, "Missing the required parameter 'document' when calling updateDocument");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.updateDocument", localVarPath, "PUT", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of an opportunity
   * 
   * @param id id (required)
   * @param opportunity Opportunity (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void updatePartial(Long id, Opportunity opportunity) throws ApiException {
    updatePartialWithHttpInfo(id, opportunity);
  }

  /**
   * Partial update of an opportunity
   * 
   * @param id id (required)
   * @param opportunity Opportunity (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updatePartialWithHttpInfo(Long id, Opportunity opportunity) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartial");
    }
    if (opportunity == null) {
      throw new ApiException(400, "Missing the required parameter 'opportunity' when calling updatePartial");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.updatePartial", localVarPath, "POST", new ArrayList<>(), opportunity,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a comment
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @param comment Comment (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void updatePartialComment(Long id, Long cid, Comment comment) throws ApiException {
    updatePartialCommentWithHttpInfo(id, cid, comment);
  }

  /**
   * Partial update of a comment
   * 
   * @param id id (required)
   * @param cid cid (required)
   * @param comment Comment (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updatePartialCommentWithHttpInfo(Long id, Long cid, Comment comment) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartialComment");
    }
    if (cid == null) {
      throw new ApiException(400, "Missing the required parameter 'cid' when calling updatePartialComment");
    }
    if (comment == null) {
      throw new ApiException(400, "Missing the required parameter 'comment' when calling updatePartialComment");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.updatePartialComment", localVarPath, "POST", new ArrayList<>(), comment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a document opportunity
   * 
   * @param id id (required)
   * @param did did (required)
   * @param document Document (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void updatePartialDocument(Long id, Long did, Document document) throws ApiException {
    updatePartialDocumentWithHttpInfo(id, did, document);
  }

  /**
   * Partial update of a document opportunity
   * 
   * @param id id (required)
   * @param did did (required)
   * @param document Document (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updatePartialDocumentWithHttpInfo(Long id, Long did, Document document) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartialDocument");
    }
    if (did == null) {
      throw new ApiException(400, "Missing the required parameter 'did' when calling updatePartialDocument");
    }
    if (document == null) {
      throw new ApiException(400, "Missing the required parameter 'document' when calling updatePartialDocument");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.updatePartialDocument", localVarPath, "POST", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Upload physical file linked to the opportunity document
   * 
   * @param id id (required)
   * @param did did (required)
   * @param _file  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void uploadDocument(Long id, Long did, FormDataContentDisposition _file) throws ApiException {
    uploadDocumentWithHttpInfo(id, did, _file);
  }

  /**
   * Upload physical file linked to the opportunity document
   * 
   * @param id id (required)
   * @param did did (required)
   * @param _file  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> uploadDocumentWithHttpInfo(Long id, Long did, FormDataContentDisposition _file) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling uploadDocument");
    }
    if (did == null) {
      throw new ApiException(400, "Missing the required parameter 'did' when calling uploadDocument");
    }
    if (_file == null) {
      throw new ApiException(400, "Missing the required parameter '_file' when calling uploadDocument");
    }

    // Path parameters
    String localVarPath = "/opportunities/{id}/documents/{did}/upload"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("file", _file);

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("OpportunitiesApi.uploadDocument", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
