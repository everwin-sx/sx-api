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

package fr.everwin.open.api.model.expenses.sheets;
// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlElementWrapper;
// import javax.xml.bind.annotation.XmlElements;
// import javax.xml.bind.annotation.XmlRootElement;
// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
 * ExpenseSheet class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class ExpenseSheet extends BasicObject {


    private String code;


    private DataLink employee;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date creationDate;


    private Double advance;


    private Double totalToPay;


    private DataLink entity;


    private DataLink financialEntity;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date settlementDate;


    private Integer nbDaysLunch;


    private Integer distanceTravelled;


    private String comment;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnPeriod;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;


    private String updatedBy;

    private List<SpecificData> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataLink getEmployee() {
        return employee;
    }

    public void setEmployee(DataLink employee) {
        this.employee = employee;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(Double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public DataLink getFinancialEntity() {
        return financialEntity;
    }

    public void setFinancialEntity(DataLink financialEntity) {
        this.financialEntity = financialEntity;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Integer getNbDaysLunch() {
        return nbDaysLunch;
    }

    public void setNbDaysLunch(Integer nbDaysLunch) {
        this.nbDaysLunch = nbDaysLunch;
    }

    public Integer getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(Integer distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    public Date getCreatedOnPeriod() {
        return createdOnPeriod;
    }

    public void setCreatedOnPeriod(Date createdOnPeriod) {
        this.createdOnPeriod = createdOnPeriod;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        return "ExpenseSheet [code=" + code + ", employee=" + employee + "]";
    }
}
