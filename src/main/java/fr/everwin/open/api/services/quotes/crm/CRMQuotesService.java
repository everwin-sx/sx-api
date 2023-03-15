/*
 * Copyright (C) 2020 Everwin (www.everwin.fr)
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

package fr.everwin.open.api.services.quotes.crm;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.quotes.crm.CRMQuote;
import fr.everwin.open.api.model.quotes.crm.CRMQuoteList;
import fr.everwin.open.api.model.quotes.crm.lines.CRMQuoteLineList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the CRM quotes API resource
 *
 * @author everwin-team
 */
public class CRMQuotesService extends BasicService<CRMQuote, CRMQuoteList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(CRMQuotesService.class);

    public CRMQuotesService(ClientApi client) {
        super(client, "crm-quotes");
        setModels(CRMQuote.class, CRMQuoteList.class);
    }

    /**
     * Get a collection of supplier invoice lines
     *
     * @param params   Extra parameters
     * @param objectId The linked supplier invoice id
     * @return CRMQuoteLineList
     * @throws CoreException If the request failed
     */
    public CRMQuoteLineList queryLines(long objectId, RequestParams params) throws CoreException {
        try (Response response = clientApi.get("supplier-receiving/" + objectId + "/lines", params)) {
            return (CRMQuoteLineList) readResponse(response, CRMQuoteLineList.class);
        }
    }
}
