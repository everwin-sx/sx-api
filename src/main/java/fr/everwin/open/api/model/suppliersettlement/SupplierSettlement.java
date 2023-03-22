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

package fr.everwin.open.api.model.suppliersettlement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDate;

import java.util.Date;
import java.util.List;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierSettlement extends BasicObject {

    private String code;
    private DataLink entity;
    private DataLink supplier;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date settlementDate;
    private DataLink financialEntity;
    private DataLink settlementType;
    private DataLink bank;
    private String reference;
    private SupplierSettlementMultiCurrencyValue total;
    private String currency;
    private List<SpecificData> extraData;
    private String validationStep;

    public SupplierSettlement() {
        total = new SupplierSettlementMultiCurrencyValue();
    }

    public String getValidationStep() {
        return validationStep;
    }

    public void setValidationStep(String validationStep) {
        this.validationStep = validationStep;
    }

    @Override
    public String toString() {
        return "Supplier Settlement [supplier=" + supplier + ", settlementDate=" + settlementDate + ", total=" + total + "]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public DataLink getSupplier() {
        return supplier;
    }

    public void setSupplier(DataLink supplier) {
        this.supplier = supplier;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public DataLink getFinancialEntity() {
        return financialEntity;
    }

    public void setFinancialEntity(DataLink financialEntity) {
        this.financialEntity = financialEntity;
    }

    public DataLink getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(DataLink settlementType) {
        this.settlementType = settlementType;
    }

    public DataLink getBank() {
        return bank;
    }

    public void setBank(DataLink bank) {
        this.bank = bank;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public SupplierSettlementMultiCurrencyValue getTotal() {
        return total;
    }

    public void setTotal(SupplierSettlementMultiCurrencyValue total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
