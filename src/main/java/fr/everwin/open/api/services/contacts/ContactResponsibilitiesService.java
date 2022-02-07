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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.contacts.ContactResponsibility;
import fr.everwin.open.api.model.contacts.ContactResponsibilityList;
import fr.everwin.open.api.model.contacts.events.ContactEvent;
import fr.everwin.open.api.model.contacts.events.ContactEventList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the contact responsabilities API resource
 * @author everwin-team
 */
public class ContactResponsibilitiesService extends BasicService<ContactResponsibility, ContactResponsibilityList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public ContactResponsibilitiesService(ClientApi client) {
        super(client, "contact-responsibilities");
        setModels(ContactResponsibility.class, ContactResponsibilityList.class);
    }

    public ContactEventList queryEventsFromResponsibility(ContactResponsibility responsibility, RequestParams params) throws CoreException {
        ContactEventService service = new ContactEventService(clientApi);
        return service.query(path + "/" + responsibility.getId() + "/events", params);
    }

    public ContactEventList queryEventFromResponsibility(ContactResponsibility responsibility, ContactEvent event, RequestParams params) throws CoreException {
        ContactEventService service = new ContactEventService(clientApi);
        return service.query(path + "/" + responsibility.getId() + "/events/" + event.getId(), params);
    }


}
