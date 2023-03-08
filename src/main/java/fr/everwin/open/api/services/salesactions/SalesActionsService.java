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

package fr.everwin.open.api.services.salesactions;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.salesactions.SalesAction;
import fr.everwin.open.api.model.salesactions.SalesActionList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.leads.LeadService;
import fr.everwin.open.api.util.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the sales actions API resource
 *
 * @author everwin-team
 */
public class SalesActionsService extends BasicService<SalesAction, SalesActionList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SalesActionsService.class);

    public SalesActionsService(ClientApi client) {
        super(client, "sales-actions");
        setModels(SalesAction.class, SalesActionList.class);
    }

    public LeadList queryLeadsFromSalesAction(SalesAction salesactions, RequestParams params) throws CoreException {
        LeadService service = new LeadService(clientApi);
        return service.query("sales-actions/" + salesactions.getId() + "/leads", params);
    }
}
