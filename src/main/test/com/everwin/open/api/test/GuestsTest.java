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
import fr.everwin.open.api.model.expenses.guests.Guest;
import fr.everwin.open.api.model.expenses.sheets.lines.ExpenseSheetLine;
import fr.everwin.open.api.model.expenses.sheets.lines.ExpenseSheetLineList;
import fr.everwin.open.api.services.expenses.ExpenseSheetLineService;
import fr.everwin.open.api.services.expenses.GuestService;

/**
 * @author d.storti
 */
public class GuestsTest extends BasicTest<Guest, GuestService> {

	public static final long GSTRXP = 189250;    // expense line

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new GuestService(clientApi);
		ws_rights = "RWS";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Guest initObject() {
		Guest guest = new Guest();
		guest.setExpenseLine(new DataLink(GSTRXP, ""));
		guest.setName("TEST");
		guest.setType(Short.valueOf("1"));
		guest.setFunction("FUNCTION CDP");
		return guest;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setName("TEST-MODIFIED");
	}

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");

		try {
			ExpenseSheetLineService ESLservice = new ExpenseSheetLineService(clientApi);
			ExpenseSheetLineList ESLlist = ESLservice.query();
			ExpenseSheetLine line = ESLlist.getItems().get(0);

			//service.queryGuestFromLine(line, null);
		} catch (CoreException e) {
			e.printStackTrace();
			Assert.fail("Error specific services", e);
		}
    }
}
