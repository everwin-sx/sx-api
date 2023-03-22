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
package fr.everwin.open.api.model.leaverequests;

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
import java.util.Objects;

/**
 * Represent an employee's leave request
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaveRequest extends BasicObject {

    private String code;
    private DataLink employee;
    private DataLink entity;
    private DataLink type;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date startDate;
    private String startHalfDayIndicator;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date endDate;
    private String endHalfDayIndicator;
    private String validationStep;
    private Double duration;
    private List<SpecificData> extraData;

//	@ApiModelProperty(value = "Indicates if leaver request is cancel or refused", allowableValues = "range[0, 1]")
//	
//	private Short isCanceled;

    /**
     *
     */
    public LeaveRequest() {
        // Constructor empty
    }

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

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public DataLink getType() {
        return type;
    }

    public void setType(DataLink type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getStartHalfDayIndicator() {
        return startHalfDayIndicator;
    }

    public void setStartHalfDayIndicator(String startHalfDayIndicator) {
        this.startHalfDayIndicator = startHalfDayIndicator;
    }

    public String getEndHalfDayIndicator() {
        return endHalfDayIndicator;
    }

    public void setEndHalfDayIndicator(String endHalfDayIndicator) {
        this.endHalfDayIndicator = endHalfDayIndicator;
    }

    public String getValidationStep() {
        return validationStep;
    }

    public void setValidationStep(String validationStep) {
        this.validationStep = validationStep;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof LeaveRequest)) {
            return false;
        }

        LeaveRequest otherLR = ((LeaveRequest) obj);
        return Objects.equals(this.id, otherLR.getId()) &&
                Objects.equals(employee.getId(), otherLR.getEmployee() != null ? otherLR.getEmployee().getId() : null) &&
                Objects.equals(type.getId(), otherLR.getType() != null ? otherLR.getType().getId() : null) &&
                Objects.equals(startDate, otherLR.getStartDate()) &&
                Objects.equals(startHalfDayIndicator, otherLR.getStartHalfDayIndicator()) &&
                Objects.equals(endDate, otherLR.getEndDate()) &&
                Objects.equals(endHalfDayIndicator, otherLR.getEndHalfDayIndicator());
    }
}
