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
package fr.everwin.open.api.model.equipments;

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
 * Represents an equipment
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class Equipment extends BasicObject {


    private String code;


    private Short type;


    private DataLink entity;


    private DataLink financialEntity;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date arrivalDate;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date leavingDate;


    private DataLink family;


    private DataLink workMode;


    private Double salePrice;


    private Double fullCostPrice;


    private Double directCostPrice;


    private Short isArchived;


    private String comment;


    private String updatedBy;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;

    private List<SpecificData> extraData;

    /**
     *
     */
    public Equipment() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public DataLink getFamily() {
        return family;
    }

    public void setFamily(DataLink family) {
        this.family = family;
    }

    public DataLink getWorkMode() {
        return workMode;
    }

    public void setWorkMode(DataLink workMode) {
        this.workMode = workMode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getFullCostPrice() {
        return fullCostPrice;
    }

    public void setFullCostPrice(Double fullCostPrice) {
        this.fullCostPrice = fullCostPrice;
    }

    public Double getDirectCostPrice() {
        return directCostPrice;
    }

    public void setDirectCostPrice(Double directCostPrice) {
        this.directCostPrice = directCostPrice;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public String toString() {
        return "Equipment [id=" + getId() + ", code=" + getCode() + ", entity=" + getEntity() + ", workMode=" + getWorkMode() + "]";
    }
}
