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

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.core.config.ConfigHelper;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.currencies.rates.CurrencyRate;
import fr.everwin.open.api.services.currencies.CurrencyRatesService;

/**
 * @author d.storti
 */
public class CurrencyRatesTest extends BasicTest<CurrencyRate, CurrencyRatesService> {

	public final long FRAENT = 105189; // entity

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new CurrencyRatesService(clientApi);
		ws_rights = "R";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected CurrencyRate initObject() {
		CurrencyRate currencyRate = new CurrencyRate();

		currencyRate.setEntity(new DataLink(FRAENT, ""));
		currencyRate.setBaseCurrency("EUR");
		currencyRate.setCounterCurrency("JPY");
		currencyRate.setRate(133.00);

		Calendar calStart = Calendar.getInstance();
		calStart.add(Calendar.YEAR, 30);
		calStart = ConfigHelper.getFirstPeriodDate(calStart);

		Calendar calEnd = Calendar.getInstance();
		calEnd.add(Calendar.YEAR, 30);
		calEnd.add(Calendar.MONTH, 8);
		calEnd = ConfigHelper.getFirstPeriodDate(calEnd);

		currencyRate.setStartDate(calStart.getTime());
		currencyRate.setEndDate(calEnd.getTime());
		currencyRate.setUpdateMainRate(Short.valueOf("1"));
		return currencyRate;
	}

    @Override
    protected void changeObjectForUpdate() {
    }

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }

	@Test(priority = 3)
	protected void testAddOrUpdateRate() {
		try {
			CurrencyRate currencyRate = initObject();
			service.addOrUpdateRate(currencyRate);
		} catch (CoreException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
