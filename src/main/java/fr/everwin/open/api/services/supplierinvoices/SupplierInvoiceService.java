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

package fr.everwin.open.api.services.supplierinvoices;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoice;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoiceList;
import fr.everwin.open.api.model.supplierinvoices.lines.SupplierInvoiceLine;
import fr.everwin.open.api.model.supplierinvoices.lines.SupplierInvoiceLineList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the supplierinvoice API resource
 *
 * @author everwin-team
 */
public class SupplierInvoiceService extends BasicService<SupplierInvoice, SupplierInvoiceList> {

    public static final String SUPPLIER_INVOICES = "supplier-invoices/";
    public static final String LINES = "/lines/";
    protected static final Logger LOGGER = LoggerFactory.getLogger(SupplierInvoiceService.class);

    public SupplierInvoiceService(ClientApi client) {
        super(client, "supplier-invoices");
        setModels(SupplierInvoice.class, SupplierInvoiceList.class);
    }

    /**
     * Create a new supplier invoice line for the object identified by the objectId
     *
     * @param id                  The id of the supplier invoice to link
     * @param supplierInvoiceLine The supplier invoice line
     * @throws CoreException If the request failed
     */
    public void createLine(long id, SupplierInvoiceLine supplierInvoiceLine) throws CoreException {
        try (Response response = clientApi.post(SUPPLIER_INVOICES + id + "/lines", supplierInvoiceLine)) {
            readResponse(response, String.class);
            // extract id from return location
            String locationUri = response.getHeaderString("Location");
            Long lineId = Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1));
            supplierInvoiceLine.setId(lineId);
        }
    }

    /**
     * Update only not null fields of the supplier invoice Line
     *
     * @param objectId            The id of the supplier invoice to link
     * @param supplierInvoiceLine The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updatePartiallyLine(long objectId, SupplierInvoiceLine supplierInvoiceLine) throws CoreException {
        try (Response response = clientApi.post(path + "/" + objectId + LINES + supplierInvoiceLine.getId(), supplierInvoiceLine)) {
            readResponse(response, String.class);
        }
    }

    /**
     * Update the supplier invoice Line for the supplier invoice identified by the id
     *
     * @param objectId            The id of the object to link
     * @param supplierInvoiceLine The supplier invoice line to update
     * @throws CoreException If the request failed
     */
    public void updateLine(long objectId, SupplierInvoiceLine supplierInvoiceLine) throws CoreException {
        try (Response response = clientApi.put(path + "/" + objectId + LINES + supplierInvoiceLine.getId(), supplierInvoiceLine)) {
            readResponse(response, String.class);
        }
    }

    /**
     * Delete the supplier invoice Line for the supplier invoice identified by the id
     *
     * @param objectId            The id of the supplier invoice
     * @param supplierInvoiceLine The Expense Sheet line to delet
     * @throws CoreException If the request failed
     */
    public void deleteLine(long objectId, SupplierInvoiceLine supplierInvoiceLine) throws CoreException {
        try (Response response = clientApi.delete(SUPPLIER_INVOICES + objectId + LINES + supplierInvoiceLine.getId())) {
            readResponse(response, String.class);
        }
    }

    /**
     * Get a collection of supplier invoice lines
     *
     * @param params   Extra parameters
     * @param objectId The linked supplier invoice id
     * @return SupplierInvoiceLineList
     * @throws CoreException If the request failed
     */
    public SupplierInvoiceLineList queryLines(long objectId, RequestParams params) throws CoreException {
        try (Response response = clientApi.get(SUPPLIER_INVOICES + objectId + "/lines", params)) {
            return (SupplierInvoiceLineList) readResponse(response, SupplierInvoiceLineList.class);
        }
    }

    /**
     * Get the supplier invoice line identified by id
     *
     * @param objectId The linked supplier invoices id
     * @param lineId   The line where we are taking the supplier invoices line
     * @return The supplier invoices line
     * @throws CoreException If the request failed
     */
    public SupplierInvoiceLine getLine(long objectId, long lineId) throws CoreException {
        try (Response response = clientApi.get(SUPPLIER_INVOICES + objectId + LINES + lineId, null)) {
            return (SupplierInvoiceLine) readResponse(response, SupplierInvoiceLine.class);
        }
    }
}
