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
package fr.everwin.open.api.model.opportunities;

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
import fr.everwin.open.api.model.core.MultiCurrencyValue;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.model.core.SpecificDateValue;
import fr.everwin.open.api.model.core.SpecificLinkValue;
import fr.everwin.open.api.model.core.SpecificMultiLinkValue;
import fr.everwin.open.api.model.core.SpecificNumberValue;
import fr.everwin.open.api.model.core.SpecificStringValue;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Opportunity class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "opportunity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Opportunity extends BasicObject {

	@XmlElement
	private String code;

	@XmlElement
	private String label;
	@XmlElement
	private DataLink customer;
	@XmlElement
	private DataLink contributor;

	@XmlElement
	private DataLink mainContact;
	@XmlElementWrapper(name = "secondaryContacts")
	@XmlElements(@XmlElement(name = "secondaryContact", type = DataLink.class))
	private List<DataLink> secondaryContacts;

	@XmlElement
	private DataLink entity;

	@XmlElement
	private DataLink financialEntity;

	@XmlElement
	private DataLink projectDirector;

	@XmlElement
	private DataLink projectManager;

	@XmlElement
	private DataLink opportunityManager;

	@XmlElement
	private DataLink category;
	@XmlElement
	private DataLink subCategory;

	@XmlElement
	private Short commercialStatus;

	@XmlElement
	private Short invoicingMode;

	@XmlElement
	private DataLink site;
	@XmlElement
	private DataLink salesCycle;
	@XmlElement
	private DataLink salesStep;
	@XmlElement
	private DataLink spanco;
	@XmlElement
	private MultiCurrencyValue proposalAmount;
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date signatureDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date initialStartDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date initialEndDate;
	@XmlElement
	private Short estimatedProbability;
	@XmlElement
	private Double calculatedProbability;
	@XmlElement
	private MultiCurrencyValue estimatedCustomerBudget;
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date responseDeadline;

	@XmlElement
	private Short durationUnit;

	@XmlElement
	private String updatedBy;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedOnTime;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date createdOnTime;
	@XmlElement
	private String managementCurrency;
	@XmlElement
	private String accountCurrency;
	@XmlElement
	private String reportingCurrency;
	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
		@XmlElement(name = "dateval", type = SpecificDateValue.class),
		@XmlElement(name = "numberval", type = SpecificNumberValue.class),
		@XmlElement(name = "link", type = SpecificLinkValue.class),
		@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;

	public Opportunity() {
		proposalAmount = new MultiCurrencyValue();
		estimatedCustomerBudget = new MultiCurrencyValue();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public DataLink getCustomer() {
		return customer;
	}

	public void setCustomer(DataLink customer) {
		this.customer = customer;
	}

	public DataLink getContributor() {
		return contributor;
	}

	public void setContributor(DataLink contributor) {
		this.contributor = contributor;
	}

	public DataLink getMainContact() {
		return mainContact;
	}

	public void setMainContact(DataLink mainContact) {
		this.mainContact = mainContact;
	}

	public List<DataLink> getSecondaryContacts() {
		return secondaryContacts;
	}

	public void setSecondaryContacts(List<DataLink> secondaryContacts) {
		this.secondaryContacts = secondaryContacts;
	}

	public DataLink getEntity() {
		return entity;
	}

	public void setEntity(DataLink entity) {
		this.entity = entity;
	}

	public DataLink getFinancialEntity() {
		return financialEntity;
	}

	public void setFinancialEntity(DataLink financialEntity) {
		this.financialEntity = financialEntity;
	}

	public DataLink getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(DataLink projectDirector) {
		this.projectDirector = projectDirector;
	}

	public DataLink getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(DataLink projectManager) {
		this.projectManager = projectManager;
	}

	public DataLink getOpportunityManager() {
		return opportunityManager;
	}

	public void setOpportunityManager(DataLink opportunityManager) {
		this.opportunityManager = opportunityManager;
	}

	public DataLink getCategory() {
		return category;
	}

	public void setCategory(DataLink category) {
		this.category = category;
	}

	public Short getCommercialStatus() {
		return commercialStatus;
	}

	public void setCommercialStatus(Short commercialStatus) {
		this.commercialStatus = commercialStatus;
	}

	public Short getInvoicingMode() {
		return invoicingMode;
	}

	public void setInvoicingMode(Short invoicingMode) {
		this.invoicingMode = invoicingMode;
	}

	public DataLink getSite() {
		return site;
	}

	public void setSite(DataLink site) {
		this.site = site;
	}

	public DataLink getSalesCycle() {
		return salesCycle;
	}

	public void setSalesCycle(DataLink salesCycle) {
		this.salesCycle = salesCycle;
	}

	public DataLink getSalesStep() {
		return salesStep;
	}

	public void setSalesStep(DataLink salesStep) {
		this.salesStep = salesStep;
	}

	public DataLink getSpanco() {
		return spanco;
	}

	public void setSpanco(DataLink spanco) {
		this.spanco = spanco;
	}

	public MultiCurrencyValue getProposalAmount() {
		return proposalAmount;
	}

	public void setProposalAmount(MultiCurrencyValue proposalAmount) {
		this.proposalAmount = proposalAmount;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public Date getInitialStartDate() {
		return initialStartDate;
	}

	public void setInitialStartDate(Date initialStartDate) {
		this.initialStartDate = initialStartDate;
	}

	public Date getInitialEndDate() {
		return initialEndDate;
	}

	public void setInitialEndDate(Date initialEndDate) {
		this.initialEndDate = initialEndDate;
	}

	public Double getCalculatedProbability() {
		return calculatedProbability;
	}

	public void setCalculatedProbability(Double calculatedProbability) {
		this.calculatedProbability = calculatedProbability;
	}

	public MultiCurrencyValue getEstimatedCustomerBudget() {
		return estimatedCustomerBudget;
	}

	public void setEstimatedCustomerBudget(MultiCurrencyValue estimatedCustomerBudget) {
		this.estimatedCustomerBudget = estimatedCustomerBudget;
	}

	public Date getResponseDeadline() {
		return responseDeadline;
	}

	public void setResponseDeadline(Date responseDeadline) {
		this.responseDeadline = responseDeadline;
	}

	public Short getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(Short durationUnit) {
		this.durationUnit = durationUnit;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public List<SpecificData> getExtraData() {
		return extraData;
	}

	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}

	public DataLink getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(DataLink subCategory) {
		this.subCategory = subCategory;
	}

	public Short getEstimatedProbability() {
		return estimatedProbability;
	}

	public void setEstimatedProbability(Short estimatedProbability) {
		this.estimatedProbability = estimatedProbability;
	}
	public String getManagementCurrency() {
		return managementCurrency;
	}

	public void setManagementCurrency(String managementCurrency) {
		this.managementCurrency = managementCurrency;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public String getReportingCurrency() {
		return reportingCurrency;
	}

	public void setReportingCurrency(String reportingCurrency) {
		this.reportingCurrency = reportingCurrency;
	}

	@Override
	public String toString() {
		return "Opportunity [code=" + code + ", customer=" + customer + "]";
	}

}
