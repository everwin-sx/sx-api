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


package fr.everwin.open.api.model.candidates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDate;
import fr.everwin.open.api.util.JsonListDatalink;
import fr.everwin.open.api.util.JsonListDatalinkKey;

import java.util.Date;
import java.util.List;


/**
 * Candidate class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidate extends BasicObject {

    private String code;
    private String firstName;
    private String lastName;
    private Short title;
    private String familySituation;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date birthDate;
    private DataLink nationality;
    private DataLink status;
    private DataLink connectionType;
 
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "profile")
    private List<DataLink> activityCategories;
 
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "profile")
    private List<DataLink> businesses;
    private DataLink candidacyOrigin;
    private DataLink experienceDuration;
    private DataLink availability;
    private DataLink degreeLevel;
    private DataLink manager;
    private DataLink recruitmentManager;
    private String cvTitle;
    private Short isArchived;
    private String candidacyComment;
    private String personalPhone;
    private String personalMobile;
    private String personalEmail;
    private String address;
    private String address2;
    private String address3;
    private String postalCode;
    private String city;
    private DataLink country;
    private String updatedBy;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date createdOnTime;
    private List<SpecificData> extraData;

    /**
     *
     */
    public Candidate() {
        // Constructor empty
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Short getTitle() {
        return title;
    }

    public void setTitle(Short title) {
        this.title = title;
    }

    public String getFamilySituation() {
        return familySituation;
    }

    public void setFamilySituation(String familySituation) {
        this.familySituation = familySituation;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public DataLink getStatus() {
        return status;
    }

    public void setStatus(DataLink status) {
        this.status = status;
    }

    public DataLink getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(DataLink connectionType) {
        this.connectionType = connectionType;
    }

    public List<DataLink> getActivityCategories() {
        return activityCategories;
    }

    public void setActivityCategories(List<DataLink> activityCategories) {
        this.activityCategories = activityCategories;
    }

    public List<DataLink> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<DataLink> businesses) {
        this.businesses = businesses;
    }

    public DataLink getCandidacyOrigin() {
        return candidacyOrigin;
    }

    public void setCandidacyOrigin(DataLink candidacyOrigin) {
        this.candidacyOrigin = candidacyOrigin;
    }

    public DataLink getExperienceDuration() {
        return experienceDuration;
    }

    public void setExperienceDuration(DataLink experienceDuration) {
        this.experienceDuration = experienceDuration;
    }

    public DataLink getAvailability() {
        return availability;
    }

    public void setAvailability(DataLink availability) {
        this.availability = availability;
    }

    public DataLink getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(DataLink degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public DataLink getManager() {
        return manager;
    }

    public void setManager(DataLink manager) {
        this.manager = manager;
    }

    public DataLink getRecruitmentManager() {
        return recruitmentManager;
    }

    public void setRecruitmentManager(DataLink recruitmentManager) {
        this.recruitmentManager = recruitmentManager;
    }

    public String getCvTitle() {
        return cvTitle;
    }

    public void setCvTitle(String cvTitle) {
        this.cvTitle = cvTitle;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }

    public String getCandidacyComment() {
        return candidacyComment;
    }

    public void setCandidacyComment(String candidacyComment) {
        this.candidacyComment = candidacyComment;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getPersonalMobile() {
        return personalMobile;
    }

    public void setPersonalMobile(String personalMobile) {
        this.personalMobile = personalMobile;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DataLink getCountry() {
        return country;
    }

    public void setCountry(DataLink country) {
        this.country = country;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
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

    public DataLink getNationality() {
        return nationality;
    }

    public void setNationality(DataLink nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Candidate [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
