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
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.quotes.crm.CRMQuote;
import fr.everwin.open.api.model.quotes.crm.lines.CRMQuoteLine;
import fr.everwin.open.api.services.quotes.crm.CRMQuotesService;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

/**
 * @author d.storti
 */
public class CRMQuoteTest extends BasicTest<CRMQuote, CRMQuotesService> {

    public final long VAT = 105989;       // VAT
    public final long ROWT = 105971;      // row type
    public final long OPPOR = 215547;     // opportunity
    public final long EST = 194343;       // estimate quote


    public final long ESTCUC = 163743;    // customer
    public final long ESTPRJ = 215547;    // opportunity
    public final long ESTCOC = 226912;    // main contact
    public final long ESTACOC = 162628;   // secondary contact
    public final long ESTENT = 105231;    // entity
    private CRMQuoteLine objectLineReceived;
    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new CRMQuotesService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected CRMQuote initObject() {
        CRMQuote crmQuote = new CRMQuote();
        crmQuote.setCode("code");

        crmQuote.setCustomer(new DataLink(ESTCUC, ""));
        crmQuote.setOpportunity(new DataLink(ESTPRJ, ""));
        crmQuote.setMainContact(new DataLink(ESTCOC, ""));
        crmQuote.setSecondaryContacts(List.of(new DataLink(ESTACOC, "")));
        crmQuote.setEntity(new DataLink(ESTENT, ""));

        crmQuote.setPrintHeader("Header");
        crmQuote.setPaymentConditions("payment in 30 days");
        crmQuote.setNotes("note");
        crmQuote.setDelay("chronopost");
        crmQuote.setStatus(Integer.valueOf(0).shortValue());
        crmQuote.setSignatureDate(parseDate("2100-07-05T00:00:00"));
        crmQuote.setValidationStep("STEP0");
        crmQuote.setType((short)0);
        return crmQuote;
	}

    protected CRMQuoteLine initObjectLine() {
        CRMQuoteLine line = new CRMQuoteLine();

        line.setQuote(new DataLink(EST, ""));
        short index = 1;
        line.setComment("L" + index);
        line.setReference("Ref" + index);
        line.setRevenueQuantity(10d);
        line.getRevenue().getAmount().setManagement(1000d);
        line.getRevenue().getTotal().setManagement(10000d);
        line.setExpenditureQuantity(10d);
        line.getExpenditure().getAmount().setManagement(800d);
        line.getExpenditure().getTotal().setManagement(8000d);
        line.setVat(new DataLink(VAT, ""));
        line.setVatRate(20d);
        line.setVat2Rate(0d);

        line.setType(new DataLink(ROWT, ""));
        line.setOpportunity(new DataLink(OPPOR, ""));
        return line;
    }

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setPrintHeader("Header-MODIFIED");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }


    //@Test(priority = 3)
    public void _testGetAllLine() {
        if (!hasRights("R")) throw new SkipException("No access to this method");
        try {
            BasicList list = service.queryLines(objectReceived.getId(), null);
            if (!hasRights("W")) objectLineReceived = (CRMQuoteLine) list.getItems().get(0);
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
}
