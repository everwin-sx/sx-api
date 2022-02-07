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

package fr.everwin.open.api.services.opportunities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.opportunities.Opportunity;
import fr.everwin.open.api.model.opportunities.OpportunityList;
import fr.everwin.open.api.model.salesactions.SalesActionList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.leads.LeadService;
import fr.everwin.open.api.services.salesactions.SalesActionsService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the opportunity API resource
 * @author everwin-team
 */
public class OpportunitiesService extends BasicService<Opportunity, OpportunityList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public OpportunitiesService(ClientApi client){
        super(client, "opportunities");
        setModels(Opportunity.class, OpportunityList.class);
    }

    public SalesActionList querySAForOpportinity(Opportunity opportunity, RequestParams params) throws CoreException {
        SalesActionsService service = new SalesActionsService(clientApi);
        return service.query(path + "/" + opportunity.getId() + "/sales-actions", params);
    }

    public LeadList queryLeadsFromOpportunity(Opportunity opportunity, RequestParams params) throws CoreException {
        LeadService service = new LeadService(clientApi);
        return service.query(path + "/" + opportunity.getId() +"/leads", params);
    }
}
