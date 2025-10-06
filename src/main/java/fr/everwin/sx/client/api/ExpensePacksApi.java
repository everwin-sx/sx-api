package fr.everwin.sx.client.api;

import fr.everwin.sx.client.ApiClient;
import fr.everwin.sx.client.ApiException;
import fr.everwin.sx.client.ApiResponse;
import fr.everwin.sx.client.Configuration;
import fr.everwin.sx.client.Pair;
import fr.everwin.sx.client.model.CopyData;
import fr.everwin.sx.client.model.ExpensePack;
import fr.everwin.sx.client.model.ExpensePackList;
import fr.everwin.sx.client.model.MissionOrderList;
import fr.everwin.sx.client.model.ProjectLineList;
import fr.everwin.sx.client.model.RowtypeListV3;
import jakarta.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@jakarta.annotation.Generated(value = "fr.everwin.sx.openapi.codegen.CustomJavaClientCodegen", date = "2025-10-06T08:58:20.555636300+02:00[Europe/Paris]")
public class ExpensePacksApi {
  private ApiClient apiClient;

  public ExpensePacksApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ExpensePacksApi(ApiClient apiClient) {
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
   * Create an expense pack
   * 
   * @param expensePack Expense pack (required)
   * @return ExpensePack
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
  public ExpensePack createExpensePack(ExpensePack expensePack) throws ApiException {
    return createExpensePackWithHttpInfo(expensePack).getData();
  }

  /**
   * Create an expense pack
   * 
   * @param expensePack Expense pack (required)
   * @return ApiResponse&lt;ExpensePack&gt;
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
  public ApiResponse<ExpensePack> createExpensePackWithHttpInfo(ExpensePack expensePack) throws ApiException {
    // Check required parameters
    if (expensePack == null) {
      throw new ApiException(400, "Missing the required parameter 'expensePack' when calling createExpensePack");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<ExpensePack> localVarReturnType = new GenericType<ExpensePack>() {};
    return apiClient.invokeAPI("ExpensePacksApi.createExpensePack", "/expense-packs", "POST", new ArrayList<>(), expensePack,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete an expense pack
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
  public void deleteExpensePack(Long id) throws ApiException {
    deleteExpensePackWithHttpInfo(id);
  }

  /**
   * Delete an expense pack
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
  public ApiResponse<Void> deleteExpensePackWithHttpInfo(Long id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteExpensePack");
    }

    // Path parameters
    String localVarPath = "/expense-packs/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("*/*");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ExpensePacksApi.deleteExpensePack", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Duplicate a expense pack on dates
   * 
   * @param id id (required)
   * @param copyData CopyData (required)
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
  public void duplicateExpensePack(Long id, CopyData copyData) throws ApiException {
    duplicateExpensePackWithHttpInfo(id, copyData);
  }

  /**
   * Duplicate a expense pack on dates
   * 
   * @param id id (required)
   * @param copyData CopyData (required)
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
  public ApiResponse<Void> duplicateExpensePackWithHttpInfo(Long id, CopyData copyData) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling duplicateExpensePack");
    }
    if (copyData == null) {
      throw new ApiException(400, "Missing the required parameter 'copyData' when calling duplicateExpensePack");
    }

    // Path parameters
    String localVarPath = "/expense-packs/{id}/duplicate"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ExpensePacksApi.duplicateExpensePack", localVarPath, "POST", new ArrayList<>(), copyData,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get a expense pack by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return ExpensePack
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
  public ExpensePack getExpensePackById(Long id, String fields) throws ApiException {
    return getExpensePackByIdWithHttpInfo(id, fields).getData();
  }

  /**
   * Get a expense pack by id
   * 
   * @param id id (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;ExpensePack&gt;
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
  public ApiResponse<ExpensePack> getExpensePackByIdWithHttpInfo(Long id, String fields) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getExpensePackById");
    }

    // Path parameters
    String localVarPath = "/expense-packs/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "fields", fields)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<ExpensePack> localVarReturnType = new GenericType<ExpensePack>() {};
    return apiClient.invokeAPI("ExpensePacksApi.getExpensePackById", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test expense pack service
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
  public String pingExpensePack() throws ApiException {
    return pingExpensePackWithHttpInfo().getData();
  }

  /**
   * Test expense pack service
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
  public ApiResponse<String> pingExpensePackWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("ExpensePacksApi.pingExpensePack", "/expense-packs/ping", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a expense pack collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ExpensePackList
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
  public ExpensePackList queryExpensePack(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
    return queryExpensePackWithHttpInfo(filter, sort, offset, limit, fields).getData();
  }

  /**
   * Get a expense pack collection
   * 
   * @param filter filter (optional)
   * @param sort sort (optional)
   * @param offset offset (optional)
   * @param limit limit (optional)
   * @param fields fields (optional)
   * @return ApiResponse&lt;ExpensePackList&gt;
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
  public ApiResponse<ExpensePackList> queryExpensePackWithHttpInfo(String filter, String sort, Integer offset, Integer limit, String fields) throws ApiException {
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
    GenericType<ExpensePackList> localVarReturnType = new GenericType<ExpensePackList>() {};
    return apiClient.invokeAPI("ExpensePacksApi.queryExpensePack", "/expense-packs", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get the mission orders linked to the project available for the employee and the date
   * 
   * @param date date (required)
   * @param emp emp (required)
   * @param prj prj (required)
   * @param fields fields (optional)
   * @return MissionOrderList
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
  public MissionOrderList queryExpensePackMissionOrders(java.time.LocalDateTime date, Long emp, Long prj, String fields) throws ApiException {
    return queryExpensePackMissionOrdersWithHttpInfo(date, emp, prj, fields).getData();
  }

  /**
   * Get the mission orders linked to the project available for the employee and the date
   * 
   * @param date date (required)
   * @param emp emp (required)
   * @param prj prj (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;MissionOrderList&gt;
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
  public ApiResponse<MissionOrderList> queryExpensePackMissionOrdersWithHttpInfo(java.time.LocalDateTime date, Long emp, Long prj, String fields) throws ApiException {
    // Check required parameters
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling queryExpensePackMissionOrders");
    }
    if (emp == null) {
      throw new ApiException(400, "Missing the required parameter 'emp' when calling queryExpensePackMissionOrders");
    }
    if (prj == null) {
      throw new ApiException(400, "Missing the required parameter 'prj' when calling queryExpensePackMissionOrders");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "date", date)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "emp", emp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "prj", prj));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<MissionOrderList> localVarReturnType = new GenericType<MissionOrderList>() {};
    return apiClient.invokeAPI("ExpensePacksApi.queryExpensePackMissionOrders", "/expense-packs/mission-orders", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get the project lines linked to the project available for the employee, the rowtype and the date
   * 
   * @param date date (required)
   * @param emp emp (required)
   * @param prj prj (required)
   * @param rty rty (required)
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
  public ProjectLineList queryExpensePackProjectLines(java.time.LocalDateTime date, Long emp, Long prj, Long rty, String fields) throws ApiException {
    return queryExpensePackProjectLinesWithHttpInfo(date, emp, prj, rty, fields).getData();
  }

  /**
   * Get the project lines linked to the project available for the employee, the rowtype and the date
   * 
   * @param date date (required)
   * @param emp emp (required)
   * @param prj prj (required)
   * @param rty rty (required)
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
  public ApiResponse<ProjectLineList> queryExpensePackProjectLinesWithHttpInfo(java.time.LocalDateTime date, Long emp, Long prj, Long rty, String fields) throws ApiException {
    // Check required parameters
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling queryExpensePackProjectLines");
    }
    if (emp == null) {
      throw new ApiException(400, "Missing the required parameter 'emp' when calling queryExpensePackProjectLines");
    }
    if (prj == null) {
      throw new ApiException(400, "Missing the required parameter 'prj' when calling queryExpensePackProjectLines");
    }
    if (rty == null) {
      throw new ApiException(400, "Missing the required parameter 'rty' when calling queryExpensePackProjectLines");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "date", date)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "emp", emp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "prj", prj));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rty", rty));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<ProjectLineList> localVarReturnType = new GenericType<ProjectLineList>() {};
    return apiClient.invokeAPI("ExpensePacksApi.queryExpensePackProjectLines", "/expense-packs/project-lines", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get the expense packs types linked to the project available for the employee, the missform and the date
   * 
   * @param date date (required)
   * @param emp emp (required)
   * @param prj prj (required)
   * @param msf msf (required)
   * @param rxp rxp (required)
   * @param fields fields (optional)
   * @return RowtypeListV3
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
  public RowtypeListV3 queryTypes(java.time.LocalDateTime date, Long emp, Long prj, Long msf, Long rxp, String fields) throws ApiException {
    return queryTypesWithHttpInfo(date, emp, prj, msf, rxp, fields).getData();
  }

  /**
   * Get the expense packs types linked to the project available for the employee, the missform and the date
   * 
   * @param date date (required)
   * @param emp emp (required)
   * @param prj prj (required)
   * @param msf msf (required)
   * @param rxp rxp (required)
   * @param fields fields (optional)
   * @return ApiResponse&lt;RowtypeListV3&gt;
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
  public ApiResponse<RowtypeListV3> queryTypesWithHttpInfo(java.time.LocalDateTime date, Long emp, Long prj, Long msf, Long rxp, String fields) throws ApiException {
    // Check required parameters
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling queryTypes");
    }
    if (emp == null) {
      throw new ApiException(400, "Missing the required parameter 'emp' when calling queryTypes");
    }
    if (prj == null) {
      throw new ApiException(400, "Missing the required parameter 'prj' when calling queryTypes");
    }
    if (msf == null) {
      throw new ApiException(400, "Missing the required parameter 'msf' when calling queryTypes");
    }
    if (rxp == null) {
      throw new ApiException(400, "Missing the required parameter 'rxp' when calling queryTypes");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "date", date)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "emp", emp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "prj", prj));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "msf", msf));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rxp", rxp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    GenericType<RowtypeListV3> localVarReturnType = new GenericType<RowtypeListV3>() {};
    return apiClient.invokeAPI("ExpensePacksApi.queryTypes", "/expense-packs/types", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Full update of an expense pack. If expense pack doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param expensePack ExpensePack (required)
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
  public void updateExpensePack(Long id, ExpensePack expensePack) throws ApiException {
    updateExpensePackWithHttpInfo(id, expensePack);
  }

  /**
   * Full update of an expense pack. If expense pack doesn&#39;t exist, it&#39;s created.
   * 
   * @param id id (required)
   * @param expensePack ExpensePack (required)
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
  public ApiResponse<Void> updateExpensePackWithHttpInfo(Long id, ExpensePack expensePack) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateExpensePack");
    }
    if (expensePack == null) {
      throw new ApiException(400, "Missing the required parameter 'expensePack' when calling updateExpensePack");
    }

    // Path parameters
    String localVarPath = "/expense-packs/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ExpensePacksApi.updateExpensePack", localVarPath, "PUT", new ArrayList<>(), expensePack,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Partial update of an expense pack
   * 
   * @param id id (required)
   * @param expensePack ExpensePack (required)
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
  public void updatePartialExpensePack(Long id, ExpensePack expensePack) throws ApiException {
    updatePartialExpensePackWithHttpInfo(id, expensePack);
  }

  /**
   * Partial update of an expense pack
   * 
   * @param id id (required)
   * @param expensePack ExpensePack (required)
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
  public ApiResponse<Void> updatePartialExpensePackWithHttpInfo(Long id, ExpensePack expensePack) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updatePartialExpensePack");
    }
    if (expensePack == null) {
      throw new ApiException(400, "Missing the required parameter 'expensePack' when calling updatePartialExpensePack");
    }

    // Path parameters
    String localVarPath = "/expense-packs/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json;charset=utf-8");
    String localVarContentType = apiClient.selectHeaderContentType("application/json;charset=utf-8");
    String[] localVarAuthNames = new String[] {"api_key", "oauth"};
    return apiClient.invokeAPI("ExpensePacksApi.updatePartialExpensePack", localVarPath, "POST", new ArrayList<>(), expensePack,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
