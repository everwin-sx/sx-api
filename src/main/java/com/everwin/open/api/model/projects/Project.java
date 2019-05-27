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

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.everwin.open.api.model.core.BasicObject;
import com.everwin.open.api.model.core.DataLink;
import com.everwin.open.api.model.core.SpecificData;
import com.everwin.open.api.model.core.SpecificDateValue;
import com.everwin.open.api.model.core.SpecificLinkValue;
import com.everwin.open.api.model.core.SpecificMultiLinkValue;
import com.everwin.open.api.model.core.SpecificNumberValue;
import com.everwin.open.api.model.core.SpecificStringValue;
import com.everwin.open.api.util.JsonDateDeserializer;
import com.everwin.open.api.util.XMLDateAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Project class
 * @author everwin-team
 */
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project extends BasicObject {

	@XmlElement
	private String code;

	@XmlElement
	private String label;

	@XmlElement
	private Short type;
	@XmlElement
	private DataLink customer;

	@XmlElement
	private DataLink mainContact;

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
	private Short productionStatus;

	@XmlElement
	private Short invoicingMode;

	@XmlElement
	private Short expenseManagementMode;

	@XmlElement
	private DataLink paymentTerms;

	@XmlElement
	private Short adjustableSales;

	@XmlElement
	private DataLink site;

	@XmlElement
	private DataLink operation;

	@XmlElement
	private DataLink mainProject;

	@XmlElement
	private DataLink bank;

	@XmlElement
	private String analyticalCode;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date initialStartDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date initialEndDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedStartDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedEndDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date realStartDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date realEndDate;

	@XmlElement
	private Short durationUnit;

	@XmlElementWrapper(name = "secondaryContacts")
	@XmlElements(@XmlElement(name = "secondaryContact", type = DataLink.class))
	private List<DataLink> secondaryContacts;

	@XmlElement
	private DataLink providedBy;

	@XmlElement
	private String description;

	@XmlElement
	private String comment;

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
	@XmlElement
	private Short planningMode;

	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
		@XmlElement(name = "dateval", type = SpecificDateValue.class),
		@XmlElement(name = "numberval", type = SpecificNumberValue.class),
		@XmlElement(name = "link", type = SpecificLinkValue.class),
		@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;

	public Project() {

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

	public DataLink getMainContact() {
		return mainContact;
	}

	public void setMainContact(DataLink mainContact) {
		this.mainContact = mainContact;
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

	public Short getProductionStatus() {
		return productionStatus;
	}

	public void setProductionStatus(Short productionStatus) {
		this.productionStatus = productionStatus;
	}

	public Short getInvoicingMode() {
		return invoicingMode;
	}

	public void setInvoicingMode(Short invoicingMode) {
		this.invoicingMode = invoicingMode;
	}

	public Short getExpenseManagementMode() {
		return expenseManagementMode;
	}

	public void setExpenseManagementMode(Short expenseManagementMode) {
		this.expenseManagementMode = expenseManagementMode;
	}

	public DataLink getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(DataLink paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public Short getAdjustableSales() {
		return adjustableSales;
	}

	public void setAdjustableSales(Short adjustableSales) {
		this.adjustableSales = adjustableSales;
	}

	public DataLink getSite() {
		return site;
	}

	public void setSite(DataLink site) {
		this.site = site;
	}

	public DataLink getOperation() {
		return operation;
	}

	public void setOperation(DataLink operation) {
		this.operation = operation;
	}

	public DataLink getMainProject() {
		return mainProject;
	}

	public void setMainProject(DataLink mainProject) {
		this.mainProject = mainProject;
	}

	public DataLink getBank() {
		return bank;
	}

	public void setBank(DataLink bank) {
		this.bank = bank;
	}

	public String getAnalyticalCode() {
		return analyticalCode;
	}

	public void setAnalyticalCode(String analyticalCode) {
		this.analyticalCode = analyticalCode;
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

	public Date getUpdatedStartDate() {
		return updatedStartDate;
	}

	public void setUpdatedStartDate(Date updatedStartDate) {
		this.updatedStartDate = updatedStartDate;
	}

	public Date getUpdatedEndDate() {
		return updatedEndDate;
	}

	public void setUpdatedEndDate(Date updatedEndDate) {
		this.updatedEndDate = updatedEndDate;
	}

	public Date getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(Date realStartDate) {
		this.realStartDate = realStartDate;
	}

	public Date getRealEndDate() {
		return realEndDate;
	}

	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}

	public Short getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(Short durationUnit) {
		this.durationUnit = durationUnit;
	}

	public List<DataLink> getSecondaryContacts() {
		return secondaryContacts;
	}

	public void setSecondaryContacts(List<DataLink> secondaryContacts) {
		this.secondaryContacts = secondaryContacts;
	}

	public DataLink getProvidedBy() {
		return providedBy;
	}

	public void setProvidedBy(DataLink providedBy) {
		this.providedBy = providedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
	public DataLink getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(DataLink subCategory) {
		this.subCategory = subCategory;
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

	public Short getPlanningMode() {
		return planningMode;
	}

	public void setPlanningMode(Short planningMode) {
		this.planningMode = planningMode;
	}
}
