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

package fr.everwin.open.api.model.supplierinvoices;

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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Represents a supplier invoice
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "supplierInvoice")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierInvoice extends BasicObject {

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
	private DataLink lastValidator;
	
	@XmlElement
	private DataLink paymentTerms;
	
	@XmlElement
	private DataLink supplierAccount;

	@XmlElement
	private String validationStep;
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date date;	
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date dueDate;
	
	@XmlElement
	private String reference;

	@XmlElement
	private Short settlementStatus;
	
	@XmlElement
	private String settlementComents;
	
	@XmlElement
	private DataLink fiscalPosition;
	
	@XmlElement
	private String currency;
	
	@XmlElement
	private Double totalWithoutVat;

	@XmlElement
	private Double totalIncludingVat;
	
	@XmlElement
	private Double totalVat;

	@XmlElement
	private Double totalToBeCharged;
	
	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
		@XmlElement(name = "dateval", type = SpecificDateValue.class),
		@XmlElement(name = "numberval", type = SpecificNumberValue.class),
		@XmlElement(name = "link", type = SpecificLinkValue.class),
		@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;
	
	
	public SupplierInvoice() {
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


	public DataLink getLastValidator() {
		return lastValidator;
	}


	public void setLastValidator(DataLink lastValidator) {
		this.lastValidator = lastValidator;
	}


	public DataLink getPaymentTerms() {
		return paymentTerms;
	}


	public void setPaymentTerms(DataLink paymentTerms) {
		this.paymentTerms = paymentTerms;
	}


	public DataLink getSupplierAccount() {
		return supplierAccount;
	}


	public void setSupplierAccount(DataLink supplierAccount) {
		this.supplierAccount = supplierAccount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}

	public Short getSettlementStatus() {
		return settlementStatus;
	}


	public void setSettlementStatus(Short settlementStatus) {
		this.settlementStatus = settlementStatus;
	}


	public String getSettlementComents() {
		return settlementComents;
	}


	public void setSettlementComents(String settlementComents) {
		this.settlementComents = settlementComents;
	}


	public DataLink getFiscalPosition() {
		return fiscalPosition;
	}


	public void setFiscalPosition(DataLink fiscalPosition) {
		this.fiscalPosition = fiscalPosition;
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


	public Double getTotalIncludingVat() {
		return totalIncludingVat;
	}


	public void setTotalIncludingVat(Double totalIncludingVat) {
		this.totalIncludingVat = totalIncludingVat;
	}

	public Double getTotalVat() {
		return totalVat;
	}

	public void setTotalVat(Double totalVat) {
		this.totalVat = totalVat;
	}


	public Double getTotalToBeCharged() {
		return totalToBeCharged;
	}


	public void setTotalToBeCharged(Double totalToBeCharged) {
		this.totalToBeCharged = totalToBeCharged;
	}


	public List<SpecificData> getExtraData() {
		return extraData;
	}


	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}

	public String getValidationStep() {
		return validationStep;
	}

	public void setValidationStep(String validationStep) {
		this.validationStep = validationStep;
	}

	@Override
	public String toString() {
		return "Supplier invoice [code=" + code + "]";
	}
}