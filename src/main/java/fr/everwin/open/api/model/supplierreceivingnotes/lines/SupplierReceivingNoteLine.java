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

package fr.everwin.open.api.model.supplierreceivingnotes.lines;

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
public class SupplierReceivingNoteLine extends BasicObject {

    private DataLink supplierReceivingNote;
    private String title;
    private Double quantity;
    private SupplierReceivingNoteLineMultiCurrencyValue totalWithoutVat;
    private Double percentage;
    private DataLink project;
    private DataLink type;
    private DataLink projectLine;
    private DataLink supplierOrderLine;
    private String currency;
    private Short receiptStatus;

    private List<SpecificData> extraData;

    public SupplierReceivingNoteLine() {
        totalWithoutVat = new SupplierReceivingNoteLineMultiCurrencyValue();
    }

    @Override
    public String toString() {
        return "Supplier receiving note line [supplierReceivingNote=" + (supplierReceivingNote != null ? supplierReceivingNote.getId() : null) + ", Title=" + title + "]";
    }

    public DataLink getSupplierReceivingNote() {
        return supplierReceivingNote;
    }

    public void setSupplierReceivingNote(DataLink supplierReceivingNote) {
        this.supplierReceivingNote = supplierReceivingNote;
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

    public SupplierReceivingNoteLineMultiCurrencyValue getTotalWithoutVat() {
        return totalWithoutVat;
    }

    public void setTotalWithoutVat(SupplierReceivingNoteLineMultiCurrencyValue totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
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

    public DataLink getSupplierOrderLine() {
        return supplierOrderLine;
    }

    public void setSupplierOrderLine(DataLink supplierOrderLine) {
        this.supplierOrderLine = supplierOrderLine;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Short getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(Short receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
