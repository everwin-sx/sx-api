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
package fr.everwin.open.api.model.employees;

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
 * Represents an employee
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee extends BasicObject {

    private String code;
    private String firstName;
    private String lastName;
    private Short title;
    private Short type;
    private DataLink entity;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "secondEntity")
    private List<DataLink> secondEntities;
    private DataLink financialEntity;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "secondFinancialEntity")
    private List<DataLink> secondFinancialEntities;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date arrivalDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date leavingDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date birthDate;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "profile")
    private List<DataLink> profiles;
    private DataLink mainProfile;
    private DataLink manager;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "supportedCommercial")
    private List<DataLink> supportedCommercials;
    private DataLink workMode;
    private DataLink contractType;
    private DataLink hierarchicalLevel;
    private Double annualSalary;
    private Double salePrice;
    private Double fullCostPrice;
    private Double directCostPrice;
    private DataLink distanceScale;
    private Short isArchived;
    private String login;
    private String password;
    private String userRole;
    private DataLink userLanguage;
    private String function;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "profile")
    private List<DataLink> languages;
    private DataLink nationality;
    private String phone;
    private String personalPhone;
    private String mobile;
    private String fax;
    private String address;
    private String address2;
    private String address3;
    private String postalCode;
    private String city;
    private DataLink country;
    private String email;
    private String payrollId;
    private String account;
    private String secondaryAccount;
    private DataLink fiscalPosition;
    private String comment;
    private String updatedBy;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date createdOnTime;
    private Short isLdapOut;
    private String ldapDomain;
    private String iban;
    private String bic;
    private String picture;
    private String loginMode;
    private List<SpecificData> extraData;

    /**
     *
     */
    public Employee() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<DataLink> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<DataLink> profiles) {
        this.profiles = profiles;
    }

    public DataLink getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(DataLink mainProfile) {
        this.mainProfile = mainProfile;
    }

    public DataLink getManager() {
        return manager;
    }

    public void setManager(DataLink manager) {
        this.manager = manager;
    }

    public List<DataLink> getSupportedCommercials() {
        return supportedCommercials;
    }

    public void setSupportedCommercials(List<DataLink> supportedCommercials) {
        this.supportedCommercials = supportedCommercials;
    }

    public DataLink getWorkMode() {
        return workMode;
    }

    public void setWorkMode(DataLink workMode) {
        this.workMode = workMode;
    }

    public DataLink getContractType() {
        return contractType;
    }

    public void setContractType(DataLink contractType) {
        this.contractType = contractType;
    }

    public DataLink getHierarchicalLevel() {
        return hierarchicalLevel;
    }

    public void setHierarchicalLevel(DataLink hierarchicalLevel) {
        this.hierarchicalLevel = hierarchicalLevel;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
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

    public DataLink getDistanceScale() {
        return distanceScale;
    }

    public void setDistanceScale(DataLink distanceScale) {
        this.distanceScale = distanceScale;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public DataLink getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(DataLink userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<DataLink> getLanguages() {
        return languages;
    }

    public void setLanguages(List<DataLink> languages) {
        this.languages = languages;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSecondaryAccount() {
        return secondaryAccount;
    }

    public void setSecondaryAccount(String secondaryAccount) {
        this.secondaryAccount = secondaryAccount;
    }

    public DataLink getFiscalPosition() {
        return fiscalPosition;
    }

    public void setFiscalPosition(DataLink fiscalPosition) {
        this.fiscalPosition = fiscalPosition;
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

    public DataLink getNationality() {
        return nationality;
    }

    public void setNationality(DataLink nationality) {
        this.nationality = nationality;
    }

    public List<DataLink> getSecondEntities() {
        return secondEntities;
    }

    public void setSecondEntities(List<DataLink> secondEntities) {
        this.secondEntities = secondEntities;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public Short getIsLdapOut() {
        return isLdapOut;
    }

    public void setIsLdapOut(Short isLdapOut) {
        this.isLdapOut = isLdapOut;
    }

    public String getLdapDomain() {
        return ldapDomain;
    }

    public void setLdapDomain(String ldapDomain) {
        this.ldapDomain = ldapDomain;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "Employee [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + ", entity=" + entity + ", workMode=" + workMode + "]";
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(String loginMode) {
        this.loginMode = loginMode;
    }
}
