/*
 * Copyright (C) 2019 Everwin (www.everwin.fr)
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
package com.everwin.open.api.model.projects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Represent a state of a project with revenue and expenditure data
 * @author everwin-team
 */
@XmlRootElement(name = "project-state")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectState {

	@XmlElement
	protected ProjectDebitCredit revenue;

	@XmlElement
	protected ProjectDebitCredit expenditure;

	/**
	 *
	 */
	public ProjectState() {
		revenue = new ProjectDebitCredit();
		expenditure = new ProjectDebitCredit();
	}

	/**
	 * @return the revenue
	 */
	public ProjectDebitCredit getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(ProjectDebitCredit revenue) {
		this.revenue = revenue;
	}

	/**
	 * @return the expenditure
	 */
	public ProjectDebitCredit getExpenditure() {
		return expenditure;
	}

	/**
	 * @param expenditure the expenditure to set
	 */
	public void setExpenditure(ProjectDebitCredit expenditure) {
		this.expenditure = expenditure;
	}

}
