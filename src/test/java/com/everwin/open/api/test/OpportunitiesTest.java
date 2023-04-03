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

import com.everwin.open.api.core.BasicTest;
import fr.everwin.open.api.core.config.ConfigHelper;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.opportunities.Opportunity;
import fr.everwin.open.api.services.opportunities.OpportunitiesService;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Calendar;
import java.util.Date;

/**
 * @author d.storti
 */
public class OpportunitiesTest extends BasicTest<Opportunity, OpportunitiesService> {

    public final long PRJSPA = 6;
    public final long PRJENT = 105231;  // entity
    public final long PRJFENT = 105231; // financial entity
    public final long PRJCUC = 162991;  // customer
    public final long PRJCAP = 1168; // category
    public final long PRJCOC = 167044;  // main contact
    public final long PRJDRES = 163275; // project director
    public final long PRJRES = 163076; // project manager
    public final long PRJBRES = 163076; // opportunity manager
    public final long PRJPRO = 1199; // sale cycle
    public final long PRJSPT = 5566; // sale step

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new OpportunitiesService(clientApi);
		ws_rights = "RCDS";//W
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Opportunity initObject() {
        Opportunity opportunity = new Opportunity();
        opportunity.setLabel("A-Lyon-ACC-00596");

        opportunity.setEntity(new DataLink(PRJENT, ""));
        opportunity.setFinancialEntity(new DataLink(PRJFENT, ""));
        opportunity.setCustomer(new DataLink(PRJCUC, ""));
        opportunity.setCategory(new DataLink(PRJCAP, ""));
        opportunity.setMainContact(new DataLink(PRJCOC, ""));
        //opportunity.setProjectDirector(new DataLink(PRJDRES, ""));
        //opportunity.setProjectManager(new DataLink(PRJRES, ""));
        //opportunity.setOpportunityManager(new DataLink(PRJBRES, ""));
        //opportunity.setSpanco(new DataLink(PRJSPA, ""));


        opportunity.setSalesCycle(new DataLink(PRJPRO, null));
        opportunity.setSalesStep(new DataLink(PRJSPT, null));

        opportunity.setCommercialStatus(Short.valueOf("0"));
        opportunity.setInvoicingMode(Short.valueOf("10"));
        opportunity.setDurationUnit(Short.valueOf("1"));

        opportunity.setEstimatedProbability(Short.valueOf("50"));

        Calendar start = ConfigHelper.newCalendar(new Date());
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.MONTH, Calendar.JANUARY);
        opportunity.setInitialStartDate(start.getTime());
        Calendar end = ConfigHelper.newCalendar(start.getTime());
        end.set(Calendar.DAY_OF_MONTH, 1);
        end.set(Calendar.MONTH, Calendar.DECEMBER);
        opportunity.setInitialEndDate(end.getTime());
        return opportunity;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setEstimatedProbability(Short.valueOf("10"));
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        Opportunity obj = loadFirstObject();
        try {
            service.querySAForOpportinity(obj, null);
            //service.queryLeadsFromOpportunity(obj, null);
        } catch (CoreException e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }
    }
}
