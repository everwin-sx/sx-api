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

package fr.everwin.open.api.model.companies;

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
 * Company class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class Company extends BasicObject {


    private String code;

    private String name;


    private DataLink group;


    private DataLink providedby;


    private DataLink entity;


    private DataLink accountManager;


    private DataLink status;


    private DataLink legalStatus;


    private Short visibility;

    @JsonDeserialize(using = JsonDateDeserializer.class)

    private Date visibilityDate;


    private String identifierNumber;


    private String phone;


    private String fax;


    private String address;


    private String address2;


    private String address3;


    private String postalCode;


    private String city;


    private DataLink region;


    private DataLink country;


    private String email;


    private String website;


    private DataLink defaultAccount;


    private DataLink ape;


    private DataLink category;


    private DataLink segment;


    private String openSegment;


    private DataLink turnoverSize;


    private Double turnover;


    private DataLink numberOfEmployeesSize;


    private Long numberOfEmployees;


    private Integer numberOfSites;


    private String comment;


    private Short isProvider;


    private DataLink spanco;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;

    private String updatedBy;


    private List<DataLink> offers;


    private Short acceptEmailing;


    private String companyRegistrationNumber;


    private String logo;

    private List<SpecificData> extraData;

    /**
     *
     */
    public Company() {
        // TODO Auto-generated constructor stub
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenSegment() {
        return openSegment;
    }

    public void setOpenSegment(String openSegment) {
        this.openSegment = openSegment;
    }

    public Integer getNumberOfSites() {
        return numberOfSites;
    }

    public void setNumberOfSites(Integer numberOfSites) {
        this.numberOfSites = numberOfSites;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataLink getStatus() {
        return status;
    }

    public void setStatus(DataLink status) {
        this.status = status;
    }

    public DataLink getGroup() {
        return group;
    }

    public void setGroup(DataLink group) {
        this.group = group;
    }

    public DataLink getProvidedby() {
        return providedby;
    }

    public void setProvidedby(DataLink providedby) {
        this.providedby = providedby;
    }

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public DataLink getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(DataLink accountManager) {
        this.accountManager = accountManager;
    }

    public DataLink getRegion() {
        return region;
    }

    public void setRegion(DataLink region) {
        this.region = region;
    }

    public DataLink getCountry() {
        return country;
    }

    public void setCountry(DataLink country) {
        this.country = country;
    }

    public DataLink getCategory() {
        return category;
    }

    public void setCategory(DataLink category) {
        this.category = category;
    }

    public DataLink getSegment() {
        return segment;
    }

    public void setSegment(DataLink segment) {
        this.segment = segment;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> specificDataSet) {
        this.extraData = specificDataSet;
    }

    public DataLink getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(DataLink legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public DataLink getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(DataLink defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public DataLink getApe() {
        return ape;
    }

    public void setApe(DataLink ape) {
        this.ape = ape;
    }

    public DataLink getTurnoverSize() {
        return turnoverSize;
    }

    public void setTurnoverSize(DataLink turnoverSize) {
        this.turnoverSize = turnoverSize;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public DataLink getNumberOfEmployeesSize() {
        return numberOfEmployeesSize;
    }

    public void setNumberOfEmployeesSize(DataLink numberOfEmployeesSize) {
        this.numberOfEmployeesSize = numberOfEmployeesSize;
    }

    public Long getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Long numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Short getIsProvider() {
        return isProvider;
    }

    public void setIsProvider(Short isProvider) {
        this.isProvider = isProvider;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public DataLink getSpanco() {
        return spanco;
    }

    public void setSpanco(DataLink spanco) {
        this.spanco = spanco;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
        this.visibility = visibility;
    }

    public Date getVisibilityDate() {
        return visibilityDate;
    }

    public void setVisibilityDate(Date visibilityDate) {
        this.visibilityDate = visibilityDate;
    }

    @Override
    public String toString() {
        return "Company [id=" + id
                + ", code="
                + code
                + ", name="
                + name
                + "]";
    }

    public List<DataLink> getOffers() {
        return offers;
    }

    public void setOffers(List<DataLink> offers) {
        this.offers = offers;
    }

    public Short getAcceptEmailing() {
        return acceptEmailing;
    }

    public void setAcceptEmailing(Short acceptEmailing) {
        this.acceptEmailing = acceptEmailing;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

