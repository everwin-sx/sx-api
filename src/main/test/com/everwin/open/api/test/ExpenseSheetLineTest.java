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

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.expenses.sheets.ExpenseSheet;
import fr.everwin.open.api.model.expenses.sheets.ExpenseSheetList;
import fr.everwin.open.api.model.expenses.sheets.lines.ExpenseSheetLine;
import fr.everwin.open.api.services.expenses.ExpenseSheetLineService;
import fr.everwin.open.api.services.expenses.ExpenseSheetService;

/**
 * @author d.storti
 */
public class ExpenseSheetLineTest extends BasicTest<ExpenseSheetLine, ExpenseSheetLineService> {

    public final long RXPEXP = 167240; // expense sheet
    public final long RXPPRJ = 167088; // project
    public final long RXPRTY = 105985; // type

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ExpenseSheetLineService(clientApi);
		ws_rights = "S";  //RWD
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected ExpenseSheetLine initObject() {
        ExpenseSheetLine object = new ExpenseSheetLine();
        object.setExpenseSheet(new DataLink(RXPEXP,""));
        object.setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime());
        object.setProject(new DataLink(RXPPRJ, ""));
        object.setType(new DataLink(RXPRTY, ""));
        object.setTitle("title");
        object.setQuantity(Double.valueOf("5"));

		return object;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setTitle("title-modified");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        ExpenseSheetLine obj = loadFirstObject();
        try {

            ExpenseSheetService ESservice = new ExpenseSheetService(clientApi);
            ExpenseSheetList ESlist = ESservice.query();
            ExpenseSheet expenseSheet = ESlist.getItems().get(0);

            service.queryLinesFromExpenseSheet(expenseSheet, null);
            service.queryLinebyId(expenseSheet, obj, null);

        } catch (CoreException e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }
    }
}
