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

package fr.everwin.open.api.model.projects.activities;

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
 * ProjectActivity class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class ProjectActivity extends BasicObject {


    private String code;


    private String label;


    private DataLink phase;


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
    private Date realStartDate;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date realEndDate;


    private String comment;


    private DataLink category;


    private DataLink defaultLineCurrency;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;


    private List<SpecificData> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public DataLink getPhase() {
        return phase;
    }

    public void setPhase(DataLink phase) {
        this.phase = phase;
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

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataLink getCategory() {
        return category;
    }

    public void setCategory(DataLink category) {
        this.category = category;
    }

    public DataLink getDefaultLineCurrency() {
        return defaultLineCurrency;
    }

    public void setDefaultLineCurrency(DataLink defaultLineCurrency) {
        this.defaultLineCurrency = defaultLineCurrency;
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
