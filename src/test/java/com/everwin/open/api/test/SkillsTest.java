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
import fr.everwin.open.api.model.skills.Skill;
import fr.everwin.open.api.services.skills.SkillsService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d.storti
 */
public class SkillsTest extends BasicTest<Skill, SkillsService> {

    public final long DOM = 166586;   // domain
    public final long ENT = 123289;   // entity
    public final long LEVEL = 135105; // skill level

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SkillsService(clientApi);
		ws_rights = "RWS";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Skill initObject() {
        Skill skill = new Skill();
        skill.setLabel("UNITTEST_SKILL");
        skill.setDomain(new DataLink(DOM, ""));
        skill.setDescription("Ceci est une description de compétence");
        List<DataLink> entities = new ArrayList<>();
        entities.add(new DataLink(ENT, ""));
        skill.setEntities(entities);
        skill.setOrder(Short.valueOf("1000"));
        skill.setDefaultLevel(new DataLink(LEVEL, ""));
        return skill;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setDescription("Ceci est une description de compétence-MODIFIED");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        Skill obj = loadFirstObject();
        /*try {
            service.querySLFromSkill(obj, null);
        } catch (CoreException e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }*/
    }
}
