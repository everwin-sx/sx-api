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

package fr.everwin.open.api.model.missionorders;


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
public class MissionOrder extends BasicObject {

    private String code;
    private Long number;
    private DataLink employee;
    private DataLink project;
    private DataLink projectLine;
    private Short status;
    private String departurePlace;
    private String arrivalPlace;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date departureDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date arrivalDate;
    private String description;
    private Short compensationMode;
    private String employeeAddress;
    private Double estimatedFlatRateExpenses;
    private Double estimatedExpensesToJustify;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date advanceGrantDate;
    private Double advanceAmount;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date settlementDate;
    private String settlementDetails;
    private Short settled;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date balanceDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date createdOnTime;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedOnTime;
    private Short otherPossibleExpenses;
    private List<SpecificData> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getCompensationMode() {
        return compensationMode;
    }

    public void setCompensationMode(Short compensationMode) {
        this.compensationMode = compensationMode;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Double getEstimatedFlatRateExpenses() {
        return estimatedFlatRateExpenses;
    }

    public void setEstimatedFlatRateExpenses(Double estimatedFlatRateExpenses) {
        this.estimatedFlatRateExpenses = estimatedFlatRateExpenses;
    }

    public Double getEstimatedExpensesToJustify() {
        return estimatedExpensesToJustify;
    }

    public void setEstimatedExpensesToJustify(Double estimatedExpensesToJustify) {
        this.estimatedExpensesToJustify = estimatedExpensesToJustify;
    }

    public Date getAdvanceGrantDate() {
        return advanceGrantDate;
    }

    public void setAdvanceGrantDate(Date advanceGrantDate) {
        this.advanceGrantDate = advanceGrantDate;
    }

    public Double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(Double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getSettlementDetails() {
        return settlementDetails;
    }

    public void setSettlementDetails(String settlementDetails) {
        this.settlementDetails = settlementDetails;
    }

    public Short getSettled() {
        return settled;
    }

    public void setSettled(Short settled) {
        this.settled = settled;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public Short getOtherPossibleExpenses() {
        return otherPossibleExpenses;
    }

    public void setOtherPossibleExpenses(Short otherPossibleExpenses) {
        this.otherPossibleExpenses = otherPossibleExpenses;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
