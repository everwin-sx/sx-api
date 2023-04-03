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
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.projects.activities.ProjectActivity;
import fr.everwin.open.api.services.projects.ProjectActivityService;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author d.storti
 */
public class ProjectActivityTest extends BasicTest<ProjectActivity, ProjectActivityService> {

	public static final long PHASELINK = 0;

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ProjectActivityService(clientApi);
		ws_rights = ""; //RWS
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected ProjectActivity initObject() {
		ProjectActivity activity = new ProjectActivity();
		activity.setLabel("WS-ACP");
		activity.setComment("Activité stratégique");
		activity.setOrder((short) 0);
		//activity.setPhase(new DataLink(PHASELINK, ""));
		return activity;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setLabel("WS-ACP-MODIFIED");
	}

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        ProjectActivity obj = loadFirstObject();
        try {
			service.renew(obj);
        	service.renewFrom(obj.getId(), obj);
        } catch (CoreException e) {
            e.printStackTrace();
			Assert.fail("Error specific services", e);
        }
    }
}
