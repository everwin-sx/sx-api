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
import fr.everwin.open.api.exception.RequestException;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.supplierreceivingnotes.SupplierReceivingNote;
import fr.everwin.open.api.model.supplierreceivingnotes.lines.SupplierReceivingNoteLine;
import fr.everwin.open.api.model.supplierreceivingnotes.lines.SupplierReceivingNoteLineMultiCurrencyValue;
import fr.everwin.open.api.services.supplierreceivingnote.SupplierReceivingNoteService;
import jakarta.ws.rs.core.Response;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author d.storti
 */
public class SupplierReceivingNoteTest extends BasicTest<SupplierReceivingNote, SupplierReceivingNoteService> {

	public final long PRJDL = 248122;     // project
	public final long ROWT = 105919;      // rowtype
	public final long PRJLINEDL = 177361; // project line

	public final long SPPCUC = 201543;    // supplier
	public final long SPPENT = 105231;    // entity
	private SupplierReceivingNoteLine objectLineReceived;


	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SupplierReceivingNoteService(clientApi);
		ws_rights = "R"; //WD
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SupplierReceivingNote initObject() {
        SupplierReceivingNote supplierReceivingNote = new SupplierReceivingNote();

		supplierReceivingNote.setSupplier(new DataLink(SPPCUC, ""));
		supplierReceivingNote.setEntity(new DataLink(SPPENT, ""));

		Calendar cal = ConfigHelper.newCalendar(new Date());
		cal.set(Calendar.DATE, 15);
		cal.add(Calendar.MONTH, 1);
		supplierReceivingNote.setDate(cal.getTime());

		supplierReceivingNote.setValidationStep("STEP0");

		return supplierReceivingNote;
	}

	protected SupplierReceivingNoteLine initObjectLine(){
		SupplierReceivingNoteLine supplierReceivingNoteLine = new SupplierReceivingNoteLine();
		supplierReceivingNoteLine.setSupplierReceivingNote(new DataLink(objectReceived.getId(), ""));
		supplierReceivingNoteLine.setTitle("Ligne WS-TEST-SDE");
		double quantityValue = 11.79;
		double amountValue = 145.77;
		double totalWithoutVatValue = ConfigHelper.round(quantityValue * amountValue, 2);
		supplierReceivingNoteLine.setQuantity(quantityValue);
		SupplierReceivingNoteLineMultiCurrencyValue totalWithoutVat = new SupplierReceivingNoteLineMultiCurrencyValue();
		totalWithoutVat.setManagement(totalWithoutVatValue);
		supplierReceivingNoteLine.setTotalWithoutVat(totalWithoutVat);
		supplierReceivingNoteLine.setProject(new DataLink(PRJDL, ""));
		supplierReceivingNoteLine.setType(new DataLink(ROWT, ""));
		supplierReceivingNoteLine.setProjectLine(new DataLink(PRJLINEDL, ""));
		Short receiptStatus = 1;
		supplierReceivingNoteLine.setReceiptStatus(receiptStatus);
		return supplierReceivingNoteLine;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setValidationStep("STEP1");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }

	//@Test(priority = 3)
	public void _testCreateLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			objectLineReceived = initObjectLine();
			service.createLine(objectReceived.getId(), objectLineReceived);
			SupplierReceivingNoteLine objectFromAPI = service.getLine(objectReceived.getId(), objectLineReceived.getId());
			Assert.assertTrue(compare(objectLineReceived, objectFromAPI));
		} catch (RequestException r) {
			if (r.getStatus() == Response.Status.FORBIDDEN.getStatusCode()) {
				ws_rights.replace("W", "");
				throw new SkipException("No access to this method");
			} else {
				r.printStackTrace(System.err);
				Assert.fail(r.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void _testGetAllLine() {
		if (!hasRights("R")) throw new SkipException("No access to this method");
		try {
			BasicList list = service.queryLines(objectReceived.getId(), null);
			if (!hasRights("W")) objectLineReceived = (SupplierReceivingNoteLine) list.getItems().get(0);
			list.getItems().size();
		} catch (NullPointerException i) {
			isEmptyDB = true;
			if (!hasRights("W")) throw new SkipException("No access to this method"); // if empty but can create
			i.printStackTrace();
			Assert.fail("Error while get all objects", i);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while get all objects", e);
		}
	}

	//@Test(priority = 3)
	public void _testGetLine() {
		if (isEmptyDB || !hasRights("R")) throw new SkipException("No access to this method");
		try {
			SupplierReceivingNoteLine object = service.getLine(objectReceived.getId(), objectLineReceived.getId());
			Assert.assertEquals(object.getId(), objectLineReceived.getId());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while get one object", e);
		}
	}

	//@Test(priority = 3)
	public void _testUpdatePartiallyLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			SupplierReceivingNoteLine objectLineOld = objectLineReceived;
			changeObjectLineForUpdate();
			service.updatePartiallyLine(objectReceived.getId(), objectLineReceived);
			SupplierReceivingNoteLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

			Assert.assertTrue(compare(objectLineReceived, objectLineModified));
			service.updatePartiallyLine(objectReceived.getId(), objectLineOld);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while comparing object", e);
		}
	}

	//@Test(priority = 3)
	public void _testUpdateFullLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			SupplierReceivingNoteLine objectLineOld = objectLineReceived;
			changeObjectLineForUpdate();
			service.updateLine(objectReceived.getId(), objectLineReceived);
			SupplierReceivingNoteLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

			Assert.assertTrue(compare(objectLineReceived, objectLineModified));
			service.updateLine(objectReceived.getId(), objectLineOld);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while comparing object", e);
		}
	}
	private void changeObjectLineForUpdate(){
		objectLineReceived.setTitle("Ligne FF-HEINEKEN-15-MODIFIED");
	}

	//@Test(priority = 998)
	public void testDeleteLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			service.deleteLine(objectReceived.getId(), objectLineReceived);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			Assert.fail(e.getMessage());
		}
		try {
			service.get(objectReceived.getId());
			Assert.fail("Error while deleting : the object still exists");
		} catch (Exception ignored) {
		}
	}
}
