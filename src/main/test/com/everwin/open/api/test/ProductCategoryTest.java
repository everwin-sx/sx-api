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

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.model.products.categories.Category;
import fr.everwin.open.api.services.products.CategoriesService;

/**
 * @author d.storti
 */
public class ProductCategoryTest extends BasicTest<Category, CategoriesService> {

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new CategoriesService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Category initObject() {
		Category category = new Category();
		category.setLabel("WS-CATEGORY");
		category.setLabel("WS-CATEGORY");

		category.setIsArchived((short)0);
		return category;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setLabel("WS-CATEGORY-MODIFIED");
	}

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }
}
