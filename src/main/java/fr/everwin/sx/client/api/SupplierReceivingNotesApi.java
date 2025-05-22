package fr.everwin.sx.client.api;

import fr.everwin.sx.client.ApiClient;
import fr.everwin.sx.client.ApiException;
import fr.everwin.sx.client.ApiResponse;
import fr.everwin.sx.client.Configuration;
import fr.everwin.sx.client.Pair;
import fr.everwin.sx.client.model.Document;
import fr.everwin.sx.client.model.DocumentList;
import fr.everwin.sx.client.model.FormDataContentDisposition;
import fr.everwin.sx.client.model.SupplierReceivingNote;
import fr.everwin.sx.client.model.SupplierReceivingNoteLine;
import fr.everwin.sx.client.model.SupplierReceivingNoteLineList;
import fr.everwin.sx.client.model.SupplierReceivingNoteList;
import jakarta.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "fr.everwin.sx.openapi.codegen.CustomJavaClientCodegen", date = "2025-05-22T08:24:46.022483900+02:00[Europe/Paris]")
public class SupplierReceivingNotesApi {
  private ApiClient apiClient;

  public SupplierReceivingNotesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SupplierReceivingNotesApi(ApiClient apiClient) {
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
   * Create a supplier delivery
   * 
   * @param supplierReceivingNote SupplierReceivingNote (required)
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
  public void create(SupplierReceivingNote supplierReceivingNote) throws ApiException {
    createWithHttpInfo(supplierReceivingNote);
  }

  /**
   * Create a supplier delivery
   * 
   * @param supplierReceivingNote SupplierReceivingNote (required)
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
  public ApiResponse<Void> createWithHttpInfo(SupplierReceivingNote supplierReceivingNote) throws ApiException {
    // Check required parameters
    if (supplierReceivingNote == null) {
      throw new ApiException(400, "Missing the required parameter 'supplierReceivingNote' when calling create");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.create", "/supplier-receiving-notes", "POST", new ArrayList<>(), supplierReceivingNote,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a new document for the supplier delivery
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
   * Create a new document for the supplier delivery
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.createDocument", localVarPath, "POST", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Create a supplier delivery Line for a supplier delivery
   * 
   * @param id id (required)
   * @param supplierReceivingNoteLine SupplierReceivingNoteLine (required)
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
  public void createSupplierReceivingNoteLine(Long id, SupplierReceivingNoteLine supplierReceivingNoteLine) throws ApiException {
    createSupplierReceivingNoteLineWithHttpInfo(id, supplierReceivingNoteLine);
  }

  /**
   * Create a supplier delivery Line for a supplier delivery
   * 
   * @param id id (required)
   * @param supplierReceivingNoteLine SupplierReceivingNoteLine (required)
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
  public ApiResponse<Void> createSupplierReceivingNoteLineWithHttpInfo(Long id, SupplierReceivingNoteLine supplierReceivingNoteLine) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling createSupplierReceivingNoteLine");
    }
    if (supplierReceivingNoteLine == null) {
      throw new ApiException(400, "Missing the required parameter 'supplierReceivingNoteLine' when calling createSupplierReceivingNoteLine");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}/lines"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.createSupplierReceivingNoteLine", localVarPath, "POST", new ArrayList<>(), supplierReceivingNoteLine,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a supplier delivery
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
   * Delete a supplier delivery
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
    String localVarPath = "/supplier-receiving-notes/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.delete", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a supplier delivery document
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
   * Delete a supplier delivery document
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.deleteDocument", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete a supplier delivery Line  for a supplier delivery
   * 
   * @param id id (required)
   * @param lineid lineid (required)
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
  public void deleteSupplierReceivingNoteLine(Long id, Long lineid) throws ApiException {
    deleteSupplierReceivingNoteLineWithHttpInfo(id, lineid);
  }

  /**
   * Delete a supplier delivery Line  for a supplier delivery
   * 
   * @param id id (required)
   * @param lineid lineid (required)
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
  public ApiResponse<Void> deleteSupplierReceivingNoteLineWithHttpInfo(Long id, Long lineid) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteSupplierReceivingNoteLine");
    }
    if (lineid == null) {
      throw new ApiException(400, "Missing the required parameter 'lineid' when calling deleteSupplierReceivingNoteLine");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}/lines/{lineid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{lineid}", apiClient.escapeString(lineid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.deleteSupplierReceivingNoteLine", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get physical file linked to the supplier delivery document
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
   * Get physical file linked to the supplier delivery document
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents/{did}/download"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.downloadDocument", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get a supplier delivery by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return SupplierReceivingNote
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
  public SupplierReceivingNote getById(Long id, String fields) throws ApiException {
    return getByIdWithHttpInfo(id, fields).getData();
  }

  /**
   * Get a supplier delivery by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;SupplierReceivingNote&gt;
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
  public ApiResponse<SupplierReceivingNote> getByIdWithHttpInfo(Long id, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getById");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<SupplierReceivingNote> localVarReturnType = new GenericType<SupplierReceivingNote>() {};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.getById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a supplier delivery document by id
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
   * Get a supplier delivery document by id
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents/{did}"
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
    return apiClient.invokeAPI("SupplierReceivingNotesApi.getDocumentById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of documents for the given supplier delivery
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
   * Get a collection of documents for the given supplier delivery
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents"
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
    return apiClient.invokeAPI("SupplierReceivingNotesApi.getDocuments", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a supplier delivery line for the given supplier delivery
   * 
   * @param id id (required)
   * @param lineid lineid (required)
   * @param fields fields (optional)
   * @return SupplierReceivingNoteLine
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
  public SupplierReceivingNoteLine getSupplierReceivingNoteLineById(Long id, Long lineid, String fields) throws ApiException {
    return getSupplierReceivingNoteLineByIdWithHttpInfo(id, lineid, fields).getData();
  }

  /**
   * Get a supplier delivery line for the given supplier delivery
   * 
   * @param id id (required)
   * @param lineid lineid (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;SupplierReceivingNoteLine&gt;
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
  public ApiResponse<SupplierReceivingNoteLine> getSupplierReceivingNoteLineByIdWithHttpInfo(Long id, Long lineid, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSupplierReceivingNoteLineById");
    }
    if (lineid == null) {
      throw new ApiException(400, "Missing the required parameter 'lineid' when calling getSupplierReceivingNoteLineById");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}/lines/{lineid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{lineid}", apiClient.escapeString(lineid.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<SupplierReceivingNoteLine> localVarReturnType = new GenericType<SupplierReceivingNoteLine>() {};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.getSupplierReceivingNoteLineById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a collection of supplier delivery lines for the given supplier delivery
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return SupplierReceivingNoteLineList
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
  public SupplierReceivingNoteLineList getSupplierReceivingNoteLines(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return getSupplierReceivingNoteLinesWithHttpInfo(id, filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a collection of supplier delivery lines for the given supplier delivery
   * 
   * @param id id (required)
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;SupplierReceivingNoteLineList&gt;
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
  public ApiResponse<SupplierReceivingNoteLineList> getSupplierReceivingNoteLinesWithHttpInfo(Long id, String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSupplierReceivingNoteLines");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}/lines"
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
    GenericType<SupplierReceivingNoteLineList> localVarReturnType = new GenericType<SupplierReceivingNoteLineList>() {};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.getSupplierReceivingNoteLines", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test Supplier Deliveries service
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
   * Test Supplier Deliveries service
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
    return apiClient.invokeAPI("SupplierReceivingNotesApi.ping", "/supplier-receiving-notes/ping", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a supplier deliveries collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return SupplierReceivingNoteList
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
  public SupplierReceivingNoteList query(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return queryWithHttpInfo(filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a supplier deliveries collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;SupplierReceivingNoteList&gt;
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
  public ApiResponse<SupplierReceivingNoteList> queryWithHttpInfo(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
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
    GenericType<SupplierReceivingNoteList> localVarReturnType = new GenericType<SupplierReceivingNoteList>() {};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.query", "/supplier-receiving-notes", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Full update of a supplier delivery. If supplier delivery doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param supplierReceivingNote SupplierReceivingNote (required)
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
  public void update(Long id, SupplierReceivingNote supplierReceivingNote) throws ApiException {
    updateWithHttpInfo(id, supplierReceivingNote);
  }

  /**
   * Full update of a supplier delivery. If supplier delivery doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param supplierReceivingNote SupplierReceivingNote (required)
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
  public ApiResponse<Void> updateWithHttpInfo(Long id, SupplierReceivingNote supplierReceivingNote) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling update");
    }
    if (supplierReceivingNote == null) {
      throw new ApiException(400, "Missing the required parameter 'supplierReceivingNote' when calling update");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.update", localVarPath, "PUT", new ArrayList<>(), supplierReceivingNote,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Full update of a supplier delivery document. If document doesn&#39;t exist, it&#39;s created.
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
   * Full update of a supplier delivery document. If document doesn&#39;t exist, it&#39;s created.
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.updateDocument", localVarPath, "PUT", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a supplier delivery
   * 
   * @param id id (required)
   * @param supplierReceivingNote SupplierReceivingNote (required)
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
  public void updatePartial(Long id, SupplierReceivingNote supplierReceivingNote) throws ApiException {
    updatePartialWithHttpInfo(id, supplierReceivingNote);
  }

  /**
   * Partial update of a supplier delivery
   * 
   * @param id id (required)
   * @param supplierReceivingNote SupplierReceivingNote (required)
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
  public ApiResponse<Void> updatePartialWithHttpInfo(Long id, SupplierReceivingNote supplierReceivingNote) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartial");
    }
    if (supplierReceivingNote == null) {
      throw new ApiException(400, "Missing the required parameter 'supplierReceivingNote' when calling updatePartial");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.updatePartial", localVarPath, "POST", new ArrayList<>(), supplierReceivingNote,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a document supplier delivery
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
   * Partial update of a document supplier delivery
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents/{did}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.updatePartialDocument", localVarPath, "POST", new ArrayList<>(), document,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of a supplier delivery Line  for a supplier delivery
   * 
   * @param id id (required)
   * @param lineid lineid (required)
   * @param supplierReceivingNoteLine SupplierReceivingNoteLine (required)
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
  public void updatePartialSupplierReceivingNoteLine(Long id, Long lineid, SupplierReceivingNoteLine supplierReceivingNoteLine) throws ApiException {
    updatePartialSupplierReceivingNoteLineWithHttpInfo(id, lineid, supplierReceivingNoteLine);
  }

  /**
   * Partial update of a supplier delivery Line  for a supplier delivery
   * 
   * @param id id (required)
   * @param lineid lineid (required)
   * @param supplierReceivingNoteLine SupplierReceivingNoteLine (required)
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
  public ApiResponse<Void> updatePartialSupplierReceivingNoteLineWithHttpInfo(Long id, Long lineid, SupplierReceivingNoteLine supplierReceivingNoteLine) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartialSupplierReceivingNoteLine");
    }
    if (lineid == null) {
      throw new ApiException(400, "Missing the required parameter 'lineid' when calling updatePartialSupplierReceivingNoteLine");
    }
    if (supplierReceivingNoteLine == null) {
      throw new ApiException(400, "Missing the required parameter 'supplierReceivingNoteLine' when calling updatePartialSupplierReceivingNoteLine");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}/lines/{lineid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{lineid}", apiClient.escapeString(lineid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.updatePartialSupplierReceivingNoteLine", localVarPath, "POST", new ArrayList<>(), supplierReceivingNoteLine,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Full update of a supplier delivery line for a supplier delivery. If supplier delivery Line doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param lineid lineid (required)
   * @param supplierReceivingNoteLine SupplierReceivingNoteLine (required)
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
  public void updateSupplierReceivingNoteLine(Long id, Long lineid, SupplierReceivingNoteLine supplierReceivingNoteLine) throws ApiException {
    updateSupplierReceivingNoteLineWithHttpInfo(id, lineid, supplierReceivingNoteLine);
  }

  /**
   * Full update of a supplier delivery line for a supplier delivery. If supplier delivery Line doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param lineid lineid (required)
   * @param supplierReceivingNoteLine SupplierReceivingNoteLine (required)
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
  public ApiResponse<Void> updateSupplierReceivingNoteLineWithHttpInfo(Long id, Long lineid, SupplierReceivingNoteLine supplierReceivingNoteLine) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateSupplierReceivingNoteLine");
    }
    if (lineid == null) {
      throw new ApiException(400, "Missing the required parameter 'lineid' when calling updateSupplierReceivingNoteLine");
    }
    if (supplierReceivingNoteLine == null) {
      throw new ApiException(400, "Missing the required parameter 'supplierReceivingNoteLine' when calling updateSupplierReceivingNoteLine");
    }

    // Path parameters
    String localVarPath = "/supplier-receiving-notes/{id}/lines/{lineid}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{lineid}", apiClient.escapeString(lineid.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.updateSupplierReceivingNoteLine", localVarPath, "PUT", new ArrayList<>(), supplierReceivingNoteLine,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Upload physical file linked to the supplier delivery document
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
   * Upload physical file linked to the supplier delivery document
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
    String localVarPath = "/supplier-receiving-notes/{id}/documents/{did}/upload"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{did}", apiClient.escapeString(did.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("file", _file);

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("SupplierReceivingNotesApi.uploadDocument", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
