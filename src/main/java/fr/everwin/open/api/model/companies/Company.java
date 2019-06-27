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

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.model.core.SpecificDateValue;
import fr.everwin.open.api.model.core.SpecificLinkValue;
import fr.everwin.open.api.model.core.SpecificMultiLinkValue;
import fr.everwin.open.api.model.core.SpecificNumberValue;
import fr.everwin.open.api.model.core.SpecificStringValue;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Company class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company extends BasicObject {

    @XmlElement
    private String code;

    private String name;

    @XmlElement
    private DataLink group;

    @XmlElement
    private DataLink providedby;

    @XmlElement
    private DataLink entity;

    @XmlElement
    private DataLink accountManager;

    @XmlElement
    private DataLink status;

    @XmlElement
    private DataLink legalStatus;

    @XmlElement
    private Short isActive;

    @XmlElement
    private String identifierNumber;

    @XmlElement
    private String phone;

    @XmlElement
    private String fax;

    @XmlElement
    private String address;

    @XmlElement
    private String address2;

    @XmlElement
    private String address3;

    @XmlElement
    private String postalCode;

    @XmlElement
    private String city;

    @XmlElement
    private DataLink region;

    @XmlElement
    private DataLink country;

    @XmlElement
    private String email;

    @XmlElement
    private String website;

    @XmlElement
    private DataLink defaultAccount;

    @XmlElement
    private DataLink ape;

    @XmlElement
    private DataLink category;

    @XmlElement
    private DataLink segment;

    @XmlElement
    private String openSegment;

    @XmlElement
    private DataLink turnoverSize;

    @XmlElement
    private Double turnover;

    @XmlElement
    private DataLink numberOfEmployeesSize;

    @XmlElement
    private Long numberOfEmployees;

    @XmlElement
    private Integer numberOfSites;

    @XmlElement
    private String comment;

    @XmlElement
    private Short isProvider;

    @XmlElement
    private DataLink spanco;

    @XmlElement
    private String logo;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;

    private String updatedBy;

    @XmlElement
    private List<DataLink> offers;

    @XmlElement
    private Short acceptEmailing;

    @XmlElement
    private String companyRegistrationNumber;

    @XmlElementWrapper(name = "extraData")
    @XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
            @XmlElement(name = "dateval", type = SpecificDateValue.class),
            @XmlElement(name = "numberval", type = SpecificNumberValue.class),
            @XmlElement(name = "link", type = SpecificLinkValue.class),
            @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
    private List<SpecificData> extraData;

    public Company() {
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

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
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

    @Override
    public String toString() {
        return "Company [id=" + id + ", code=" + code + ", name=" + name + "]";
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

    /**
     * Logo file in base 64
     * @return The base 64 logo file
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Set the logo file
     * @param logo file in base 64
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }
}

