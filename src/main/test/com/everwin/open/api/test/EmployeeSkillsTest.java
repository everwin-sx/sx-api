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

import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.employees.skills.EmployeeSkill;
import fr.everwin.open.api.services.employees.EmployeesSkillsService;

/**
 * @author d.storti
 */
public class EmployeeSkillsTest extends BasicTest<EmployeeSkill, EmployeesSkillsService> {

	private final long KNRES = 107055;  // employee
	private final long KNRKNW = 166587; // skill
	private final long KNRKNL = 135103; // skill level

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new EmployeesSkillsService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected EmployeeSkill initObject() {
		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setEmployee(new DataLink(KNRES, ""));
		employeeSkill.setSkill(new DataLink(KNRKNW, ""));
		employeeSkill.setLevel(new DataLink(KNRKNL, ""));
		return employeeSkill;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setEmployee(new DataLink(163192L, ""));
	}

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
	}
}
