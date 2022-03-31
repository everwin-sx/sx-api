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

package fr.everwin.open.api.services.expenses;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.documents.Document;
import fr.everwin.open.api.model.documents.DocumentList;
import fr.everwin.open.api.model.expenses.sheets.ExpenseSheet;
import fr.everwin.open.api.model.expenses.sheets.lines.ExpenseSheetLine;
import fr.everwin.open.api.model.expenses.sheets.lines.ExpenseSheetLineList;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.skills.SkillsService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class ExpenseSheetLineService extends BasicService<ExpenseSheetLine, ExpenseSheetLineList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ExpenseSheetLineService.class);

    public ExpenseSheetLineService(ClientApi client) {
        super(client, "expense-sheet-lines");
        setModels(ExpenseSheetLine.class, ExpenseSheetLineList.class);
    }

    public ExpenseSheetLineList queryLinesFromExpenseSheet(ExpenseSheet sheet, RequestParams params) throws CoreException {
        return query( "expense-sheets/" + sheet.getId() +"/lines", params);
    }

    public SkillList queryLinebyId(ExpenseSheet sheet, ExpenseSheetLine line, RequestParams params) throws CoreException {
        SkillsService skillsService = new SkillsService(clientApi);
        return skillsService.query( "expense-sheets/" + sheet.getId() +"/lines/" + line.getId(), params);
    }

    /**
     * Create a new expense sheet line for the object identified by the objectId
     * @param id The id of the object to link
     * @param expenseSheetLine The expense sheet line
     * @return The id of the new expense sheet line
     * @throws CoreException If the request failed
     */
    public long createLine(long id, ExpenseSheetLine expenseSheetLine) throws CoreException {
        Response response = clientApi.post(path + "/expense-sheets/" + id + "/lines", expenseSheetLine);
        readResponse(response, String.class);
        return expenseSheetLine.getId();
    }

    /**
     * Update only not null fields of the Expense Sheet Line
     * @param id The id of the object to link
     * @param expenseSheetLine The Expense Sheet line to update
     * @throws CoreException If the request failed
     */
    public void updatePartiallyLine(long id, ExpenseSheetLine expenseSheetLine) throws CoreException {
        Response response = clientApi.post(path + "/expense-sheets/" + id + "/lines/" + expenseSheetLine.getId(), expenseSheetLine);
        readResponse(response, String.class);
    }

    /**
     * Update the Expense Sheet Line for the object identified by the id
     * @param id The id of the object to link
     * @param expenseSheetLine The Expense Sheet line to update
     * @throws CoreException If the request failed
     */
    public void updateLine(long id, ExpenseSheetLine expenseSheetLine) throws CoreException {
        Response response = clientApi.put(path + "/expense-sheets/" + id + "/lines/" + expenseSheetLine.getId(), expenseSheetLine);
        readResponse(response, String.class);
    }

    /**
     * Delete the Expense Sheet Line for the object identified by the id
     * @param id The id of the object to link
     * @param expenseSheetLine The Expense Sheet line to delet
     * @throws CoreException If the request failed
     */
    public void deleteLine(long id, ExpenseSheetLine expenseSheetLine) throws CoreException {
        Response response = clientApi.delete(path + "/expense-sheets/" + id + "/lines/" + expenseSheetLine.getId());
        readResponse(response, String.class);
    }

    /**
     * Get a collection of Doucments
     * @param params Extra parameters
     * @param objectId The linked object id
     * @param line The line where we are taking the document
     * @return DocumentList
     * @throws CoreException If the request failed
     */
    public DocumentList queryDocument(long objectId, ExpenseSheetLine line, RequestParams params) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/lines/" + line.getId() + "/documents", params);
        return (DocumentList) readResponse(response, DocumentList.class);
    }

    /**
     * Get the document identified by its id
     * @param objectId The linked object id
     * @param id The document id
     * @param line The line where we are taking the document
     * @return The document
     * @throws CoreException If the request failed
     */
    public Document getDocument(long objectId, ExpenseSheetLine line, long id) throws CoreException {
        Response response = clientApi.get(path + "/" + objectId + "/lines/" + line.getId() + "/documents" + "/documents/" + id, null);
        return (Document) readResponse(response, Document.class);
    }

    /**
     * Create a new document for the object identified by the objectId
     * @param objectId The id of the object to link to the document
     * @param document The document to create
     * @param line The line where we are taking the document
     * @return The id of the new document
     * @throws CoreException If the request failed
     */
    public long createDocument(long objectId, ExpenseSheetLine line, Document document) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/lines/" + line.getId() + "/documents", document);
        readResponse(response, String.class);
        // extract id from return location
        String locationUri = response.getHeaderString("Location");
        Long id =  Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
        document.setId(id);
        return id;
    }

    /**
     * Update the document for the object identified by the id of the document
     * @param objectId The id of the object linked to the document
     * @param document The document to update
     * @param line The line where we are taking the document
     * @throws CoreException If the request failed
     */
    public void updateDocument(long objectId, ExpenseSheetLine line, Document document) throws CoreException {
        Response response = clientApi.put(path + "/" + objectId + "/lines/" + line.getId() + "/documents" + "/documents/" + document.getId(), document);
        readResponse(response, String.class);
    }

    /**
     * Update only not null fields of the document
     * @param objectId The id of the object linked to the document
     * @param document The document to update
     * @param line The line where we are taking the document
     * @throws CoreException If the request failed
     */
    public void updatePartiallyDocument(long objectId, ExpenseSheetLine line, Document document) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/lines/" + line.getId() + "/documents/" + document.getId(), document);
        readResponse(response, String.class);
    }

    /**
     * Delete the document for the object identified by the id of the document
     * @param objectId The id of the object linked to the document
     * @param id The document id to update
     * @param line The line where we are taking the document
     * @throws CoreException If the request failed
     */
    public void deleteDocument(long objectId, ExpenseSheetLine line, long id) throws CoreException {
        Response response = clientApi.delete(path + "/" + objectId + "/lines/" + line.getId() + "/documents" + "/documents/" + id);
        readResponse(response, String.class);
    }

    /**
     * upload the document for the object identified by the id of the document
     * @param objectId The id of the object linked to the document
     * @param id The document id to upload
     * @param line The line where we are taking the document
     * @throws CoreException If the request failed
     */
    public void uploadDocument(long objectId, ExpenseSheetLine line, long id) throws CoreException {

    }

    /**
     * download the document for the object identified by the id of the document
     * @param objectId The id of the object linked to the document
     * @param id The document id to download
     * @param line The line where we are taking the document
     * @throws CoreException If the request failed
     */
    public void downloadDocument(long objectId, ExpenseSheetLine line, long id) throws CoreException {

    }
}