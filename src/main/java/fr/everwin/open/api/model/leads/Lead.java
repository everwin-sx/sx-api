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

package fr.everwin.open.api.model.leads;


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
 * Lead class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lead extends BasicObject {

    private String code;
    private String description;
    private String companyFree;
    private String address;
    private String contactFree;
    private String contactFunction;
    private String phone;
    private String email;
    private DataLink entity;
    private DataLink financialEntity;
    private DataLink affectedTo;
    private DataLink state;
    private DataLink source;
    private Short score;
    private DataLink company;
    private DataLink contact;
    private DataLink opportunity;
    private Short isArchived;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyFree() {
        return companyFree;
    }

    public void setCompanyFree(String companyFree) {
        this.companyFree = companyFree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactFree() {
        return contactFree;
    }

    public void setContactFree(String contactFree) {
        this.contactFree = contactFree;
    }

    public String getContactFunction() {
        return contactFunction;
    }

    public void setContactFunction(String contactFunction) {
        this.contactFunction = contactFunction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public DataLink getAffectedTo() {
        return affectedTo;
    }

    public void setAffectedTo(DataLink affectedTo) {
        this.affectedTo = affectedTo;
    }

    public DataLink getState() {
        return state;
    }

    public void setState(DataLink state) {
        this.state = state;
    }

    public DataLink getSource() {
        return source;
    }

    public void setSource(DataLink source) {
        this.source = source;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public DataLink getCompany() {
        return company;
    }

    public void setCompany(DataLink company) {
        this.company = company;
    }

    public DataLink getContact() {
        return contact;
    }

    public void setContact(DataLink contact) {
        this.contact = contact;
    }

    public DataLink getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(DataLink opportunity) {
        this.opportunity = opportunity;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
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
