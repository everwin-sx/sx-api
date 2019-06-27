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

package fr.everwin.open.api.model.contacts;

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
 * Contact responsibility class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "contactresponsibility")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactResponsibility extends BasicObject {

	@XmlElement
	private DataLink company;

	@XmlElement
	private DataLink person;

	@XmlElement
	private Short civility;

	@XmlElement
	private String firstName;

	@XmlElement
	private String lastName;

	@XmlElement
	private String function;

	@XmlElement
	private DataLink functionType;

	@XmlElement
	private DataLink assignedTo;

	@XmlElement
	private String phone;

	@XmlElement
	private String mobile;

	@XmlElement
	private String fax;

	@XmlElement
	private String email;

	@XmlElement
	private Short acceptsEmail;

	@XmlElement
	private Short leftCompany;

	@XmlElement
	private String service;

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
	private String comment;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedOnTime;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date createdOnTime;

	private String updatedBy;

	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class), @XmlElement(name = "dateval", type = SpecificDateValue.class), @XmlElement(name = "numberval", type = SpecificNumberValue.class), @XmlElement(name = "link",
			type = SpecificLinkValue.class), @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;

	public ContactResponsibility() {}

	public DataLink getCompany() {
		return company;
	}

	public void setCompany(DataLink company) {
		this.company = company;
	}

	public DataLink getPerson() {
		return person;
	}

	public void setPerson(DataLink person) {
		this.person = person;
	}

	public Short getCivility() {
		return civility;
	}

	public void setCivility(Short civility) {
		this.civility = civility;
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

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public DataLink getFunctionType() {
		return functionType;
	}

	public void setFunctionType(DataLink functionType) {
		this.functionType = functionType;
	}

	public DataLink getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(DataLink assignedTo) {
		this.assignedTo = assignedTo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getAcceptsEmail() {
		return acceptsEmail;
	}

	public void setAcceptsEmail(Short acceptsEmail) {
		this.acceptsEmail = acceptsEmail;
	}

	public Short getLeftCompany() {
		return leftCompany;
	}

	public void setLeftCompany(Short leftCompany) {
		this.leftCompany = leftCompany;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public List<SpecificData> getExtraData() {
		return extraData;
	}

	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}

	@Override
	public String toString() {
		return "Contact responsibility [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + "]";
	}

}
