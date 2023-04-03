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

package fr.everwin.open.api.model.projects.lines;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.util.JsonDate;

import java.util.Date;

/**
 * ProjectLine class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectLine extends BasicObject {

    private DataLink project;
    private DataLink activity;
    private DataLink type;
    private DataLink employee;
    private DataLink employeeProfile;
    private DataLink equipment;
    private DataLink equipmentFamily;
    private Short status;
    private String comment;
    private Short invoicingMode;
    private DataLink product;
    private String unit;
    private String currency;
    private Short order;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date initialStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date initialEndDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedEndDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date realStartDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date realEndDate;
    private DiscountableProjectState estimated;
    private ProjectState initial;
    private ProjectState updated;
    private ProjectState committed;
    private ProjectState realized;
    private ProjectState produced;

    /**
     *
     */
    public ProjectLine() {
        estimated = new DiscountableProjectState();
        initial = new ProjectState();
        updated = new ProjectState();
        committed = new ProjectState();
        realized = new ProjectState();
        produced = new ProjectState();
    }

    /**
     * @return the project
     */
    public DataLink getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(DataLink project) {
        this.project = project;
    }

    /**
     * @return the activity
     */
    public DataLink getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(DataLink activity) {
        this.activity = activity;
    }

    /**
     * @return the type
     */
    public DataLink getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(DataLink type) {
        this.type = type;
    }

    /**
     * @return the employee
     */
    public DataLink getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(DataLink employee) {
        this.employee = employee;
    }

    /**
     * @return the employeeProfile
     */
    public DataLink getEmployeeProfile() {
        return employeeProfile;
    }

    /**
     * @param employeeProfile the employeeProfile to set
     */
    public void setEmployeeProfile(DataLink employeeProfile) {
        this.employeeProfile = employeeProfile;
    }

    /**
     * @return the equipment
     */
    public DataLink getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the material to set
     */
    public void setEquipment(DataLink equipment) {
        this.equipment = equipment;
    }

    /**
     * @return the equipmentFamily
     */
    public DataLink getEquipmentFamily() {
        return equipmentFamily;
    }

    /**
     * @param equipmentFamily the equipmentFamily to set
     */
    public void setEquipmentFamily(DataLink equipmentFamily) {
        this.equipmentFamily = equipmentFamily;
    }

    /**
     * @return the status
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the invoicingMode
     */
    public Short getInvoicingMode() {
        return invoicingMode;
    }

    /**
     * @param invoicingMode the invoicingMode to set
     */
    public void setInvoicingMode(Short invoicingMode) {
        this.invoicingMode = invoicingMode;
    }

    /**
     * @return the product
     */
    public DataLink getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(DataLink product) {
        this.product = product;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the order
     */
    public Short getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Short order) {
        this.order = order;
    }

    /**
     * @return the initialStartDate
     */
    public Date getInitialStartDate() {
        return initialStartDate;
    }

    /**
     * @param initialStartDate the initialStartDate to set
     */
    public void setInitialStartDate(Date initialStartDate) {
        this.initialStartDate = initialStartDate;
    }

    /**
     * @return the initialEndDate
     */
    public Date getInitialEndDate() {
        return initialEndDate;
    }

    /**
     * @param initialEndDate the initialEndDate to set
     */
    public void setInitialEndDate(Date initialEndDate) {
        this.initialEndDate = initialEndDate;
    }

    /**
     * @return the updatedStartDate
     */
    public Date getUpdatedStartDate() {
        return updatedStartDate;
    }

    /**
     * @param updatedStartDate the updatedStartDate to set
     */
    public void setUpdatedStartDate(Date updatedStartDate) {
        this.updatedStartDate = updatedStartDate;
    }

    /**
     * @return the updatedEndDate
     */
    public Date getUpdatedEndDate() {
        return updatedEndDate;
    }

    /**
     * @param updatedEndDate the updatedEndDate to set
     */
    public void setUpdatedEndDate(Date updatedEndDate) {
        this.updatedEndDate = updatedEndDate;
    }

    /**
     * @return the realStartDate
     */
    public Date getRealStartDate() {
        return realStartDate;
    }

    /**
     * @param realStartDate the realStartDate to set
     */
    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    /**
     * @return the realEndDate
     */
    public Date getRealEndDate() {
        return realEndDate;
    }

    /**
     * @param realEndDate the realEndDate to set
     */
    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    /**
     * @return the estimated
     */
    public DiscountableProjectState getEstimated() {
        return estimated;
    }

    /**
     * @param estimated the estimated to set
     */
    public void setEstimated(DiscountableProjectState estimated) {
        this.estimated = estimated;
    }

    /**
     * @return the initial
     */
    public ProjectState getInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(ProjectState initial) {
        this.initial = initial;
    }

    /**
     * @return the updated
     */
    public ProjectState getUpdated() {
        return updated;
    }

    /**
     * @param updated the updated to set
     */
    public void setUpdated(ProjectState updated) {
        this.updated = updated;
    }

    /**
     * @return the committed
     */
    public ProjectState getCommitted() {
        return committed;
    }

    /**
     * @param committed the committed to set
     */
    public void setCommitted(ProjectState committed) {
        this.committed = committed;
    }

    /**
     * @return the realized
     */
    public ProjectState getRealized() {
        return realized;
    }

    /**
     * @param realized the realized to set
     */
    public void setRealized(ProjectState realized) {
        this.realized = realized;
    }

    /**
     * @return the produced
     */
    public ProjectState getProduced() {
        return produced;
    }

    /**
     * @param produced the produced to set
     */
    public void setProduced(ProjectState produced) {
        this.produced = produced;
    }
}
