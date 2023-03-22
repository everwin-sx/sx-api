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
package fr.everwin.open.api.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDate;
import fr.everwin.open.api.util.JsonListDatalink;
import fr.everwin.open.api.util.JsonListDatalinkKey;

import java.util.Date;
import java.util.List;

/**
 * Project class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project extends BasicObject {

    private String code;
    private String label;
    private Short type;
    private DataLink customer;
    private DataLink mainContact;
    private DataLink entity;
    private DataLink financialEntity;
    private DataLink projectDirector;
    private DataLink projectManager;
    private DataLink opportunityManager;
    private DataLink category;
    private DataLink subCategory;
    private Short productionStatus;
    private Short invoicingMode;
    private Short expenseManagementMode;
    private DataLink paymentTerms;
    private Short adjustableSales;
    private DataLink site;
    private DataLink operation;
    private DataLink mainProject;
    private DataLink bank;
    private String analyticalCode;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date initialStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date initialEndDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedEndDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date realStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date realEndDate;
    private Short durationUnit;
 
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "secondaryContact")
    private List<DataLink> secondaryContacts;
    private DataLink providedBy;
    private String description;
    private String comment;
    private String updatedBy;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date createdOnTime;
    private String accountCurrency;
    private String reportingCurrency;
    private Short planningMode;
    private List<SpecificData> extraData;

    /**
     *
     */
    public Project() {
        // Constructor empty
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
