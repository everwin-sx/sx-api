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
import org.testng.annotations.Test;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.core.config.ConfigHelper;
import fr.everwin.open.api.exception.RequestException;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.supplierorders.SupplierOrder;
import fr.everwin.open.api.model.supplierorders.lines.SupplierOrderLine;
import fr.everwin.open.api.model.supplierorders.lines.SupplierOrderLineMultiCurrencyValue;
import fr.everwin.open.api.services.supplierorders.SupplierOrderService;

/**
 * @author d.storti
 */
public class SupplierOrderTest extends BasicTest<SupplierOrder, SupplierOrderService> {

    public final long PRJDL = 248121;   // project
    public final long PRJLINE = 177360; // project line

    public final long EXPENT = 105231;  // entity
    public final long EXPPRJ = 167682;  // project //248121
    public final long EXPRES = 107055;  // issuer
    public final long EXPCUC = 201543;  // supplier
    public final long EXPCOC = 188108;  // contact pas oblig
    public final long EXPCUA = 154246;  // supplier account pas oblig
    private SupplierOrderLine objectLineReceived;

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SupplierOrderService(clientApi);
		ws_rights = "RD"; //W
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SupplierOrder initObject() {
        SupplierOrder supplierOrder = new SupplierOrder();

        supplierOrder.setEntity(new DataLink(EXPENT, ""));
        supplierOrder.setProject(new DataLink(EXPPRJ, ""));
        supplierOrder.setIssuer(new DataLink(EXPRES, ""));
        supplierOrder.setSupplier(new DataLink(EXPCUC, ""));
        supplierOrder.setContact(new DataLink(EXPCOC, ""));
        supplierOrder.setSupplierAccount(new DataLink(EXPCUA, ""));
        Calendar cal = ConfigHelper.newCalendar(new Date());
        supplierOrder.setCreationDate(cal.getTime());
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, 2);
        cal.add(Calendar.DATE, -1);
        supplierOrder.setDeliveryDate(cal.getTime());
        supplierOrder.setSupplierReference("REF-FOUR");
        supplierOrder.setEstimateReference("REF-DEVIS");
        supplierOrder.setDeliveryAddress("rue des champs \n 69006 Lyon");
        supplierOrder.setComment("my comment");
        supplierOrder.setValidationStep("STEP0");
        return supplierOrder;
	}

    protected SupplierOrderLine initObjectLine() {
        SupplierOrderLine supplierOrderLine = new SupplierOrderLine();
        supplierOrderLine.setSupplierOrder(new DataLink(objectReceived.getId(), ""));
        supplierOrderLine.setReference("REF-ROW-ORD");
        supplierOrderLine.setTitle("Ligne WS-TEST-SOR");
        supplierOrderLine.setProject(new DataLink(PRJDL, ""));
        supplierOrderLine.setProjectLine(new DataLink(PRJLINE, ""));
        double quantityValue = 11.79;
        supplierOrderLine.setQuantity(quantityValue);
        double amountValue = 145.77;
        SupplierOrderLineMultiCurrencyValue amount = new SupplierOrderLineMultiCurrencyValue();
        amount.setManagement(amountValue);
        supplierOrderLine.setAmount(amount);
        return supplierOrderLine;
    }

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setComment("my comment-MODIFIED");
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
            SupplierOrderLine objectFromAPI = service.getLine(objectReceived.getId(), objectLineReceived.getId());
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
            if (!hasRights("W")) objectLineReceived = (SupplierOrderLine) list.getItems().get(0);
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
            SupplierOrderLine object = service.getLine(objectReceived.getId(), objectLineReceived.getId());
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
            SupplierOrderLine objectLineOld = objectLineReceived;
            changeObjectLineForUpdate();
            service.updatePartiallyLine(objectReceived.getId(), objectLineReceived);
            SupplierOrderLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

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
            SupplierOrderLine objectLineOld = objectLineReceived;
            changeObjectLineForUpdate();
            service.updateLine(objectReceived.getId(), objectLineReceived);
            SupplierOrderLine objectLineModified = service.getLine(objectReceived.getId(), objectLineReceived.getId());

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

    @Test(priority = 998)
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
