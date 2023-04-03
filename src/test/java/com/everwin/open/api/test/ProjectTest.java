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
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.projects.Project;
import fr.everwin.open.api.model.quotes.poa.POAQuote;
import fr.everwin.open.api.services.projects.ProjectsService;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

/**
 * @author d.storti
 */
public class ProjectTest extends BasicTest<Project, ProjectsService> {

    public final long CUST = 162946; // customer
    public final long ENT = 105231; // entity

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ProjectsService(clientApi);
		ws_rights = "RCDS";//W
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Project initObject() {
        Project project = new Project();
        project.setLabel("LABEL");

        project.setType((short) 0);
        project.setCustomer(new DataLink(CUST, ""));
        project.setEntity(new DataLink(ENT, ""));
        project.setPlanningMode((short) 3);
        project.setDurationUnit((short) 1);
        project.setAdjustableSales((short) 0);
        project.setComment("MYPRJWSCOMMENTTEST-");
        project.setProductionStatus((short) 80);
        project.setInvoicingMode((short) 10);
        project.setExpenseManagementMode((short) 0);
        return project;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setLabel("LABEL-MODIFIED");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");

        Project obj = loadFirstObject();
        try {
            service.queryCustomersAssetsFromProject(obj, null);
            POAQuote poaQuote = new POAQuote();
            poaQuote.setProjectLineIds(List.of(new Long(177677)));
            //service.createPOAQuoteFromLineId(263239, poaQuote);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }
    }
}
