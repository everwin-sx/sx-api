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

package fr.everwin.open.api.model.supplierinvoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;

import java.util.Date;
import java.util.List;

/**
 * Represents a supplier invoice
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class SupplierInvoice extends BasicObject {


    private String code;


    private String validationStep;


    private DataLink supplier;


    private DataLink contact;


    private DataLink entity;


    private DataLink financialEntity;


    private DataLink lastValidator;


    private DataLink paymentTerms;


    private DataLink supplierAccount;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date dueDate;


    private String reference;


    private Short settlementStatus;


    private String settlementComents;


    private DataLink fiscalPosition;


    private String currency;


    private Double totalWithoutVat;


    private Double totalIncludingVat;


    private Double totalVat;


    private Double totalToBeCharged;

    private List<SpecificData> extraData;


    public SupplierInvoice() {
        // TODO Auto-generated constructor stub
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public DataLink getSupplier() {
        return supplier;
    }


    public void setSupplier(DataLink supplier) {
        this.supplier = supplier;
    }


    public DataLink getContact() {
        return contact;
    }


    public void setContact(DataLink contact) {
        this.contact = contact;
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


    public DataLink getLastValidator() {
        return lastValidator;
    }


    public void setLastValidator(DataLink lastValidator) {
        this.lastValidator = lastValidator;
    }


    public DataLink getPaymentTerms() {
        return paymentTerms;
    }


    public void setPaymentTerms(DataLink paymentTerms) {
        this.paymentTerms = paymentTerms;
    }


    public DataLink getSupplierAccount() {
        return supplierAccount;
    }


    public void setSupplierAccount(DataLink supplierAccount) {
        this.supplierAccount = supplierAccount;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Date getDueDate() {
        return dueDate;
    }


    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }

    public Short getSettlementStatus() {
        return settlementStatus;
    }


    public void setSettlementStatus(Short settlementStatus) {
        this.settlementStatus = settlementStatus;
    }


    public String getSettlementComents() {
        return settlementComents;
    }


    public void setSettlementComents(String settlementComents) {
        this.settlementComents = settlementComents;
    }


    public DataLink getFiscalPosition() {
        return fiscalPosition;
    }


    public void setFiscalPosition(DataLink fiscalPosition) {
        this.fiscalPosition = fiscalPosition;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public Double getTotalWithoutVat() {
        return totalWithoutVat;
    }


    public void setTotalWithoutVat(Double totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }


    public Double getTotalIncludingVat() {
        return totalIncludingVat;
    }


    public void setTotalIncludingVat(Double totalIncludingVat) {
        this.totalIncludingVat = totalIncludingVat;
    }

    public Double getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(Double totalVat) {
        this.totalVat = totalVat;
    }


    public Double getTotalToBeCharged() {
        return totalToBeCharged;
    }


    public void setTotalToBeCharged(Double totalToBeCharged) {
        this.totalToBeCharged = totalToBeCharged;
    }


    public List<SpecificData> getExtraData() {
        return extraData;
    }


    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        return "Supplier invoice [code=" + code + "]";
    }

    public String getValidationStep() {
        return validationStep;
    }

    public void setValidationStep(String validationStep) {
        this.validationStep = validationStep;
    }
}