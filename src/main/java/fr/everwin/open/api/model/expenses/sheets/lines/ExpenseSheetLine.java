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

package fr.everwin.open.api.model.expenses.sheets.lines;

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
 * ExpenseSheetLine class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpenseSheetLine extends BasicObject {


    private DataLink expenseSheet;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date date;
    private DataLink project;
    private DataLink type;
    private DataLink projectLine;
    private DataLink missionOrder;
    private String title;
    private String comment;
    private String place;
    private String lettering;
    private Double quantity;
    private DataLink currency;
    private ExpenseSheetLineMultiCurrencyValue amount;
    private ExpenseSheetLineMultiCurrencyValue totalIncludingVat;
    private ExpenseSheetLineMultiCurrencyValue totalWithoutVat;
    private ExpenseSheetLineMultiCurrencyValue totalInvoiceAgain;
    private Double vat;
    private Short reinvoiceable;
    private String startingAddress;
    private String arrivalAddress;
    private DataLink account;
    private DataLink vehicle;
    private Double distanceToDate;
    private Short nonRefundable;

    private List<SpecificData> extraData;

    public ExpenseSheetLine() {
        //amount = new ExpenseSheetLineMultiCurrencyValue();
        //totalIncludingVat = new ExpenseSheetLineMultiCurrencyValue();
        //totalWithoutVat = new ExpenseSheetLineMultiCurrencyValue();
        //totalInvoiceAgain = new ExpenseSheetLineMultiCurrencyValue();
    }

    @Override
    public String toString() {
        return "Supplier invoice line [supplierInvoice=" + (expenseSheet != null ? expenseSheet.getId() : null) + ", Title=" + title + "]";
    }

    public DataLink getExpenseSheet() {
        return expenseSheet;
    }

    public void setExpenseSheet(DataLink expenseSheet) {
        this.expenseSheet = expenseSheet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public DataLink getMissionOrder() {
        return missionOrder;
    }

    public void setMissionOrder(DataLink missionOrder) {
        this.missionOrder = missionOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLettering() {
        return lettering;
    }

    public void setLettering(String lettering) {
        this.lettering = lettering;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public DataLink getCurrency() {
        return currency;
    }

    public void setCurrency(DataLink currency) {
        this.currency = currency;
    }

    public ExpenseSheetLineMultiCurrencyValue getAmount() {
        return amount;
    }

    public void setAmount(ExpenseSheetLineMultiCurrencyValue amount) {
        this.amount = amount;
    }

    public ExpenseSheetLineMultiCurrencyValue getTotalIncludingVat() {
        return totalIncludingVat;
    }

    public void setTotalIncludingVat(ExpenseSheetLineMultiCurrencyValue totalIncludingVat) {
        this.totalIncludingVat = totalIncludingVat;
    }

    public ExpenseSheetLineMultiCurrencyValue getTotalWithoutVat() {
        return totalWithoutVat;
    }

    public void setTotalWithoutVat(ExpenseSheetLineMultiCurrencyValue totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }

    public ExpenseSheetLineMultiCurrencyValue getTotalInvoiceAgain() {
        return totalInvoiceAgain;
    }

    public void setTotalInvoiceAgain(ExpenseSheetLineMultiCurrencyValue totalInvoiceAgain) {
        this.totalInvoiceAgain = totalInvoiceAgain;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Short getReinvoiceable() {
        return reinvoiceable;
    }

    public void setReinvoiceable(Short reinvoiceable) {
        this.reinvoiceable = reinvoiceable;
    }

    public String getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(String startingAddress) {
        this.startingAddress = startingAddress;
    }

    public String getArrivalAddress() {
        return arrivalAddress;
    }

    public void setArrivalAddress(String arrivalAddress) {
        this.arrivalAddress = arrivalAddress;
    }

    public DataLink getAccount() {
        return account;
    }

    public void setAccount(DataLink account) {
        this.account = account;
    }

    public DataLink getVehicle() {
        return vehicle;
    }

    public void setVehicle(DataLink vehicle) {
        this.vehicle = vehicle;
    }

    public Double getDistanceToDate() {
        return distanceToDate;
    }

    public void setDistanceToDate(Double distanceToDate) {
        this.distanceToDate = distanceToDate;
    }

    public Short getNonRefundable() {
        return nonRefundable;
    }

    public void setNonRefundable(Short nonRefundable) {
        this.nonRefundable = nonRefundable;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
