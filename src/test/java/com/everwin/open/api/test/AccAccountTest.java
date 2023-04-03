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
import fr.everwin.open.api.model.companies.accounts.acc.AccAccount;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.companies.AccAccountService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d.storti
 */
public class AccAccountTest extends BasicTest<AccAccount, AccAccountService> {

	private final long ACCCUA = 171124;           // company account
	private final String ACCACC = "1400";         // subsidiary account
	private final String REGACC = "2400";         // book
	private final String SUBACCACC = "1400";      // general account
	private final long ACCENT = 105189;           // entity owner account 105189 : fr / 142907 : esp

	//changer le client qui est déjà rattaché a cette entité dans une autre donnée comptable


	@Override
	protected void changeObjectForUpdate() {
		//objectReceived.set("jhon.smith2@everwin.fr");
	}

	@Override
	protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
	}

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new AccAccountService(clientApi);
		ws_rights = "R"; // W
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected AccAccount initObject() {
		AccAccount account = new AccAccount();

		account.setCompanyAccount(new DataLink(ACCCUA, ""));

		List<DataLink> accountingEntities = new ArrayList<>();
		accountingEntities.add(new DataLink(ACCENT, "")); // ACCENT
		account.setEntities(accountingEntities);

		account.setBook(REGACC);
		account.setGeneralAccount(SUBACCACC);
		account.setSubsidiaryAccount(ACCACC);

		return account;
	}
}
