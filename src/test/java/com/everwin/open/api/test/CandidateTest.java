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
import fr.everwin.open.api.model.candidates.Candidate;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.documents.Document;
import fr.everwin.open.api.services.candidates.CandidatesService;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author d.storti
 */
public class CandidateTest extends BasicTest<Candidate, CandidatesService>  {

	private final long RESCRST = 22;        // status
	private final long RESCRER = 12;        // connection type
	private final long RESCCAC = 105026;    // activity category
	private final long RESCREJ = 25;        // business
	private final long RESCREO = 11;        // candidacy origin
	private final long RESCREN = 38;        // experience duration
	private final long RESCRAV = 9;         // availability
	private final long RESEDL = 26;         // degree level
	private final long RESNCITY = 65;       // nationality
	private final long RESCITY = 65;        // country
	private final short CIVILRES = 1;       // title
	private final long RESMRES = 163074;    // manager
	private final long RESRRES = 163073;    // recruitment manager

	@Override
	@BeforeTest
	public void setUp() {
		try {
			super.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		service = new CandidatesService(clientApi);
		objectReceived = initObject();
		ws_rights = "RDS"; //WC
	}

	@Override
	protected Candidate initObject() {
		Candidate candidate = new Candidate();
		candidate.setTitle(CIVILRES);
		candidate.setFirstName("Michel");
		candidate.setLastName("BigSmith");
		candidate.setFamilySituation("Célibataire");
		candidate.setBirthDate(parseDate("1978-04-21T00:00:00"));
		candidate.setNationality(new DataLink(RESNCITY, "FRANCE"));
		candidate.setCountry(new DataLink(RESCITY, "FRANCE"));
		candidate.setStatus(new DataLink(RESCRST, "EVERWIN_UNITTEST"));
		candidate.setConnectionType(new DataLink(RESCRER, ""));
		candidate.setUpdatedBy("EVERWIN_UNITTEST");

		List<DataLink> activityCategories = new ArrayList<>();
		activityCategories.add(new DataLink(RESCCAC, ""));
		candidate.setActivityCategories(activityCategories);

		List<DataLink> businesses = new ArrayList<>();
		businesses.add(new DataLink(RESCREJ, ""));
		candidate.setBusinesses(businesses);

		candidate.setCandidacyOrigin(new DataLink(RESCREO, ""));
		candidate.setExperienceDuration(new DataLink(RESCREN, ""));
		candidate.setAvailability(new DataLink(RESCRAV, ""));
		candidate.setDegreeLevel(new DataLink(RESEDL, ""));
		candidate.setManager(new DataLink(RESMRES, ""));

		candidate.setRecruitmentManager(new DataLink(RESRRES, ""));
		candidate.setCvTitle("Developeur JAVA");
		candidate.setIsArchived(Integer.valueOf(0).shortValue());
		candidate.setCandidacyComment("Très bon candidat au post de dev JAVA");

		candidate.setPersonalPhone("01 85 96 12 35");
		candidate.setPersonalMobile("06 85 96 12 44");
		candidate.setPersonalEmail("candidat@b.c");

		candidate.setAddress("3 chemin neuf");
		candidate.setAddress2("bat 1");
		candidate.setAddress3("BP 5023");
		candidate.setPostalCode("69555");
		candidate.setCity("Lyon");
		return candidate;
	}

	@Override
	protected void changeObjectForUpdate() {
		objectReceived.setPersonalEmail("jhon.smith2@everwin.fr");
	}

	@Override
	protected void otherServices() {
		if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
		Candidate candidate = loadFirstObject();
		try {
			service.querySkillsFromCandidates(candidate,null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
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
