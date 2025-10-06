package fr.everwin.sx.client.api;

import fr.everwin.sx.client.ApiClient;
import fr.everwin.sx.client.ApiException;
import fr.everwin.sx.client.ApiResponse;
import fr.everwin.sx.client.Configuration;
import fr.everwin.sx.client.Pair;
import fr.everwin.sx.client.model.Type;
import fr.everwin.sx.client.model.TypeList;
import jakarta.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@jakarta.annotation.Generated(value = "fr.everwin.sx.openapi.codegen.CustomJavaClientCodegen", date = "2025-10-06T08:58:20.555636300+02:00[Europe/Paris]")
public class LeaveRequestTypesApi {
  private ApiClient apiClient;

  public LeaveRequestTypesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public LeaveRequestTypesApi(ApiClient apiClient) {
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
   * Get a type of leave-request by id
   * 
   * @param id id (required)
   * @return Type
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
  public Type getTypeById(Long id) throws ApiException {
    return getTypeByIdWithHttpInfo(id).getData();
  }

  /**
   * Get a type of leave-request by id
   * 
   * @param id id (required)
   * @return ApiResponse&lt;Type&gt;
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
  public ApiResponse<Type> getTypeByIdWithHttpInfo(Long id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTypeById");
    }

    // Path parameters
    String localVarPath = "/leave-request-types/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<Type> localVarReturnType = new GenericType<Type>() {};
    return apiClient.invokeAPI("LeaveRequestTypesApi.getTypeById", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test types of leave-request service
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
  public String pingType() throws ApiException {
    return pingTypeWithHttpInfo().getData();
  }

  /**
   * Test types of leave-request service
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
  public ApiResponse<String> pingTypeWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("LeaveRequestTypesApi.pingType", "/leave-request-types/ping", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a type of leave-request collection
   * 
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @return TypeList
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
  public TypeList queryType(Integer offset, Integer limit) throws ApiException {
    return queryTypeWithHttpInfo(offset, limit).getData();
  }

  /**
   * Get a type of leave-request collection
   * 
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @return ApiResponse&lt;TypeList&gt;
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
  public ApiResponse<TypeList> queryTypeWithHttpInfo(Integer offset, Integer limit) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "offset", offset)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<TypeList> localVarReturnType = new GenericType<TypeList>() {};
    return apiClient.invokeAPI("LeaveRequestTypesApi.queryType", "/leave-request-types", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
