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

package fr.everwin.open.api.model.projects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fr.everwin.open.api.model.projects.lines.ProjectDebitCredit;

/**
 * @author d.storti
 */
@XmlRootElement(name = "project-discountablestate")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiscountableProjectState extends ProjectState {

	@XmlElement
	private ProjectDebitCredit discount;

	/**
	 * 
	 */
	public DiscountableProjectState() {
		super();
		discount = new ProjectDebitCredit();
	}

	/**
	 * @return the discount
	 */
	public ProjectDebitCredit getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(ProjectDebitCredit discount) {
		this.discount = discount;
	}

}
