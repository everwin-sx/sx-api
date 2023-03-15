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

package fr.everwin.open.api.services.contacts;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.contacts.ContactResponsibilityList;
import fr.everwin.open.api.model.contacts.Person;
import fr.everwin.open.api.model.contacts.PersonList;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.salesactions.SalesActionList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.leads.LeadService;
import fr.everwin.open.api.services.salesactions.SalesActionsService;
import fr.everwin.open.api.util.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the persons / contacts API resource
 *
 * @author everwin-team
 */
public class PersonsService extends BasicService<Person, PersonList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(PersonsService.class);

    public PersonsService(ClientApi client) {
        super(client, "contacts");
        setModels(Person.class, PersonList.class);
    }

    public ContactResponsibilityList queryResponsabilitiesFromPerson(Person person, RequestParams params) throws CoreException {
        ContactResponsibilitiesService service = new ContactResponsibilitiesService(clientApi);
        return service.query(path + "/" + person.getId() + "/responsibilities", params);
    }

    public SalesActionList querySAForContact(Person contact, RequestParams params) throws CoreException {
        SalesActionsService service = new SalesActionsService(clientApi);
        return service.query(path + "/" + contact.getId() + "/sales-actions", params);
    }

    public LeadList queryLeadsFromContact(Person contact, RequestParams params) throws CoreException {
        LeadService service = new LeadService(clientApi);
        return service.query("contacts/" + contact.getId() + "/leads", params);
    }
}
