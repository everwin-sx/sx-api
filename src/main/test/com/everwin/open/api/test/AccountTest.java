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

import java.util.ArrayList;
import java.util.List;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.model.accounts.Account;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.accounts.AccountService;

/**
 * @author d.storti
 */
public class AccountTest extends BasicTest<Account, AccountService> {

	private static String LABELACO = "LABEL";      // Label
	private static short RESCRST = 1;              // VAT system
	private static short TYPEACO = 1;              // type
	private static long ACOENT = 142903;           // account entity

	@Override
	protected void changeObjectForUpdate() {
		objectReceived.setLabel("LABEL-MODIFIED");
	}

	@Override
	protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
	}

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new AccountService(clientApi);
		ws_rights = "R";

	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Account initObject() {
		Account account = new Account();
		account.setLabel(LABELACO);
		account.setVatSystem(RESCRST);
		account.setType(TYPEACO);

		List<DataLink> accountingEntities = new ArrayList<>();
		accountingEntities.add(new DataLink(ACOENT, ""));
		account.setEntities(accountingEntities);

		return account;
	}
}
