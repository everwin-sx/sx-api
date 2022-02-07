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

import java.util.ArrayList;
import java.util.List;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.salesactions.SalesAction;
import fr.everwin.open.api.services.salesactions.SalesActionsService;

/**
 * @author d.storti
 */
public class SalesActionsTest extends BasicTest<SalesAction, SalesActionsService> {

    public final long TSKRES = 163582;      // main player
    public final long TSKARES = 163266;     // secondary player
    public final long TSKCOC = 191407;      // main contact
    public final long TSKACOC = 192649;     // secondary contact
    public final long TSKCUC = 165316;      // company
    public final long TSKMATRES = 166119;   // equipment

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SalesActionsService(clientApi);
		ws_rights = "RWCDS";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SalesAction initObject() {
        SalesAction salesAction = new SalesAction();
        salesAction.setType(Integer.valueOf(2).shortValue());
        salesAction.setDescription("WS-ACTION-COMMERCIALE-TEST");
        salesAction.setMainPlayer(new DataLink(TSKRES, ""));

        List<DataLink> employeeDLs = new ArrayList<>();
        employeeDLs.add(new DataLink(TSKARES, ""));
        salesAction.setSecondaryPlayers(employeeDLs);

        salesAction.setMainContact(new DataLink(TSKCOC, ""));

        List<DataLink> contactDLs = new ArrayList<>();
        contactDLs.add(new DataLink(TSKACOC, ""));
        salesAction.setSecondaryContacts(contactDLs);

        salesAction.setCompany(new DataLink(TSKCUC, ""));

        salesAction.setStartDate(parseDate("2100-07-05T09:30:00"));

        salesAction.setDuration(parseTime("04:00"));
        salesAction.setPlace("Paname");
        salesAction.setPriority(Integer.valueOf(4).shortValue());


        salesAction.setStatus(Integer.valueOf(19).shortValue());
        salesAction.setCompletionDate(null);
        salesAction.setAnswer(Integer.valueOf(2).shortValue());
        salesAction.setSalesStep(null);

        List<DataLink> equipmentDLs = new ArrayList<>();
        equipmentDLs.add(new DataLink(TSKMATRES, ""));
        salesAction.setEquipments(equipmentDLs);

        salesAction.setIsPrivate(Integer.valueOf(0).shortValue());
        return salesAction;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setDescription("WS-ACTION-COMMERCIALE-TEST-MODIFIED");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        SalesAction obj = loadFirstObject();
        /*try {
            service.queryLeadsFromSalesAction(obj, null);
        } catch (CoreException e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }*/
    }
}
