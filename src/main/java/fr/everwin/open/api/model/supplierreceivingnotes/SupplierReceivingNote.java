/*
 * Copyright (C) 2021 Everwin (www.everwin.fr)
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

package fr.everwin.open.api.model.supplierreceivingnotes;

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
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class SupplierReceivingNote extends BasicObject {


    private String code;


    private String validationStep;


    private DataLink supplier;


    private DataLink entity;


    private DataLink financialEntity;


    private DataLink issuer;


    private DataLink supplierAccount;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date;


    private String reference;

    private List<SpecificData> extraData;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
