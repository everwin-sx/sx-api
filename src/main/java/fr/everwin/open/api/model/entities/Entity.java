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

package fr.everwin.open.api.model.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;

/**
 * Represents an organization level in SX
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entity extends BasicObject {

	@XmlElement
	private String code;

	@XmlElement(required = true, nillable = false)
	protected String name;

	@XmlElement
	protected String businessName;

	@XmlElement
	public Short isArchived;

	@XmlElement
	public Short isAccounting;

	@XmlElement
	public Integer type;

	@XmlElement
	public Integer position;

	DataLink parent;

	@XmlElement
	protected String accountingId;

	@XmlElement
	public Short isAnalytical;

	@XmlElement
	protected String phone;

	@XmlElement
	protected String fax;

	@XmlElement
	public String vatNumber;

	@XmlElement
	protected DataLink accountCurrency;

	@XmlElement
	protected DataLink manageCurrency;

	@XmlElement
	protected DataLink reportCurrency;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Short getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Short isArchived) {
		this.isArchived = isArchived;
	}

	public Short getIsAccounting() {
		return isAccounting;
	}

	public void setIsAccounting(Short isAccounting) {
		this.isAccounting = isAccounting;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public DataLink getParent() {
		return parent;
	}

	public void setParent(DataLink parent) {
		this.parent = parent;
	}

	public String getAccountingId() {
		return accountingId;
	}

	public void setAccountingId(String accountingId) {
		this.accountingId = accountingId;
	}

	public Short getIsAnalytical() {
		return isAnalytical;
	}

	public void setIsAnalytical(Short isAnalytical) {
		this.isAnalytical = isAnalytical;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public DataLink getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(DataLink accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public DataLink getManageCurrency() {
		return manageCurrency;
	}

	public void setManageCurrency(DataLink manageCurrency) {
		this.manageCurrency = manageCurrency;
	}

	public DataLink getReportCurrency() {
		return reportCurrency;
	}

	public void setReportCurrency(DataLink reportCurrency) {
		this.reportCurrency = reportCurrency;
	}
}
