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

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.contacts.ContactResponsibility;
import fr.everwin.open.api.model.contacts.events.ContactEvent;
import fr.everwin.open.api.model.contacts.events.ContactEventList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.contacts.ContactEventService;
import fr.everwin.open.api.services.contacts.ContactResponsibilitiesService;

/**
 * @author d.storti
 */
public class ContactResponsibilityTest extends BasicTest<ContactResponsibility, ContactResponsibilitiesService> {


	private final Long COCCUC = 162105L; // company
	private final long PERSON = 36652; // ???

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ContactResponsibilitiesService(clientApi);
		ws_rights = "RWCDS";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected ContactResponsibility initObject() {
		ContactResponsibility contact = new ContactResponsibility();
		contact.setPerson(new DataLink(PERSON, ""));       // ???????
		contact.setFirstName("John");
		contact.setLastName("Smith");
		contact.setCivility(Short.valueOf("1"));
		contact.setLeftCompany(Short.valueOf("0"));

		contact.setCompany(new DataLink(COCCUC, ""));
		contact.setAddress("10 rue Jean Moulins");
		contact.setAddress2("Batiment 1");
		contact.setAddress3("1ere étage");
		contact.setCity("Lyon");
		contact.setAcceptsEmail(Short.valueOf("0"));
		contact.setComment("Commentaire");
		contact.setEmail("john.smith@everwin.fr");
		contact.setFunction("Commercial");
		contact.setLeftCompany(Short.valueOf("0"));
		return contact;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setAddress("8 rue Jean Moulins");

	}

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        ContactResponsibility obj = loadFirstObject();

        try {
			ContactEventService Eservice = new ContactEventService(clientApi);
			ContactEventList Elist = Eservice.query();
			ContactEvent event = Elist.getItems().get(0);

			//service.queryEventFromResponsibility(obj, event, null);
			service.queryEventsFromResponsibility(obj, null);
		} catch (CoreException e) {
            e.printStackTrace();
			Assert.fail("Error specific services", e);
		}
    }
}
