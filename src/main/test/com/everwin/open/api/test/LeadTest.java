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
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.leads.Lead;
import fr.everwin.open.api.model.leads.events.LeadEvent;
import fr.everwin.open.api.model.leads.events.LeadEventList;
import fr.everwin.open.api.services.leads.LeadEventService;
import fr.everwin.open.api.services.leads.LeadService;

/**
 * @author d.storti
 */
public class LeadTest extends BasicTest<Lead, LeadService> {

	public static final long OPPLINK = 167076;  // opportunity
	public static final long ENTLINK = 105189;  // entity acc
	public static final long LEDRES = 107055;   // employee
	public static final long LESLES = 1;        // lead state
	public static final long LEDLDS = 1;        // lead source
	public static final long LEDCUC = 162110;   // company
	public static final long LEDCOC = 162632;   // contact responsibilities

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new LeadService(clientApi);
		ws_rights = ""; // RWCDS
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Lead initObject() {
		Lead lead = new Lead();
		lead.setDescription("WSTEST-LEAD-001");
		lead.setCompanyFree("AIRCELLE Mega Plaisir");
		lead.setAddress("3 rue du Tarn 69002 Lyon");
		lead.setContactFree("Jean Libre");
		lead.setPhone("+33682189696");
		lead.setEmail("jean.libre@aicellemegaplaisir.fr");
		lead.setScore(Short.valueOf("5"));

		lead.setEntity(new DataLink(ENTLINK, ""));
		lead.setFinancialEntity(new DataLink(ENTLINK, ""));
		lead.setAffectedTo(new DataLink(LEDRES, ""));
		lead.setState(new DataLink(LESLES, ""));
		lead.setSource(new DataLink(LEDLDS, ""));
		lead.setCompany(new DataLink(LEDCUC, ""));
		lead.setContact(new DataLink(LEDCOC, ""));
		lead.setOpportunity(new DataLink(OPPLINK, ""));

		return lead;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setAddress("8 rue du Tarn 69002 Lyon");
    }

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
		Lead obj = loadFirstObject();
		try {
			LeadEventService LEservice = new LeadEventService(clientApi);
			LeadEventList LElist = LEservice.query();
			LeadEvent leadEvent = LElist.getItems().get(0);

			service.queryLeadEvents(obj, null);
			service.queryLeadEventById(obj, leadEvent, null);
		} catch (CoreException e) {
			e.printStackTrace();
			Assert.fail("Error specific services", e);
		}
    }
}
