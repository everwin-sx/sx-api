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

package fr.everwin.open.api.services.supplierreceivingnote;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.supplierreceivingnotes.SupplierReceivingNote;
import fr.everwin.open.api.model.supplierreceivingnotes.SupplierReceivingNoteList;
import fr.everwin.open.api.model.supplierreceivingnotes.lines.SupplierReceivingNoteLine;
import fr.everwin.open.api.model.supplierreceivingnotes.lines.SupplierReceivingNoteLineList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class SupplierReceivingNoteService extends BasicService<SupplierReceivingNote, SupplierReceivingNoteList> {

    protected static final Logger LOGGER = LogManager.getLogger();
    public static final String SUPPLIER_RECEIVING_NOTES = "supplier-receiving-notes/";
    public static final String LINES = "/lines/";

    public SupplierReceivingNoteService(ClientApi client) {
        super(client, "supplier-receiving-notes");
        setModels(SupplierReceivingNote.class, SupplierReceivingNoteList.class);
    }

    /**
     * Create a new supplier invoice line for the object identified by the objectId
     * @param id The id of the supplier invoice to link
     * @param obj The supplier invoice line
     * @throws CoreException If the request failed
     */
    public void createLine(long id, SupplierReceivingNoteLine obj) throws CoreException {
        Response response = clientApi.post(SUPPLIER_RECEIVING_NOTES + id + "/lines", obj);
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
    public void updatePartiallyLine(long objectId, SupplierReceivingNoteLine obj) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + LINES + obj.getId(), obj);
        readResponse(response, String.class);
    }

    /**
     * Update the supplier invoice Line for the supplier invoice identified by the id
     * @param objectId The id of the object to link
     * @param obj The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updateLine(long objectId, SupplierReceivingNoteLine obj) throws CoreException {
        Response response = clientApi.put(path + "/" + objectId + LINES + obj.getId(), obj);
        readResponse(response, String.class);
    }

    /**
     * Delete the supplier invoice Line for the supplier invoice identified by the id
     * @param objectId The id of the supplier invoice
     * @param obj The Expense Sheet line to delet
     * @throws CoreException If the request failed
     */
    public void deleteLine(long objectId, SupplierReceivingNoteLine obj) throws CoreException {
        Response response = clientApi.delete(SUPPLIER_RECEIVING_NOTES + objectId + LINES + obj.getId());
        readResponse(response, String.class);
    }

    /**
     * Get a collection of supplier invoice lines
     * @param params Extra parameters
     * @param objectId The linked supplier invoice id
     * @return SupplierReceivingNoteLineList
     * @throws CoreException If the request failed
     */
    public SupplierReceivingNoteLineList queryLines(long objectId, RequestParams params) throws CoreException {
        Response response = clientApi.get(SUPPLIER_RECEIVING_NOTES + objectId + "/lines", params);
        return (SupplierReceivingNoteLineList) readResponse(response, SupplierReceivingNoteLineList.class);
    }

    /**
     * Get the supplier invoice line identified by id
     * @param objectId The linked supplier receiving id
     * @param lineId The line where we are taking the supplier receiving line
     * @return The supplier receiving line
     * @throws CoreException If the request failed
     */
    public SupplierReceivingNoteLine getLine(long objectId, long lineId) throws CoreException {
        Response response = clientApi.get(SUPPLIER_RECEIVING_NOTES + objectId + LINES + lineId, null);
        return (SupplierReceivingNoteLine) readResponse(response, SupplierReceivingNoteLine.class);
    }
}