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

package fr.everwin.open.api.services.supplierorders;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.supplierorders.SupplierOrder;
import fr.everwin.open.api.model.supplierorders.SupplierOrderList;
import fr.everwin.open.api.model.supplierorders.lines.SupplierOrderLine;
import fr.everwin.open.api.model.supplierorders.lines.SupplierOrderLineList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the supplierorder API resource
 * @author everwin-team
 */
public class SupplierOrderService extends BasicService<SupplierOrder, SupplierOrderList> {

    protected static final Logger LOGGER = LogManager.getLogger();
    public static final String SUPPLIER_RECEIVING = "supplier-receiving/";
    public static final String LINES = "/lines/";

    public SupplierOrderService(ClientApi client){
        super(client, "supplier-orders");
        setModels(SupplierOrder.class, SupplierOrderList.class);
    }

    /**
     * Create a new supplier invoice line for the object identified by the objectId
     * @param id The id of the supplier invoice to link
     * @param obj The supplier invoice line
     * @throws CoreException If the request failed
     */
    public void createLine(long id, SupplierOrderLine obj) throws CoreException {
        Response response = clientApi.post(SUPPLIER_RECEIVING + id + "/lines", obj);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        Long lineId = Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1));
        obj.setId(lineId);
    }

    /**
     * Update only not null fields of the supplier invoice Line
     * @param objectId The id of the supplier invoice to link
     * @param obj The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updatePartiallyLine(long objectId, SupplierOrderLine obj) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + LINES + obj.getId(), obj);
        readResponse(response, String.class);
    }

    /**
     * Update the supplier invoice Line for the supplier invoice identified by the id
     * @param objectId The id of the object to link
     * @param obj The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updateLine(long objectId, SupplierOrderLine obj) throws CoreException {
        Response response = clientApi.put(path + "/" + objectId + LINES + obj.getId(), obj);
        readResponse(response, String.class);
    }

    /**
     * Delete the supplier invoice Line for the supplier invoice identified by the id
     * @param objectId The id of the supplier invoice
     * @param obj The Expense Sheet line to delet
     * @throws CoreException If the request failed
     */
    public void deleteLine(long objectId, SupplierOrderLine obj) throws CoreException {
        Response response = clientApi.delete(SUPPLIER_RECEIVING + objectId + LINES + obj.getId());
        readResponse(response, String.class);
    }

    /**
     * Get a collection of supplier invoice lines
     * @param params Extra parameters
     * @param objectId The linked supplier invoice id
     * @return SupplierOrderLineList
     * @throws CoreException If the request failed
     */
    public SupplierOrderLineList queryLines(long objectId, RequestParams params) throws CoreException {
        Response response = clientApi.get(SUPPLIER_RECEIVING + objectId + "/lines", params);
        return (SupplierOrderLineList) readResponse(response, SupplierOrderLineList.class);
    }

    /**
     * Get the supplier invoice line identified by id
     * @param objectId The linked supplier receiving id
     * @param lineId The line where we are taking the supplier receiving line
     * @return The supplier receiving line
     * @throws CoreException If the request failed
     */
    public SupplierOrderLine getLine(long objectId, long lineId) throws CoreException {
        Response response = clientApi.get(SUPPLIER_RECEIVING + objectId + LINES + lineId, null);
        return (SupplierOrderLine) readResponse(response, SupplierOrderLine.class);
    }
}
