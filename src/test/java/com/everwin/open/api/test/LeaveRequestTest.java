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
import fr.everwin.open.api.model.leaverequests.HalfDayIndicator;
import fr.everwin.open.api.model.leaverequests.LeaveRequest;
import fr.everwin.open.api.services.leaverequests.LeaveRequestsService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author d.storti
 */
public class LeaveRequestTest extends BasicTest<LeaveRequest, LeaveRequestsService> {

	public final long ENTLINK = 105231;       // entity
	public final long EMPLOYEELINK = 107055;  // employee
	public final long TYPELINK = 177255;      // leave request type

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new LeaveRequestsService(clientApi);
		ws_rights = "RD"; //W
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected LeaveRequest initObject() {
		LeaveRequest leaveRequest = new LeaveRequest();

		leaveRequest.setEmployee(new DataLink(EMPLOYEELINK, ""));
		leaveRequest.setType(new DataLink(TYPELINK, ""));
		leaveRequest.setStartDate(parseDate("2107-08-05T00:00:00"));
		leaveRequest.setStartHalfDayIndicator(HalfDayIndicator.MORNING.getValue());
		leaveRequest.setEndDate(parseDate("2107-08-06T00:00:00"));
		leaveRequest.setEndHalfDayIndicator(HalfDayIndicator.ENDOFDAY.getValue());
		leaveRequest.setValidationStep("STEP0");
		leaveRequest.setEntity(new DataLink(ENTLINK, ""));
		return leaveRequest;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setValidationStep("STEP1");

	}

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }
}
