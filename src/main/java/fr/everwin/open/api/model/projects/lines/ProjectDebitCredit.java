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

package fr.everwin.open.api.model.projects.lines;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.everwin.open.api.model.projects.lines.ProjectLineMultiCurrencyValue;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "debit-credit")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectDebitCredit {

	@XmlElement
	private Double quantity;

	@XmlElement
	private ProjectLineMultiCurrencyValue amount;

	@XmlElement
	private ProjectLineMultiCurrencyValue total;

	/**
	 *
	 */
	public ProjectDebitCredit() {
		amount = new ProjectLineMultiCurrencyValue();
		total = new ProjectLineMultiCurrencyValue();
	}

	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the amount
	 */
	public ProjectLineMultiCurrencyValue getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(ProjectLineMultiCurrencyValue amount) {
		this.amount = amount;
	}

	/**
	 * @return the total
	 */
	public ProjectLineMultiCurrencyValue getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(ProjectLineMultiCurrencyValue total) {
		this.total = total;
	}

}
