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


package com.everwin.open.api.model.candidates;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.everwin.open.api.model.core.BasicObject;
import com.everwin.open.api.model.core.DataLink;
import com.everwin.open.api.model.core.SpecificData;
import com.everwin.open.api.model.core.SpecificDateValue;
import com.everwin.open.api.model.core.SpecificLinkValue;
import com.everwin.open.api.model.core.SpecificMultiLinkValue;
import com.everwin.open.api.model.core.SpecificNumberValue;
import com.everwin.open.api.model.core.SpecificStringValue;
import com.everwin.open.api.util.JsonDateDeserializer;
import com.everwin.open.api.util.XMLDateAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Candidate class
 * @author everwin-team
 */
@XmlRootElement(name = "candidate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidate extends BasicObject {

	@XmlElement
	private String code;

	@XmlElement
	private String firstName;
	
	@XmlElement
	private String lastName;

	@XmlElement
	private Short title;

	@XmlElement
	private String familySituation;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date birthDate;

	@XmlElement
	private DataLink nationality;

	@XmlElement
	private DataLink status;

	@XmlElement
	private DataLink connectionType;

	@XmlElementWrapper(name = "profiles")
	@XmlElements(@XmlElement(name = "profile", type = DataLink.class))
	private List<DataLink> activityCategories;
	
	@XmlElementWrapper(name = "profiles")
	@XmlElements(@XmlElement(name = "profile", type = DataLink.class))
	private List<DataLink> businesses;

	@XmlElement
	private DataLink candidacyOrigin;

	@XmlElement
	private DataLink experienceDuration;
	
	@XmlElement
	private DataLink availability;

	@XmlElement
	private DataLink degreeLevel;

	@XmlElement
	private DataLink manager;

	@XmlElement
	private DataLink recruitmentManager;
	
	@XmlElement
	private String cvTitle;

	@XmlElement
	private Short isArchived;

	@XmlElement
	private String candidacyComment;
	
	@XmlElement
	private String personalPhone;

	@XmlElement
	private String personalMobile;
	
	@XmlElement
	private String personalEmail;
	
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
	private String updatedBy;
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedOnTime;

	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date createdOnTime;
		
	
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
	public Candidate() {}
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
