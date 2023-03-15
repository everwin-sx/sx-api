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

package fr.everwin.open.api.model.workunits;

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
public class WorkUnit extends BasicObject {

    private String code;
    private Date date;
    private Date userDate;
    private DataLink employee;
    private DataLink project;
    private DataLink projectLine;
    private Double consumedQuantity;
    private Double reInvoiceableQuantity;
    private Double reInvoiceableAmount;
    private Double reInvoiceableTotal;
    private String currency;
    private Short doNotEvaluate;
    private String customerComment;
    private String internalComment;
    private String updatedBy;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;
    private List<SpecificData> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public DataLink getEmployee() {
        return employee;
    }

    public void setEmployee(DataLink employee) {
        this.employee = employee;
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

    public Double getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(Double consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public Double getReInvoiceableQuantity() {
        return reInvoiceableQuantity;
    }

    public void setReInvoiceableQuantity(Double reInvoiceableQuantity) {
        this.reInvoiceableQuantity = reInvoiceableQuantity;
    }

    public Double getReInvoiceableAmount() {
        return reInvoiceableAmount;
    }

    public void setReInvoiceableAmount(Double reInvoiceableAmount) {
        this.reInvoiceableAmount = reInvoiceableAmount;
    }

    public Double getReInvoiceableTotal() {
        return reInvoiceableTotal;
    }

    public void setReInvoiceableTotal(Double reInvoiceableTotal) {
        this.reInvoiceableTotal = reInvoiceableTotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Short getDoNotEvaluate() {
        return doNotEvaluate;
    }

    public void setDoNotEvaluate(Short doNotEvaluate) {
        this.doNotEvaluate = doNotEvaluate;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public String getInternalComment() {
        return internalComment;
    }

    public void setInternalComment(String internalComment) {
        this.internalComment = internalComment;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
}
