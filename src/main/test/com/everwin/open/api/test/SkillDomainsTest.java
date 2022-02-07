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

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.everwin.open.api.core.BasicTest;

import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.skills.skillsdomains.SkillDomain;
import fr.everwin.open.api.services.skills.SkillDomainsService;

/**
 * @author d.storti
 */
public class SkillDomainsTest extends BasicTest<SkillDomain, SkillDomainsService> {

    public final long ENTI = 123289; // entity

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new SkillDomainsService(clientApi);
		ws_rights = "RWS";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected SkillDomain initObject() {
        SkillDomain skillDomain = new SkillDomain();

        skillDomain.setLabel("UNITTEST_DOMAIN");
        skillDomain.setDescription("Ceci est une description de domaine");
        skillDomain.setIsUnique(Short.valueOf("0"));
        skillDomain.setHasDynamicSkills(Short.valueOf("0"));
        skillDomain.setHasDate(Short.valueOf("1"));
        skillDomain.setHasComment(Short.valueOf("1"));

        List<DataLink> entities = new ArrayList<>();
        entities.add(new DataLink(ENTI, ""));
        skillDomain.setEntities(entities);

        skillDomain.setOrder(Short.valueOf("1000"));
        skillDomain.setCvparserType(Short.valueOf(String.valueOf(1)));

        return skillDomain;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setDescription("Ceci est une description de domaine modified");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        SkillDomain obj = loadFirstObject();
        try {
            service.querySkillsFromSD(obj, null);
            service.querySLFromSD(obj, null);
            service.querySkillsLevelsFromSD(obj, null);
        } catch (CoreException e) {
            e.printStackTrace();
            Assert.fail("Error specific services", e);
        }
    }
}
