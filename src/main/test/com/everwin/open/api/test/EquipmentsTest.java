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

import java.util.Date;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.model.documents.Document;
import fr.everwin.open.api.model.equipments.Equipment;
import fr.everwin.open.api.services.equipments.EquipmentsService;

/**
 * @author d.storti
 */
public class EquipmentsTest extends BasicTest<Equipment, EquipmentsService> {

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new EquipmentsService(clientApi);
		ws_rights = "RD";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Equipment initObject() {
		return new Equipment();
	}

    @Override
    protected void changeObjectForUpdate() {
    }

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }

	@Test(priority = 14)
	public void testCreateDocument() {
		if (!hasRights("D")) throw new SkipException("No access to this method");
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
		try {
			documentReceived = initDocument();
			documentReceived.setCreatedOnTime(service.createDocument(objectReceived.getId(), documentReceived));
			documentReceived.setType(service.getDocument(objectReceived.getId(), documentReceived.getId()).getType());
			Assert.assertTrue(compare(documentReceived, service.getDocument(objectReceived.getId(), documentReceived.getId())));
		} catch (Exception e) {
			e.printStackTrace(System.err);
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 17)
	public void testUpdatePartiallyDocument() {
		if (!hasRights("D")) throw new SkipException("No access to this method");
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
		try {
			Document documentBase = documentReceived;
			changeDocumentForUpdate();
			Date date = service.updatePartiallyDocument(objectReceived.getId(), documentReceived);
			documentReceived.setUpdatedOnTime(date);
			Document commentModified = service.getDocument(objectReceived.getId(), documentReceived.getId());
			documentReceived.setType(service.getDocument(objectReceived.getId(), documentReceived.getId()).getType());

			Assert.assertTrue(compare(documentReceived, commentModified));
			documentReceived = documentBase;
			date = service.updatePartiallyDocument(objectReceived.getId(), documentBase);
			documentReceived.setUpdatedOnTime(date);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error while comparing object", e);
		}
	}
}
