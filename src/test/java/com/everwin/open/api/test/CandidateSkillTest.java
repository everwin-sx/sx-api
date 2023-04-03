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
import fr.everwin.open.api.model.candidates.skills.CandidateSkill;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.candidates.CandidateSkillsService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author d.storti
 */
public class CandidateSkillTest extends BasicTest<CandidateSkill, CandidateSkillsService> {

	private final Long KNRRES = 163967L; // candidate
	private final Long KNRKNW = 166587L; // skill
	private final Long KNRKNL = 135103L; // skill level


	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new CandidateSkillsService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected CandidateSkill initObject() {

		CandidateSkill candidateSkill = new CandidateSkill();
		candidateSkill.setComment("UNITTEST_CANDIDATE_SKILL");

		candidateSkill.setCandidate(new DataLink(KNRRES, ""));
		candidateSkill.setSkill(new DataLink(KNRKNW, ""));
		candidateSkill.setLevel(new DataLink(KNRKNL, ""));

		return candidateSkill;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setComment("comment-modified");
    }

    @Override
    protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
	}
}
