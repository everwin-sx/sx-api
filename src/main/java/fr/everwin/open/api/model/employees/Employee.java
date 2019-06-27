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
 * Represents an employee
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends BasicObject {

	@XmlElement
	private String code;
	
	@XmlElement
	private String firstName;
	
	@XmlElement
	private String lastName;
	
	@XmlElement
	private Short title;
	
	@XmlElement
	private Short type;
	
	@XmlElement
	private DataLink entity;
	
	@XmlElementWrapper(name = "secondEntities")
	@XmlElements(@XmlElement(name = "secondEntity", type = DataLink.class))
	private List<DataLink> secondEntities;
	
	@XmlElement
	private DataLink financialEntity;
	
	@XmlElementWrapper(name = "secondFinancialEntities")
	@XmlElements(@XmlElement(name = "secondFinancialEntity", type = DataLink.class))
	private List<DataLink> secondFinancialEntities;
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date arrivalDate;
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date leavingDate;
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date birthDate;
	@XmlElementWrapper(name = "profiles")
	@XmlElements(@XmlElement(name = "profile", type = DataLink.class))
	private List<DataLink> profiles;
	@XmlElement
	private DataLink mainProfile;
	@XmlElement
	private DataLink manager;
	@XmlElementWrapper(name = "supportedCommercials")
	@XmlElements(@XmlElement(name = "supportedCommercial", type = DataLink.class))
	private List<DataLink> supportedCommercials;
	@XmlElement
	private DataLink workMode;
	@XmlElement
	private DataLink contractType;
	@XmlElement
	private DataLink hierarchicalLevel;
	@XmlElement
	private Double annualSalary;
	@XmlElement
	private Double salePrice;
	
	@XmlElement
	private Double fullCostPrice;
	@XmlElement
	private Double directCostPrice;
	@XmlElement
	private DataLink distanceScale;
	@XmlElement
	private Short isArchived;
	@XmlElement
	private String login;
	@XmlElement
	private String password;
	@XmlElement
	private String userRole;
	@XmlElement
	private DataLink userLanguage;
	@XmlElement
	private String function;
	@XmlElementWrapper(name = "profiles")
	@XmlElements(@XmlElement(name = "profile", type = DataLink.class))
	private List<DataLink> languages;
	
	@XmlElement
	private DataLink nationality;
	@XmlElement
	private String phone;
	@XmlElement
	private String personalPhone;
	@XmlElement
	private String mobile;
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
	private DataLink country;
	@XmlElement
	private String email;
	@XmlElement
	private String payrollId;
	@XmlElement
	private String account;
	@XmlElement
	private String secondaryAccount;
	@XmlElement
	private DataLink fiscalPosition;
	@XmlElement
	private String comment;
	@XmlElement
	private String updatedBy;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedOnTime;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date createdOnTime;
	
	@XmlElement
	private Short isLdapOut;
	
	@XmlElement
	private String ldapDomain;
	
	@XmlElement
	private String iban;
	
	@XmlElement
	private String bic;
	
	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
	@XmlElement(name = "dateval", type = SpecificDateValue.class),
	@XmlElement(name = "numberval", type = SpecificNumberValue.class),
	@XmlElement(name = "link", type = SpecificLinkValue.class),
	@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;
	/**
	 * 
	 */
	public Employee() {}

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

	public List<DataLink> getSecondFinancialEntities() {
	return secondFinancialEntities;
	}

	public void setSecondFinancialEntities(List<DataLink> secondFinancialEntities) {
	this.secondFinancialEntities = secondFinancialEntities;
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

}
