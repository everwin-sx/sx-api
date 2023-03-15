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

import jakarta.ws.rs.core.Response;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.core.config.ConfigHelper;
import fr.everwin.open.api.exception.RequestException;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoice;
import fr.everwin.open.api.model.supplierinvoices.lines.SupplierInvoiceLine;
import fr.everwin.open.api.model.supplierinvoices.lines.SupplierInvoiceLineMultiCurrencyValue;
import fr.everwin.open.api.services.supplierinvoices.SupplierInvoiceService;

/**
 * @author d.storti
 */
public class SupplierInvoicesTest extends BasicTest<SupplierInvoice, SupplierInvoiceService> {

	public final long PRJ = 188827; // project
	public final long VAT = 105989;     // VAT
	public final long LINEDL = 175009;  // line
	public final long TYPEDL = 105919;  // type
	//prm_acc_axp_sinv_accpos = 0

	public final long COMP = 209904;   // supplier
	public final long ENT = 105231;    // entity
	public final long PAY = 1130;      // payment terms
	private SupplierInvoiceLine objectLineReceived;

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SupplierInvoiceService(clientApi);
		ws_rights = "RWD";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SupplierInvoice initObject() {
		SupplierInvoice supplierInvoice = new SupplierInvoice();

		supplierInvoice.setSupplier(new DataLink(COMP, ""));
		supplierInvoice.setEntity(new DataLink(ENT, ""));
		supplierInvoice.setPaymentTerms(new DataLink(PAY, ""));

		Calendar cal = ConfigHelper.newCalendar(new Date());
		cal.set(Calendar.DATE, 15);
		cal.add(Calendar.MONTH, 1);
		supplierInvoice.setDate(cal.getTime());

		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.DATE, -1);
		supplierInvoice.setDueDate(cal.getTime());

		supplierInvoice.setValidationStep("STEP0");
		return supplierInvoice;
	}

	protected SupplierInvoiceLine initObjectLine(){
		SupplierInvoiceLine supplierInvoiceLine = new SupplierInvoiceLine();

		supplierInvoiceLine.setSupplierInvoice(new DataLink(objectReceived.getId(), ""));
		supplierInvoiceLine.setTitle("Ligne FF-HEINEKEN-15");
		double quantityValue = 11.79;
		double amountValue = 145.77;
		supplierInvoiceLine.setQuantity(quantityValue);
		SupplierInvoiceLineMultiCurrencyValue amount = new SupplierInvoiceLineMultiCurrencyValue();
		amount.setManagement(amountValue);
		supplierInvoiceLine.setAmount(amount);
		supplierInvoiceLine.setVat(new DataLink(VAT, ""));
		supplierInvoiceLine.setProject(new DataLink(PRJ, ""));//new DataLink(objectReceived.getId(), ""));
		supplierInvoiceLine.setType(new DataLink(TYPEDL, ""));
		supplierInvoiceLine.setProjectLine(new DataLink(LINEDL, ""));
		return supplierInvoiceLine;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setValidationStep("STEP1");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }


	@Test(priority = 3)
	public void _testCreateLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			objectLineReceived = initObjectLine();
			service.createLine(objectReceived.getId(), objectLineReceived);
			SupplierInvoiceLine objectFromAPI = service.getLine(objectReceived.getId(), objectLineReceived.getId());
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
			if (!hasRights("W")) objectLineReceived = (SupplierInvoiceLine) list.getItems().get(0);
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

	@Test(priority = 3)
	public void _testGetLine() {
		if (isEmptyDB || !hasRights("R")) throw new SkipException("No access to this method");
		try {
			SupplierInvoiceLine object = service.getLine(objectReceived.getId(), objectLineReceived.getId());
			Assert.assertEquals(object.getId(), objectLineReceived.getId());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while get one object", e);
		}
	}

	@Test(priority = 3)
	public void _testUpdatePartiallyLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			SupplierInvoiceLine objectLineOld = objectLineReceived;
			changeObjectLineForUpdate();
			service.updatePartiallyLine(objectReceived.getId(), objectLineReceived);
			SupplierInvoiceLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

			Assert.assertTrue(compare(objectLineReceived, objectLineModified));
			service.updatePartiallyLine(objectReceived.getId(), objectLineOld);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while comparing object", e);
		}
	}

	@Test(priority = 3)
	public void _testUpdateFullLine() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
		try {
			SupplierInvoiceLine objectLineOld = objectLineReceived;
			changeObjectLineForUpdate();
			service.updateLine(objectReceived.getId(), objectLineReceived);
			SupplierInvoiceLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

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

	@Override
	@Test(priority = 4)
	public void testUpdatePartially() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
	}

	@Override
	@Test(priority = 5)
	public void testUpdateFull() {
		if (!hasRights("W")) throw new SkipException("No access to this method");
	}

}
