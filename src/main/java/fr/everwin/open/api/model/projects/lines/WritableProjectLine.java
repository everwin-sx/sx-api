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

package fr.everwin.open.api.model.projects.lines;
// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlElementWrapper;
// import javax.xml.bind.annotation.XmlElements;
// import javax.xml.bind.annotation.XmlRootElement;
// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


public class WritableProjectLine extends BasicObject {


    private DataLink activity;


    private DataLink type;


    private DataLink resource;


    private String comment;


    private Short invoicingMode;


    private DataLink product;


    private String unit;


    private String currency;


    private Short order;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date initialStartDate;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date initialEndDate;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedStartDate;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedEndDate;


    private Revenue estimatedRevenue;

    private Discount estimatedDiscount;

    private Expenditure estimatedExpenditure;

    private Revenue forecastRevenue;

    private Expenditure forecastExpenditure;


    private List<SpecificData> extraData;

    public WritableProjectLine() {

    }

    public DataLink getActivity() {
        return activity;
    }

    public void setActivity(DataLink activity) {
        this.activity = activity;
    }

    public DataLink getType() {
        return type;
    }

    public void setType(DataLink type) {
        this.type = type;
    }

    public DataLink getResource() {
        return resource;
    }

    public void setResource(DataLink resource) {
        this.resource = resource;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Short getInvoicingMode() {
        return invoicingMode;
    }

    public void setInvoicingMode(Short invoicingMode) {
        this.invoicingMode = invoicingMode;
    }

    public DataLink getProduct() {
        return product;
    }

    public void setProduct(DataLink product) {
        this.product = product;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
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

    public Date getUpdatedStartDate() {
        return updatedStartDate;
    }

    public void setUpdatedStartDate(Date updatedStartDate) {
        this.updatedStartDate = updatedStartDate;
    }

    public Date getUpdatedEndDate() {
        return updatedEndDate;
    }

    public void setUpdatedEndDate(Date updatedEndDate) {
        this.updatedEndDate = updatedEndDate;
    }

    public Revenue getEstimatedRevenue() {
        return estimatedRevenue;
    }

    public void setEstimatedRevenue(Revenue estimatedRevenue) {
        this.estimatedRevenue = estimatedRevenue;
    }

    public Discount getEstimatedDiscount() {
        return estimatedDiscount;
    }

    public void setEstimatedDiscount(Discount estimatedDiscount) {
        this.estimatedDiscount = estimatedDiscount;
    }

    public Expenditure getEstimatedExpenditure() {
        return estimatedExpenditure;
    }

    public void setEstimatedExpenditure(Expenditure estimatedExpenditure) {
        this.estimatedExpenditure = estimatedExpenditure;
    }

    public Revenue getForecastRevenue() {
        return forecastRevenue;
    }

    public void setForecastRevenue(Revenue forecastRevenue) {
        this.forecastRevenue = forecastRevenue;
    }

    public Expenditure getForecastExpenditure() {
        return forecastExpenditure;
    }

    public void setForecastExpenditure(Expenditure forecastExpenditure) {
        this.forecastExpenditure = forecastExpenditure;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
