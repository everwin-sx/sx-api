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
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevel;
import fr.everwin.open.api.services.skills.SkillLevelsService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author d.storti
 */
public class SkillLevelsTest extends BasicTest<SkillLevel, SkillLevelsService> {

    public final long DOMAIN = 166592; // skill domain

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SkillLevelsService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SkillLevel initObject() {
        SkillLevel skillLevel = new SkillLevel();
        skillLevel.setLabel("UNITTEST_LEVEL");
        skillLevel.setDomain(new DataLink(DOMAIN, ""));
        skillLevel.setOrder(Short.valueOf("1"));
        skillLevel.setCvParserLevel("Notions");
        return skillLevel;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setOrder(Short.valueOf("2"));
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }
}
