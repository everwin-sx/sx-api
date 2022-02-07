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

import fr.everwin.open.api.model.currencies.Currency;
import fr.everwin.open.api.model.currencies.CurrencyList;
import fr.everwin.open.api.model.entities.Entity;
import fr.everwin.open.api.services.currencies.CurrencyService;
import fr.everwin.open.api.services.entities.EntitiesService;

/**
 * @author d.storti
 */
public class EntitiesTest extends BasicTest<Entity, EntitiesService> {

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new EntitiesService(clientApi);
		ws_rights = "SR";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Entity initObject() {
        return new Entity();
	}

    @Override
    protected void changeObjectForUpdate() {
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        Entity obj = loadFirstObject();
        try {

            CurrencyService Cservice = new CurrencyService(clientApi);
            CurrencyList Clist = Cservice.query();
            Currency currency = Clist.getItems().get(0);

            service.queryFinancial(null);
            service.queryOperational(null);
            service.queryFinancialLast(null);
            service.queryOperationalLast(null);
            service.queryCurrencyRateFromEntityAndCurrency(obj, currency, null);
            service.queryCurrencyRateFromEntity(obj,null);
            service.queryCurrencyFromEntity(obj, null);
            service.queryRowTypeFromEntity(obj, null);
            service.queryAccountFromEntity(obj, null);
            service.queryAccountFromEntityForExpenseSheet(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }
    }
}
