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

package fr.everwin.open.api.services.leads;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.candidates.Candidate;
import fr.everwin.open.api.model.companies.Company;
import fr.everwin.open.api.model.contacts.Person;
import fr.everwin.open.api.model.employees.Employee;
import fr.everwin.open.api.model.leads.Lead;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.leads.events.LeadEvent;
import fr.everwin.open.api.model.leads.events.LeadEventList;
import fr.everwin.open.api.model.opportunities.Opportunity;
import fr.everwin.open.api.model.salesactions.SalesAction;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.skills.SkillsService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class LeadService extends BasicService<Lead, LeadList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public LeadService(ClientApi client) {
        super(client, "leads");
        setModels(Lead.class, LeadList.class);
    }

    public LeadList queryLeadsFromOpportunity(Opportunity opportunity, RequestParams params) throws CoreException {
        return query("opportunities/" + opportunity.getId() +"/leads", params);
    }

    public LeadList queryLeadsFromCompany(Company company, RequestParams params) throws CoreException {
        return query("companies/" + company.getId() +"/leads", params);
    }

    public LeadList queryLeadsFromContact(Person contact, RequestParams params) throws CoreException {
        return query("contacts/" + contact.getId() +"/leads", params);
    }

    public LeadList queryLeadsFromEmployee(Employee employee, RequestParams params) throws CoreException {
        return query("employee/" + employee.getId() +"/leads", params);
    }

    public LeadList queryLeadsFromSalesAction(SalesAction salesactions, RequestParams params) throws CoreException {
        return query("sales-actions/" + salesactions.getId() +"/leads", params);
    }

    public LeadEventList queryLeadEvents(Lead lead, RequestParams params) throws CoreException {
        LeadEventService service = new LeadEventService(clientApi);
        return service.query("leads/" + lead.getId() +"/lead-events", params);
    }

    public LeadEventList queryLeadEventById(Lead lead, LeadEvent leadEvent, RequestParams params) throws CoreException {
        LeadEventService service = new LeadEventService(clientApi);
        return service.query("leads/" + lead.getId() +"/lead-event/" + leadEvent.getId(), params);
    }
}