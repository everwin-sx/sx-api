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

package fr.everwin.open.api.model.projects.phases;

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
 * ProjectLine class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectPhase extends BasicObject {

    private String code;
    private DataLink project;
    private Short order;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date initialStartDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date initialEndDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedStartDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedEndDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date actualStartDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date actualEndDate;
    private String comment;
    private String title;
    private Long number;
    private Long distributionRate;
    private DataLink category;
    private Short resumption;
    private DataLink currency;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    private List<SpecificData> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataLink getProject() {
        return project;
    }

    public void setProject(DataLink project) {
        this.project = project;
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

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getDistributionRate() {
        return distributionRate;
    }

    public void setDistributionRate(Long distributionRate) {
        this.distributionRate = distributionRate;
    }

    public DataLink getCategory() {
        return category;
    }

    public void setCategory(DataLink category) {
        this.category = category;
    }

    public Short getResumption() {
        return resumption;
    }

    public void setResumption(Short resumption) {
        this.resumption = resumption;
    }

    public DataLink getCurrency() {
        return currency;
    }

    public void setCurrency(DataLink currency) {
        this.currency = currency;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
