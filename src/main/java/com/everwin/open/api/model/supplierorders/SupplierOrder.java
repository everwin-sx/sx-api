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
package com.everwin.open.api.model.supplierorders;

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
 * Supplier order class
 * @author everwin-team
 */
@XmlRootElement(name = "supplierOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierOrder extends BasicObject {

	@XmlElement
	private String code;
	
	@XmlElement
	private DataLink supplier;
	
	@XmlElement
	private DataLink contact;

	@XmlElement
	private DataLink entity;
	
	@XmlElement
	private DataLink financialEntity;
	
	@XmlElement
	private DataLink issuer;
	
	@XmlElement
	private DataLink supplierAccount;

	@XmlElement
	private String validationStep;


	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date creationDate;
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date deliveryDate;
	
	@XmlElement
	private String supplierReference;
	
	@XmlElement
	private String estimateReference;
	
	@XmlElement
	private String currency;
	
	@XmlElement
	private Double totalWithoutVat;
	
	@XmlElement
	private String deliveryAddress;
	
	@XmlElement
	private String supplierDeliveries;
	
	@XmlElement
	private Short deliveryStatus;
	
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
	public SupplierOrder() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DataLink getSupplier() {
		return supplier;
	}

	public void setSupplier(DataLink supplier) {
		this.supplier = supplier;
	}

	public DataLink getContact() {
		return contact;
	}

	public void setContact(DataLink contact) {
		this.contact = contact;
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

	public DataLink getIssuer() {
		return issuer;
	}

	public void setIssuer(DataLink issuer) {
		this.issuer = issuer;
	}

	public DataLink getSupplierAccount() {
		return supplierAccount;
	}

	public void setSupplierAccount(DataLink supplierAccount) {
		this.supplierAccount = supplierAccount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getSupplierReference() {
		return supplierReference;
	}

	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}

	public String getEstimateReference() {
		return estimateReference;
	}

	public void setEstimateReference(String estimateReference) {
		this.estimateReference = estimateReference;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTotalWithoutVat() {
		return totalWithoutVat;
	}

	public void setTotalWithoutVat(Double totalWithoutVat) {
		this.totalWithoutVat = totalWithoutVat;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getSupplierDeliveries() {
		return supplierDeliveries;
	}

	public void setSupplierDeliveries(String supplierDeliveries) {
		this.supplierDeliveries = supplierDeliveries;
	}

	public Short getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Short deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
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
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getValidationStep() {
		return validationStep;
	}

	public void setValidationStep(String validationStep) {
		this.validationStep = validationStep;
	}

	@Override
	public String toString() {
		return "SupplierOrder [code=" + code + ", supplier=" + supplier + ", entity=" + entity + ", issuer=" + issuer + ", extraData=" + extraData + "]";
	}
	
	
	
}
