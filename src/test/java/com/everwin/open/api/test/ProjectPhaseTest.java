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
import fr.everwin.open.api.model.projects.phases.ProjectPhase;
import fr.everwin.open.api.services.projects.ProjectPhaseService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author d.storti
 */
public class ProjectPhaseTest extends BasicTest<ProjectPhase, ProjectPhaseService> {

    public final long PRJSUBCAT = 1171; // project sub category
    public final long PRJ = 167076;     // project

    @Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ProjectPhaseService(clientApi);
		ws_rights = "R"; // W
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected ProjectPhase initObject() {
        ProjectPhase phase = new ProjectPhase();
        phase.setTitle("title");
        phase.setComment("commentaire");
        phase.setOrder((short) 0);
        phase.setInitialStartDate(null);
        phase.setInitialEndDate(null);
        phase.setProject(new DataLink(PRJ, ""));
        return phase;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setTitle("title-MODIFIED");
    }

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }
}
