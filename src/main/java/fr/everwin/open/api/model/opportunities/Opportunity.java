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
 * Opportunity class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Opportunity extends BasicObject {

    private String code;
    private String label;
    private DataLink customer;
    private DataLink contributor;
    private DataLink mainContact;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "secondaryContact")
    private List<DataLink> secondaryContacts;
    private DataLink entity;
    private DataLink financialEntity;
    private DataLink projectDirector;
    private DataLink projectManager;
    private DataLink opportunityManager;
    private DataLink category;
    private DataLink subCategory;
    private Short commercialStatus;
    private Short invoicingMode;
    private DataLink site;
    private DataLink salesCycle;
    private DataLink salesStep;
    private DataLink spanco;
    private OpportunityMultiCurrencyValue proposalAmount;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date signatureDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date initialStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date initialEndDate;
    private Short estimatedProbability;
    private Double calculatedProbability;
    private OpportunityMultiCurrencyValue estimatedCustomerBudget;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date responseDeadline;
    private Short durationUnit;
    private String updatedBy;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date createdOnTime;
    private String managementCurrency;
    private String accountCurrency;
    private String reportingCurrency;

    private List<SpecificData> extraData;

    /**
     *
     */
    public Opportunity() {
        proposalAmount = new OpportunityMultiCurrencyValue();
        estimatedCustomerBudget = new OpportunityMultiCurrencyValue();
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

    public OpportunityMultiCurrencyValue getProposalAmount() {
        return proposalAmount;
    }

    public void setProposalAmount(OpportunityMultiCurrencyValue proposalAmount) {
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

    public OpportunityMultiCurrencyValue getEstimatedCustomerBudget() {
        return estimatedCustomerBudget;
    }

    public void setEstimatedCustomerBudget(OpportunityMultiCurrencyValue estimatedCustomerBudget) {
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
