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
package fr.everwin.open.api.model.supplierorders.lines;

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
 * Supplier order line class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierOrderLine extends BasicObject {

    private DataLink supplierOrder;
    private String title;
    private String reference;
    private DataLink product;
    private Double quantity;
    private SupplierOrderLineMultiCurrencyValue amount;
    private SupplierOrderLineMultiCurrencyValue totalWithoutVat;
    private DataLink vat;
    private DataLink project;
    private DataLink projectLine;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date deliveryDate;
    private List<SpecificData> extraData;

    public SupplierOrderLine() {
        amount = new SupplierOrderLineMultiCurrencyValue();
        totalWithoutVat = new SupplierOrderLineMultiCurrencyValue();
    }

    @Override
    public String toString() {
        return "SupplierOrderLine [supplierOrder=" + supplierOrder + ", quantity=" + quantity + ", amount=" + amount + ", totalWithoutVat=" + totalWithoutVat + ", project=" + project + ", projectLine=" + projectLine + "]";
    }

    public DataLink getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(DataLink supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public DataLink getProduct() {
        return product;
    }

    public void setProduct(DataLink product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public SupplierOrderLineMultiCurrencyValue getAmount() {
        return amount;
    }

    public void setAmount(SupplierOrderLineMultiCurrencyValue amount) {
        this.amount = amount;
    }

    public SupplierOrderLineMultiCurrencyValue getTotalWithoutVat() {
        return totalWithoutVat;
    }

    public void setTotalWithoutVat(SupplierOrderLineMultiCurrencyValue totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }

    public DataLink getVat() {
        return vat;
    }

    public void setVat(DataLink vat) {
        this.vat = vat;
    }

    public DataLink getProject() {
        return project;
    }

    public void setProject(DataLink project) {
        this.project = project;
    }

    public DataLink getProjectLine() {
        return projectLine;
    }

    public void setProjectLine(DataLink projectLine) {
        this.projectLine = projectLine;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
