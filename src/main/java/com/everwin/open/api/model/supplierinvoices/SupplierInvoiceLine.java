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

package com.everwin.open.api.model.supplierinvoices;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.everwin.open.api.model.core.BasicObject;
import com.everwin.open.api.model.core.DataLink;
import com.everwin.open.api.model.core.MultiCurrencyValue;
import com.everwin.open.api.model.core.SpecificData;
import com.everwin.open.api.model.core.SpecificDateValue;
import com.everwin.open.api.model.core.SpecificLinkValue;
import com.everwin.open.api.model.core.SpecificMultiLinkValue;
import com.everwin.open.api.model.core.SpecificNumberValue;
import com.everwin.open.api.model.core.SpecificStringValue;

/**
 * Represents a supplier invoice line
 * @author everwin-team
 */
@XmlRootElement(name = "supplierinvoiceline")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierInvoiceLine extends BasicObject {

	@XmlElement
	private DataLink supplierInvoice;

	@XmlElement
	private String title;

	@XmlElement
	private Double quantity;

	@XmlElement
	private MultiCurrencyValue amount;

	@XmlElement
	private MultiCurrencyValue totalWithoutVat;

	@XmlElement
	private DataLink vat;

	@XmlElement
	private MultiCurrencyValue totalIncludingVat;

	@XmlElement
	private MultiCurrencyValue totalToBeCharged;

	@XmlElement
	private DataLink project;

	@XmlElement
	private DataLink type;

	@XmlElement
	private DataLink projectLine;

	@XmlElement
	private DataLink account;

	@XmlElement
	private DataLink supplierOrderLine;

	@XmlElement
	private DataLink supplierDeliveryLine;

	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
			@XmlElement(name = "dateval", type = SpecificDateValue.class),
			@XmlElement(name = "numberval", type = SpecificNumberValue.class),
			@XmlElement(name = "link", type = SpecificLinkValue.class),
			@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;

	public SupplierInvoiceLine() {
		amount = new MultiCurrencyValue();
		totalWithoutVat = new MultiCurrencyValue();
		totalIncludingVat = new MultiCurrencyValue();
		totalToBeCharged = new MultiCurrencyValue();
	}


	public DataLink getSupplierInvoice() {
		return supplierInvoice;
	}

	public void setSupplierInvoice(DataLink supplierInvoice) {
		this.supplierInvoice = supplierInvoice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public MultiCurrencyValue getAmount() {
		return amount;
	}


	public void setAmount(MultiCurrencyValue amount) {
		this.amount = amount;
	}


	public MultiCurrencyValue getTotalWithoutVat() {
		return totalWithoutVat;
	}


	public void setTotalWithoutVat(MultiCurrencyValue totalWithoutVat) {
		this.totalWithoutVat = totalWithoutVat;
	}


	public MultiCurrencyValue getTotalIncludingVat() {
		return totalIncludingVat;
	}


	public void setTotalIncludingVat(MultiCurrencyValue totalIncludingVat) {
		this.totalIncludingVat = totalIncludingVat;
	}


	public MultiCurrencyValue getTotalToBeCharged() {
		return totalToBeCharged;
	}


	public void setTotalToBeCharged(MultiCurrencyValue totalToBeCharged) {
		this.totalToBeCharged = totalToBeCharged;
	}


	public DataLink getVat() {
		return vat;
	}

	public void setVat(DataLink vat) {
		this.vat = vat;
	}
	

	public DataLink getProject() {
		return project;
	}

	public void setProject(DataLink project) {
		this.project = project;
	}

	public DataLink getType() {
		return type;
	}

	public void setType(DataLink type) {
		this.type = type;
	}

	public DataLink getProjectLine() {
		return projectLine;
	}

	public void setProjectLine(DataLink projectLine) {
		this.projectLine = projectLine;
	}

	public DataLink getAccount() {
		return account;
	}

	public void setAccount(DataLink account) {
		this.account = account;
	}

	public DataLink getSupplierOrderLine() {
		return supplierOrderLine;
	}

	public void setSupplierOrderLine(DataLink supplierOrderLine) {
		this.supplierOrderLine = supplierOrderLine;
	}

	public DataLink getSupplierDeliveryLine() {
		return supplierDeliveryLine;
	}

	public void setSupplierDeliveryLine(DataLink supplierDeliveryLine) {
		this.supplierDeliveryLine = supplierDeliveryLine;
	}

	public List<SpecificData> getExtraData() {
		return extraData;
	}

	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}
	
	@Override
	public String toString() {
		return "Supplier invoice line [supplierInvoice=" + (supplierInvoice!=null ? supplierInvoice.getId() : null) + ", Title=" + title + "]";
	}
}
