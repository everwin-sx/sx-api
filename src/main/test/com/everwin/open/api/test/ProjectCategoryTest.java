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

import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.projects.categories.ProjectCategory;
import fr.everwin.open.api.services.projects.ProjectCategoryService;

/**
 * @author d.storti
 */
public class ProjectCategoryTest extends BasicTest<ProjectCategory, ProjectCategoryService> {

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ProjectCategoryService(clientApi);
		ws_rights = "RS";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected ProjectCategory initObject() {
		return new ProjectCategory();
	}

    @Override
    protected void changeObjectForUpdate() {
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
		ProjectCategory obj = loadFirstObject();
        try {
		service.querySProjectSubCategories(obj, null);
        } catch (CoreException e) {
            e.printStackTrace();
			Assert.fail("Error specific services", e);
		}
    }

}
