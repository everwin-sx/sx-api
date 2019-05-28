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

/**
 * 
 */
package fr.everwin.open.api.model.companies;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.model.core.SpecificDateValue;
import fr.everwin.open.api.model.core.SpecificLinkValue;
import fr.everwin.open.api.model.core.SpecificMultiLinkValue;
import fr.everwin.open.api.model.core.SpecificNumberValue;
import fr.everwin.open.api.model.core.SpecificStringValue;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Company accounts represents a company managed by business management module. <br>
 * Customer accounts keep administrative information about customers and suppliers safe from any CRM module changes.
 * @author everwin-team
 */
@XmlRootElement(name = "companyaccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyAccount extends BasicObject {

	@XmlElement
	private String code;

	@XmlElement
	private DataLink company;

	@XmlElement
	private List<DataLink> entities;

	@XmlElement
	private String identifierNumber;

	@XmlElement
	private String vatNumber;

	@XmlElement
	private String billingName;

	@XmlElement
	private String billingRecipient;

	@XmlElement
	private String billingAddress;

	@XmlElement
	private String billingAddress2;

	@XmlElement
	private String billingAddress3;

	@XmlElement
	private String billingPostalCode;

	@XmlElement
	private String billingCity;

	@XmlElement
	private DataLink billingCountry;

	@XmlElement
	private String billingPhone;

	@XmlElement
	private String billingFax;

	@XmlElement
	private String shippingName;

	@XmlElement
	private String shippingRecipient;

	@XmlElement
	private String shippingAddress;

	@XmlElement
	private String shippingAddress2;

	@XmlElement
	private String shippingAddress3;

	@XmlElement
	private String shippingPostalCode;

	@XmlElement
	private String shippingCity;

	@XmlElement
	private DataLink shippingCountry;

	@XmlElement
	private String shippingPhone;

	@XmlElement
	private String shippingFax;

	@XmlElement
	private DataLink paymentTerms;

	@XmlElement
	private Short vatSystem;

	@XmlElement
	private DataLink defaultVat;

	@XmlElement
	private DataLink defaultBank;

	@XmlElement
	private DataLink fiscalPosition;

	@XmlElement
	private Short isActive;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedOnTime;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date createdOnTime;

	@XmlElement
	private String updatedBy;


	@XmlElement
	private DataLink factor;

	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
				  @XmlElement(name = "dateval", type = SpecificDateValue.class),
				  @XmlElement(name = "numberval", type = SpecificNumberValue.class),
				  @XmlElement(name = "link", type = SpecificLinkValue.class),
				  @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;
	public CompanyAccount() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DataLink getCompany() {
		return company;
	}

	public void setCompany(DataLink company) {
		this.company = company;
	}

	public List<DataLink> getEntities() {
		return entities;
	}

	public void setEntities(List<DataLink> entities) {
		this.entities = entities;
	}

	public String getIdentifierNumber() {
		return identifierNumber;
	}

	public void setIdentifierNumber(String identifierNumber) {
		this.identifierNumber = identifierNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getBillingRecipient() {
		return billingRecipient;
	}

	public void setBillingRecipient(String billingRecipient) {
		this.billingRecipient = billingRecipient;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingAddress3() {
		return billingAddress3;
	}

	public void setBillingAddress3(String billingAddress3) {
		this.billingAddress3 = billingAddress3;
	}

	public String getBillingPostalCode() {
		return billingPostalCode;
	}

	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public DataLink getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(DataLink billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingPhone() {
		return billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
	}

	public String getBillingFax() {
		return billingFax;
	}

	public void setBillingFax(String billingFax) {
		this.billingFax = billingFax;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingRecipient() {
		return shippingRecipient;
	}

	public void setShippingRecipient(String shippingRecipient) {
		this.shippingRecipient = shippingRecipient;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingAddress2() {
		return shippingAddress2;
	}

	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}

	public String getShippingAddress3() {
		return shippingAddress3;
	}

	public void setShippingAddress3(String shippingAddress3) {
		this.shippingAddress3 = shippingAddress3;
	}

	public String getShippingPostalCode() {
		return shippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public DataLink getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(DataLink shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public String getShippingFax() {
		return shippingFax;
	}

	public void setShippingFax(String shippingFax) {
		this.shippingFax = shippingFax;
	}

	public DataLink getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(DataLink paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public Short getVatSystem() {
		return vatSystem;
	}

	public void setVatSystem(Short vatSystem) {
		this.vatSystem = vatSystem;
	}

	public DataLink getDefaultVat() {
		return defaultVat;
	}

	public void setDefaultVat(DataLink defaultVat) {
		this.defaultVat = defaultVat;
	}

	public DataLink getDefaultBank() {
		return defaultBank;
	}

	public void setDefaultBank(DataLink defaultBank) {
		this.defaultBank = defaultBank;
	}

	public DataLink getFiscalPosition() {
		return fiscalPosition;
	}

	public void setFiscalPosition(DataLink fiscalPosition) {
		this.fiscalPosition = fiscalPosition;
	}

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public Date getUpdatedOnTime() {
		return updatedOnTime;
	}

	public void setUpdatedOnTime(Date updatedOnTime) {
		this.updatedOnTime = updatedOnTime;
	}

	public Date getCreatedOnTime() {
		return createdOnTime;
	}

	public void setCreatedOnTime(Date createdOnTime) {
		this.createdOnTime = createdOnTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<SpecificData> getExtraData() {
		return extraData;
	}

	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}

	public DataLink getFactor() {
		return factor;
	}

	public void setFactor(DataLink factor) {
		this.factor = factor;
	}
}
