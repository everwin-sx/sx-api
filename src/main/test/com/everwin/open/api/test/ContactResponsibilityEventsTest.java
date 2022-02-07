/*
 * Copyright (C) 2022 Everwin (www.everwin.fr)
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

package com.everwin.open.api.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.model.contacts.events.ContactEvent;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.contacts.ContactEventService;

/**
 * @author d.storti
 */
public class ContactResponsibilityEventsTest extends BasicTest<ContactEvent, ContactEventService> {

    private final long CEVCOC = 162632; //contact responsibility

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ContactEventService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected ContactEvent initObject() {
        ContactEvent event = new ContactEvent();
        event.setType("TYPE01");
        event.setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime());
        event.setEvent("Unit_event_test_001");
        event.setContactResponsibility(new DataLink(CEVCOC, ""));
        return event;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setType("TYPE02");
    }

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }
}
