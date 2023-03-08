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

package fr.everwin.open.api.model.suppliersettlement.lines;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;

import java.util.List;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class SupplierSettlementLine extends BasicObject {


    private DataLink supplierSettlement;


    private DataLink supplierInvoice;


    private SupplierSettlementLineMultiCurrencyValue amount;


    private Short state;

    private List<SpecificData> extraData;

    public SupplierSettlementLine() {
        amount = new SupplierSettlementLineMultiCurrencyValue();
    }

    @Override
    public String toString() {
        return "Supplier settlement line [supplierSettlement=" + (supplierSettlement != null ? supplierSettlement.getId() : null) + "]";
    }

    public DataLink getSupplierSettlement() {
        return supplierSettlement;
    }

    public void setSupplierSettlement(DataLink supplierSettlement) {
        this.supplierSettlement = supplierSettlement;
    }

    public DataLink getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(DataLink supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public SupplierSettlementLineMultiCurrencyValue getAmount() {
        return amount;
    }

    public void setAmount(SupplierSettlementLineMultiCurrencyValue amount) {
        this.amount = amount;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
