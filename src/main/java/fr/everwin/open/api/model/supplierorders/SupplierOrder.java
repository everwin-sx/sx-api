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
package fr.everwin.open.api.model.supplierorders;

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
 * Supplier order class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class SupplierOrder extends BasicObject {


    private String code;


    private String validationStep;


    private DataLink supplier;


    private DataLink contact;


    private DataLink entity;


    private DataLink financialEntity;


    private DataLink project;


    private DataLink issuer;


    private DataLink supplierAccount;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date creationDate;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date deliveryDate;


    private String supplierReference;


    private String estimateReference;


    private String currency;


    private Double totalWithoutVat;


    private String deliveryAddress;


    private Short deliveryStatus;


    private String comment;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;

    private List<SpecificData> extraData;

    @Override
    public String toString() {
        return "SupplierOrder [code=" + code + ", supplier=" + supplier + ", entity=" + entity + ", issuer=" + issuer + ", extraData=" + extraData + "]";
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

    public DataLink getProject() {
        return project;
    }

    public void setProject(DataLink project) {
        this.project = project;
    }

    public DataLink getIssuer() {
        return issuer;
    }

    public void setIssuer(DataLink issuer) {
        this.issuer = issuer;
    }

    public DataLink getSupplierAccount() {
        return supplierAccount;
    }

    public void setSupplierAccount(DataLink supplierAccount) {
        this.supplierAccount = supplierAccount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getEstimateReference() {
        return estimateReference;
    }

    public void setEstimateReference(String estimateReference) {
        this.estimateReference = estimateReference;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Short getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Short deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getValidationStep() {
        return validationStep;
    }

    public void setValidationStep(String validationStep) {
        this.validationStep = validationStep;
    }
}
