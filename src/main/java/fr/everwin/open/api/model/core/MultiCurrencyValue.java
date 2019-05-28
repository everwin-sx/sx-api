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
package fr.everwin.open.api.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a multi currency value. The value can be in management, account or reporting currency
 * @everwin-team
 */
@XmlRootElement(name = "multi-currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class MultiCurrencyValue {

	@XmlElement
	protected Double management;

	@XmlElement
	protected Double account;

	@XmlElement
	protected Double reporting;


	public MultiCurrencyValue() {

	}

	/**
	 * @return the management
	 */
	public Double getManagement() {
		return management;
	}

	/**
	 * @param management the management to set
	 */
	public void setManagement(Double management) {
		this.management = management;
	}

	/**
	 * @return the account
	 */
	public Double getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Double account) {
		this.account = account;
	}

	/**
	 * @return the reporting
	 */
	public Double getReporting() {
		return reporting;
	}

	/**
	 * @param reporting the reporting to set
	 */
	public void setReporting(Double reporting) {
		this.reporting = reporting;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MultiCurrencyValue) {
			MultiCurrencyValue other = (MultiCurrencyValue) obj;
			return (management == null && other.getManagement() == null || management.equals(other.getManagement())) && (account == null && other.getAccount() == null || account.equals(other.getAccount())) && (reporting == null && other.getReporting() == null || reporting.equals(other.getReporting()));
		} else {
			return false;
		}
	}

}
