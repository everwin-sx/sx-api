package fr.everwin.sx.client.api;

import fr.everwin.sx.client.ApiClient;
import fr.everwin.sx.client.ApiException;
import fr.everwin.sx.client.ApiResponse;
import fr.everwin.sx.client.Configuration;
import fr.everwin.sx.client.Pair;
import fr.everwin.sx.client.model.Comment;
import fr.everwin.sx.client.model.CommentList;
import fr.everwin.sx.client.model.CustomerAssetList;
import fr.everwin.sx.client.model.Document;
import fr.everwin.sx.client.model.DocumentList;
import fr.everwin.sx.client.model.FormDataContentDisposition;
import fr.everwin.sx.client.model.Project;
import fr.everwin.sx.client.model.ProjectLineList;
import fr.everwin.sx.client.model.ProjectList;
import fr.everwin.sx.client.model.ProjectPhaseList;
import fr.everwin.sx.client.model.QuoteLines;
import jakarta.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "fr.everwin.sx.openapi.codegen.CustomJavaClientCodegen", date = "2025-05-22T08:24:46.022483900+02:00[Europe/Paris]")
public class ProjectsApi {
  private ApiClient apiClient;

  public ProjectsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProjectsApi(ApiClient apiClient) {
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
   * Cancel invoicing of the project
   * 
   * @param id id (required)
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
  public void cancelInvoicing(Long id) throws ApiException {
    cancelInvoicingWithHttpInfo(id);
  }

  /**
   * Cancel invoicing of the project
   * 
   * @param id id (required)
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
  public ApiResponse<Void> cancelInvoicingWithHttpInfo(Long id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling cancelInvoicing");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/invoicing/cancel"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.cancelInvoicing", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a project
   * 
   * @param project Project (required)
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
  public void create(Project project) throws ApiException {
    createWithHttpInfo(project);
  }

  /**
   * Create a project
   * 
   * @param project Project (required)
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
  public ApiResponse<Void> createWithHttpInfo(Project project) throws ApiException {
    // Check required parameters
    if (project == null) {
      throw new ApiException(400, "Missing the required parameter 'project' when calling create");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.create", "/projects", "POST", new ArrayList<>(), project,
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
    String localVarPath = "/projects/{id}/comments"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.createComment", localVarPath, "POST", new ArrayList<>(), comment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a new document for the project
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
   * Create a new document for the project
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
    String localVarPath = "/projects/{id}/documents"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.createDocument", localVarPath, "POST", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a quote from given lines ids
   * 
   * @param id id (required)
   * @param quoteLines ids (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public void createQuote(Long id, QuoteLines quoteLines) throws ApiException {
    createQuoteWithHttpInfo(id, quoteLines);
  }

  /**
   * Create a quote from given lines ids
   * 
   * @param id id (required)
   * @param quoteLines ids (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Created </td><td>  * Location - URL to created work unit <br>  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal Server error </td><td>  -  </td></tr>
       <tr><td> 503 </td><td> Service unavailable, try again later </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createQuoteWithHttpInfo(Long id, QuoteLines quoteLines) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling createQuote");
    }
    if (quoteLines == null) {
      throw new ApiException(400, "Missing the required parameter 'quoteLines' when calling createQuote");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/create-quote"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.createQuote", localVarPath, "POST", new ArrayList<>(), quoteLines,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a project
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
   * Delete a project
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
    String localVarPath = "/projects/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.delete", localVarPath, "DELETE", new ArrayList<>(), null,
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
    String localVarPath = "/projects/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.deleteComment", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a project document
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
   * Delete a project document
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
    String localVarPath = "/projects/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.deleteDocument", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get physical file linked to the project document
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
   * Get physical file linked to the project document
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
    String localVarPath = "/projects/{id}/documents/{did}/download"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.downloadDocument", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get a project by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return Project
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
  public Project getById(Long id, String fields) throws ApiException {
    return getByIdWithHttpInfo(id, fields).getData();
  }

  /**
   * Get a project by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;Project&gt;
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
  public ApiResponse<Project> getByIdWithHttpInfo(Long id, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getById");
    }

    // Path parameters
    String localVarPath = "/projects/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<Project> localVarReturnType = new GenericType<Project>() {};
    return apiClient.invokeAPI("ProjectsApi.getById", localVarPath, "GET", localVarQueryParams, null,
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
    String localVarPath = "/projects/{id}/comments/{cid}"
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
    return apiClient.invokeAPI("ProjectsApi.getCommentById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of comments for the given project
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
   * Get a collection of comments for the given project
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
    String localVarPath = "/projects/{id}/comments"
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
    return apiClient.invokeAPI("ProjectsApi.getComments", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of currencies for the given project
   * 
   * @param id id (required)
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
  public void getCurrencies(Long id) throws ApiException {
    getCurrenciesWithHttpInfo(id);
  }

  /**
   * Get a collection of currencies for the given project
   * 
   * @param id id (required)
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
  public ApiResponse<Void> getCurrenciesWithHttpInfo(Long id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getCurrencies");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/currencies"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.getCurrencies", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get a collection of customer assets for the given project
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return CustomerAssetList
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
  public CustomerAssetList getCustomerAssets(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getCustomerAssetsWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of customer assets for the given project
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;CustomerAssetList&gt;
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
  public ApiResponse<CustomerAssetList> getCustomerAssetsWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getCustomerAssets");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/customer-assets"
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
    GenericType<CustomerAssetList> localVarReturnType = new GenericType<CustomerAssetList>() {};
    return apiClient.invokeAPI("ProjectsApi.getCustomerAssets", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a project document by id
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
   * Get a project document by id
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
    String localVarPath = "/projects/{id}/documents/{did}"
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
    return apiClient.invokeAPI("ProjectsApi.getDocumentById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of documents for the given project
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
   * Get a collection of documents for the given project
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
    String localVarPath = "/projects/{id}/documents"
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
    return apiClient.invokeAPI("ProjectsApi.getDocuments", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of project phases for the given project
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ProjectPhaseList
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
  public ProjectPhaseList getPhases(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getPhasesWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of project phases for the given project
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;ProjectPhaseList&gt;
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
  public ApiResponse<ProjectPhaseList> getPhasesWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getPhases");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/phases"
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
    GenericType<ProjectPhaseList> localVarReturnType = new GenericType<ProjectPhaseList>() {};
    return apiClient.invokeAPI("ProjectsApi.getPhases", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of project lines for the given project
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ProjectLineList
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
  public ProjectLineList getProjectLines(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getProjectLinesWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of project lines for the given project
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;ProjectLineList&gt;
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
  public ApiResponse<ProjectLineList> getProjectLinesWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProjectLines");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/lines"
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
    GenericType<ProjectLineList> localVarReturnType = new GenericType<ProjectLineList>() {};
    return apiClient.invokeAPI("ProjectsApi.getProjectLines", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of OCR rowtype for the given project
   * 
   * @param id id (required)
   * @param ocrCategory ocrCategory (optional)
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
  public void getProjectRowtypesOCR(Long id, String ocrCategory) throws ApiException {
    getProjectRowtypesOCRWithHttpInfo(id, ocrCategory);
  }

  /**
   * Get a collection of OCR rowtype for the given project
   * 
   * @param id id (required)
   * @param ocrCategory ocrCategory (optional)
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
  public ApiResponse<Void> getProjectRowtypesOCRWithHttpInfo(Long id, String ocrCategory) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProjectRowtypesOCR");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/rowtypes/ocr"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "ocrCategory", ocrCategory)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.getProjectRowtypesOCR", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Invoicing to proforma
   * 
   * @param id id (required)
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
  public void invoicingProforma(Long id) throws ApiException {
    invoicingProformaWithHttpInfo(id);
  }

  /**
   * Invoicing to proforma
   * 
   * @param id id (required)
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
  public ApiResponse<Void> invoicingProformaWithHttpInfo(Long id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling invoicingProforma");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/invoicing/proforma"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.invoicingProforma", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Unvalidate invoicing of the project
   * 
   * @param id id (required)
   * @param projectLineId  (optional)
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
  public void invoicingUnvalidate(Long id, List<Long> projectLineId) throws ApiException {
    invoicingUnvalidateWithHttpInfo(id, projectLineId);
  }

  /**
   * Unvalidate invoicing of the project
   * 
   * @param id id (required)
   * @param projectLineId  (optional)
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
  public ApiResponse<Void> invoicingUnvalidateWithHttpInfo(Long id, List<Long> projectLineId) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling invoicingUnvalidate");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/invoicing/unvalidate"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("multi", "projectLineId", projectLineId)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.invoicingUnvalidate", localVarPath, "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Validate invoicing of the project
   * 
   * @param id id (required)
   * @param projectLineId  (optional)
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
  public void invoicingValidate(Long id, List<Long> projectLineId) throws ApiException {
    invoicingValidateWithHttpInfo(id, projectLineId);
  }

  /**
   * Validate invoicing of the project
   * 
   * @param id id (required)
   * @param projectLineId  (optional)
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
  public ApiResponse<Void> invoicingValidateWithHttpInfo(Long id, List<Long> projectLineId) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling invoicingValidate");
    }

    // Path parameters
    String localVarPath = "/projects/{id}/invoicing/validate"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("multi", "projectLineId", projectLineId)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.invoicingValidate", localVarPath, "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Test projects service
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
   * Test projects service
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
    return apiClient.invokeAPI("ProjectsApi.ping", "/projects/ping", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a projects collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ProjectList
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
  public ProjectList query(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return queryWithHttpInfo(filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a projects collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;ProjectList&gt;
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
  public ApiResponse<ProjectList> queryWithHttpInfo(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
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
    GenericType<ProjectList> localVarReturnType = new GenericType<ProjectList>() {};
    return apiClient.invokeAPI("ProjectsApi.query", "/projects", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Full update of a project. If project doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param project Project (required)
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
  public void update(Long id, Project project) throws ApiException {
    updateWithHttpInfo(id, project);
  }

  /**
   * Full update of a project. If project doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param project Project (required)
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
  public ApiResponse<Void> updateWithHttpInfo(Long id, Project project) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling update");
    }
    if (project == null) {
      throw new ApiException(400, "Missing the required parameter 'project' when calling update");
    }

    // Path parameters
    String localVarPath = "/projects/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.update", localVarPath, "PUT", new ArrayList<>(), project,
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
    String localVarPath = "/projects/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.updateComment", localVarPath, "PUT", new ArrayList<>(), comment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Full update of a project document. If document doesn&#39;t exist, it&#39;s created.
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
   * Full update of a project document. If document doesn&#39;t exist, it&#39;s created.
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
    String localVarPath = "/projects/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.updateDocument", localVarPath, "PUT", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a project
   * 
   * @param id id (required)
   * @param project Project (required)
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
  public void updatePartial(Long id, Project project) throws ApiException {
    updatePartialWithHttpInfo(id, project);
  }

  /**
   * Partial update of a project
   * 
   * @param id id (required)
   * @param project Project (required)
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
  public ApiResponse<Void> updatePartialWithHttpInfo(Long id, Project project) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartial");
    }
    if (project == null) {
      throw new ApiException(400, "Missing the required parameter 'project' when calling updatePartial");
    }

    // Path parameters
    String localVarPath = "/projects/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.updatePartial", localVarPath, "POST", new ArrayList<>(), project,
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
    String localVarPath = "/projects/{id}/comments/{cid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{cid}", apiClient.escapeString(cid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.updatePartialComment", localVarPath, "POST", new ArrayList<>(), comment,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a document project
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
   * Partial update of a document project
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
    String localVarPath = "/projects/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.updatePartialDocument", localVarPath, "POST", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Upload physical file linked to the project document
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
   * Upload physical file linked to the project document
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
    String localVarPath = "/projects/{id}/documents/{did}/upload"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("file", _file);

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ProjectsApi.uploadDocument", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
