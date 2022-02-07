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

package fr.everwin.open.api.services.quotes.poa;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.quotes.poa.items.POAQuoteItem;
import fr.everwin.open.api.model.quotes.poa.items.POAQuoteItemList;
import fr.everwin.open.api.services.core.BasicService;

/**
 * @author d.storti
 */
public class POAQuoteItemService extends BasicService<POAQuoteItem, POAQuoteItemList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public POAQuoteItemService(ClientApi client) {
        super(client, "poa-quote-items");
        setModels(POAQuoteItem.class, POAQuoteItemList.class);
    }

    /*
    public SubItemList querySubFromItem(POAQuoteItem poaQuoteItem, RequestParams params) throws CoreException {
        SubItemService service = new SkillsService(clientApi);
        return service.query("poa-quote-items/" + poaQuoteItem.getId() +"/sub-items", params);
    }
    */


    /**
     * Update only not null fields of the document
     * @param objectId The id of the object linked to the comment
     * @param poaQuoteItem The document to update
     * @throws CoreException If the request failed
     */
    public void updatePOAQuote(long objectId, POAQuoteItem poaQuoteItem ) throws CoreException {
        Response response = clientApi.post("/poa-quote-item/" + objectId + "/sub-items", poaQuoteItem);
        readResponse(response, String.class);
    }
}