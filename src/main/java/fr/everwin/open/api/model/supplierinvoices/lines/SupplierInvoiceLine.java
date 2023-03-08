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

package fr.everwin.open.api.model.supplierinvoices.lines;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.ExpenseMultiCurrencyValue;
import fr.everwin.open.api.model.core.SpecificData;

import java.util.List;

/**
 * Represents a supplier invoice line
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class SupplierInvoiceLine extends BasicObject {


    private DataLink supplierInvoice;


    private String title;


    private Double quantity;


    private SupplierInvoiceLineMultiCurrencyValue amount;


    private SupplierInvoiceLineMultiCurrencyValue totalWithoutVat;


    private DataLink vat;


    private SupplierInvoiceLineMultiCurrencyValue vatAmount;


    private SupplierInvoiceLineMultiCurrencyValue vatAmount2;


    private ExpenseMultiCurrencyValue totalIncludingVat;


    private ExpenseMultiCurrencyValue totalToBeCharged;


    private DataLink project;


    private DataLink type;


    private DataLink projectLine;


    private DataLink account;


    private DataLink supplierOrderLine;


    private DataLink supplierDeliveryLine;


    private List<SpecificData> extraData;

    public SupplierInvoiceLine() {
    }

    @Override
    public String toString() {
        return "Supplier invoice line [supplierInvoice=" + (supplierInvoice != null ? supplierInvoice.getId() : null) + ", Title=" + title + "]";
    }

    public DataLink getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(DataLink supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public SupplierInvoiceLineMultiCurrencyValue getAmount() {
        return amount;
    }

    public void setAmount(SupplierInvoiceLineMultiCurrencyValue amount) {
        this.amount = amount;
    }

    public SupplierInvoiceLineMultiCurrencyValue getTotalWithoutVat() {
        return totalWithoutVat;
    }

    public void setTotalWithoutVat(SupplierInvoiceLineMultiCurrencyValue totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }

    public DataLink getVat() {
        return vat;
    }

    public void setVat(DataLink vat) {
        this.vat = vat;
    }

    public SupplierInvoiceLineMultiCurrencyValue getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(SupplierInvoiceLineMultiCurrencyValue vatAmount) {
        this.vatAmount = vatAmount;
    }

    public SupplierInvoiceLineMultiCurrencyValue getVatAmount2() {
        return vatAmount2;
    }

    public void setVatAmount2(SupplierInvoiceLineMultiCurrencyValue vatAmount2) {
        this.vatAmount2 = vatAmount2;
    }

    public ExpenseMultiCurrencyValue getTotalIncludingVat() {
        return totalIncludingVat;
    }

    public void setTotalIncludingVat(ExpenseMultiCurrencyValue totalIncludingVat) {
        this.totalIncludingVat = totalIncludingVat;
    }

    public ExpenseMultiCurrencyValue getTotalToBeCharged() {
        return totalToBeCharged;
    }

    public void setTotalToBeCharged(ExpenseMultiCurrencyValue totalToBeCharged) {
        this.totalToBeCharged = totalToBeCharged;
    }

    public DataLink getProject() {
        return project;
    }

    public void setProject(DataLink project) {
        this.project = project;
    }

    public DataLink getType() {
        return type;
    }

    public void setType(DataLink type) {
        this.type = type;
    }

    public DataLink getProjectLine() {
        return projectLine;
    }

    public void setProjectLine(DataLink projectLine) {
        this.projectLine = projectLine;
    }

    public DataLink getAccount() {
        return account;
    }

    public void setAccount(DataLink account) {
        this.account = account;
    }

    public DataLink getSupplierOrderLine() {
        return supplierOrderLine;
    }

    public void setSupplierOrderLine(DataLink supplierOrderLine) {
        this.supplierOrderLine = supplierOrderLine;
    }

    public DataLink getSupplierDeliveryLine() {
        return supplierDeliveryLine;
    }

    public void setSupplierDeliveryLine(DataLink supplierDeliveryLine) {
        this.supplierDeliveryLine = supplierDeliveryLine;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
