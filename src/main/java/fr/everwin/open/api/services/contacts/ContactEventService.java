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

package fr.everwin.open.api.services.contacts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.contacts.events.ContactEvent;
import fr.everwin.open.api.model.contacts.events.ContactEventList;
import fr.everwin.open.api.services.core.BasicService;

/**
 * @author d.storti
 */
public class ContactEventService extends BasicService<ContactEvent, ContactEventList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public ContactEventService(ClientApi client) {
        super(client, "contact-responsibility-events");
        setModels(ContactEvent.class, ContactEventList.class);
    }
}