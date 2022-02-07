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

import javax.ws.rs.core.Response;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.core.config.ConfigHelper;
import fr.everwin.open.api.exception.RequestException;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.suppliersettlement.SupplierSettlement;
import fr.everwin.open.api.model.suppliersettlement.lines.SupplierSettlementLine;
import fr.everwin.open.api.model.suppliersettlement.lines.SupplierSettlementLineMultiCurrencyValue;
import fr.everwin.open.api.services.suppliersettlements.SupplierSettlementService;

/**
 * @author d.storti
 */
public class SupplierSettlementTest extends BasicTest<SupplierSettlement, SupplierSettlementService> {

    public final long BANK = 104942;  // bank
    public final long COMPA = 201543; // company
    public final long ENTDL = 105189; // entity
    public final long ROWTYPE = 979;  // type

    public final long INVOICEDL = 248516;
    private SupplierSettlementLine objectLineReceived;

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SupplierSettlementService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SupplierSettlement initObject() {
        SupplierSettlement supplierSettlement = new SupplierSettlement();
        supplierSettlement.setReference("ref");

        supplierSettlement.setSupplier(new DataLink(COMPA, ""));
        supplierSettlement.setEntity(new DataLink(ENTDL, ""));
        supplierSettlement.setSettlementType(new DataLink(ROWTYPE, ""));
        supplierSettlement.setBank(new DataLink(BANK, ""));

        Calendar cal = ConfigHelper.newCalendar(new Date());
        cal.set(Calendar.DATE, 15);
        cal.add(Calendar.MONTH, 1);
        supplierSettlement.setSettlementDate(cal.getTime());

        supplierSettlement.setValidationStep("STEP0");

        return supplierSettlement;
	}

    protected SupplierSettlementLine initObjectLine() {
        SupplierSettlementLine supplierSettlementLine = new SupplierSettlementLine();
        supplierSettlementLine.setSupplierSettlement(new DataLink(objectReceived.getId(), ""));
        supplierSettlementLine.setSupplierInvoice(new DataLink(INVOICEDL, ""));
        double amountValue = 145.77;
        SupplierSettlementLineMultiCurrencyValue amount = new SupplierSettlementLineMultiCurrencyValue();
        amount.setManagement(amountValue);
        supplierSettlementLine.setAmount(amount);
        supplierSettlementLine.setState(Short.valueOf("0"));
        return supplierSettlementLine;
    }

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setReference("ref-MODIFIED");
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
            SupplierSettlementLine objectFromAPI = service.getLine(objectReceived.getId(), objectLineReceived.getId());
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

    //@Test(priority = 3)
    public void _testGetAllLine() {
        if (!hasRights("R")) throw new SkipException("No access to this method");
        try {
            BasicList list = service.queryLines(objectReceived.getId(), null);
            if (!hasRights("W")) objectLineReceived = (SupplierSettlementLine) list.getItems().get(0);
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
            SupplierSettlementLine object = service.getLine(objectReceived.getId(), objectLineReceived.getId());
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
            SupplierSettlementLine objectLineOld = objectLineReceived;
            changeObjectLineForUpdate();
            service.updatePartiallyLine(objectReceived.getId(), objectLineReceived);
            SupplierSettlementLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

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
            SupplierSettlementLine objectLineOld = objectLineReceived;
            changeObjectLineForUpdate();
            service.updateLine(objectReceived.getId(), objectLineReceived);
            SupplierSettlementLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

            Assert.assertTrue(compare(objectLineReceived, objectLineModified));
            service.updateLine(objectReceived.getId(), objectLineOld);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }
    private void changeObjectLineForUpdate(){
        objectLineReceived.setState(Short.valueOf("1"));
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
