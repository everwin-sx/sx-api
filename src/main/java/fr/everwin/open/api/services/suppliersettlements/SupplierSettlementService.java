/*
 * Copyright (C) 2021 Everwin (www.everwin.fr)
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

package fr.everwin.open.api.services.suppliersettlements;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.suppliersettlement.SupplierSettlement;
import fr.everwin.open.api.model.suppliersettlement.SupplierSettlementList;
import fr.everwin.open.api.model.suppliersettlement.lines.SupplierSettlementLine;
import fr.everwin.open.api.model.suppliersettlement.lines.SupplierSettlementLineList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class SupplierSettlementService extends BasicService<SupplierSettlement, SupplierSettlementList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public SupplierSettlementService(ClientApi client) {
        super(client, "supplier-settlements");
        setModels(SupplierSettlement.class, SupplierSettlementList.class);
    }


    /**
     * Create a new supplier invoice line for the object identified by the objectId
     * @param id The id of the supplier invoice to link
     * @param SupplierSettlementLine The supplier invoice line
     * @return The id of the new supplier invoice line
     * @throws CoreException If the request failed
     */
    public void createLine(long id, SupplierSettlementLine SupplierSettlementLine) throws CoreException {
        Response response = clientApi.post("supplier-settlements/" + id + "/lines", SupplierSettlementLine);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        Long lineId = Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
        SupplierSettlementLine.setId(lineId);
    }

    /**
     * Update only not null fields of the supplier invoice Line
     * @param objectId The id of the supplier invoice to link
     * @param SupplierSettlementLine The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updatePartiallyLine(long objectId, SupplierSettlementLine SupplierSettlementLine) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/lines/" + SupplierSettlementLine.getId(), SupplierSettlementLine);
        readResponse(response, String.class);
    }

    /**
     * Update the supplier invoice Line for the supplier invoice identified by the id
     * @param objectId The id of the object to link
     * @param SupplierSettlementLine The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updateLine(long objectId, SupplierSettlementLine SupplierSettlementLine) throws CoreException {
        Response response = clientApi.put(path + "/" + objectId + "/lines/" + SupplierSettlementLine.getId(), SupplierSettlementLine);
        readResponse(response, String.class);
    }

    /**
     * Delete the supplier invoice Line for the supplier invoice identified by the id
     * @param objectId The id of the supplier invoice
     * @param SupplierSettlementLine The Expense Sheet line to delet
     * @throws CoreException If the request failed
     */
    public void deleteLine(long objectId, SupplierSettlementLine SupplierSettlementLine) throws CoreException {
        Response response = clientApi.delete("supplier-settlements/" + objectId + "/lines/" + SupplierSettlementLine.getId());
        readResponse(response, String.class);
    }

    /**
     * Get a collection of supplier invoice lines
     * @param params Extra parameters
     * @param objectId The linked supplier invoice id
     * @return SupplierSettlementLineList
     * @throws CoreException If the request failed
     */
    public SupplierSettlementLineList queryLines(long objectId, RequestParams params) throws CoreException {
        Response response = clientApi.get("supplier-settlement/" + objectId + "/lines", params);
        return (SupplierSettlementLineList) readResponse(response, SupplierSettlementLineList.class);
    }

    /**
     * Get the supplier invoice line identified by id
     * @param objectId The linked supplier settlement id
     * @param lineId The line where we are taking the supplier settlement line
     * @return The supplier settlement line
     * @throws CoreException If the request failed
     */
    public SupplierSettlementLine getLine(long objectId, long lineId) throws CoreException {
        Response response = clientApi.get("supplier-settlements/" + objectId + "/lines/" + lineId, null);
        return (SupplierSettlementLine) readResponse(response, SupplierSettlementLine.class);
    }
}