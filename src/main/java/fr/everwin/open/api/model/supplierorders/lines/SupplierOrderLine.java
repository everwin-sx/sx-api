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
package fr.everwin.open.api.model.supplierorders.lines;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.ExpenseMultiCurrencyValue;
import fr.everwin.open.api.model.core.MultiCurrencyValue;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.model.core.SpecificDateValue;
import fr.everwin.open.api.model.core.SpecificLinkValue;
import fr.everwin.open.api.model.core.SpecificMultiLinkValue;
import fr.everwin.open.api.model.core.SpecificNumberValue;
import fr.everwin.open.api.model.core.SpecificStringValue;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;

/**
 * Supplier order line class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "supplierOrderLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierOrderLine extends BasicObject {

	@XmlElement
	private DataLink supplierOrder;

	@XmlElement
	private String title;

	@XmlElement
	private String reference;

	@XmlElement
	private DataLink product;

	@XmlElement
	private Double quantity;

	@XmlElement
	private SupplierOrderLineMultiCurrencyValue amount;

	@XmlElement
	private SupplierOrderLineMultiCurrencyValue totalWithoutVat;

	@XmlElement
	private DataLink vat;

	@XmlElement
	private DataLink project;

	@XmlElement
	private DataLink projectLine;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date deliveryDate;

	@XmlElementWrapper(name = "extraData")
	@XmlElements({
			@XmlElement(name = "stringval", type = SpecificStringValue.class),
			@XmlElement(name = "dateval", type = SpecificDateValue.class),
			@XmlElement(name = "numberval", type = SpecificNumberValue.class),
			@XmlElement(name = "link", type = SpecificLinkValue.class),
			@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)
	})
	private List<SpecificData> extraData;

	public SupplierOrderLine() {
		amount = new SupplierOrderLineMultiCurrencyValue();
		totalWithoutVat = new SupplierOrderLineMultiCurrencyValue();
	}

	@Override
	public String toString() {
		return "SupplierOrderLine [supplierOrder=" + supplierOrder + ", quantity=" + quantity + ", amount=" + amount + ", totalWithoutVat=" + totalWithoutVat + ", project=" + project + ", projectLine=" + projectLine + "]";
	}

	public DataLink getSupplierOrder() {
		return supplierOrder;
	}

	public void setSupplierOrder(DataLink supplierOrder) {
		this.supplierOrder = supplierOrder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public DataLink getProduct() {
		return product;
	}

	public void setProduct(DataLink product) {
		this.product = product;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public SupplierOrderLineMultiCurrencyValue getAmount() {
		return amount;
	}

	public void setAmount(SupplierOrderLineMultiCurrencyValue amount) {
		this.amount = amount;
	}

	public SupplierOrderLineMultiCurrencyValue getTotalWithoutVat() {
		return totalWithoutVat;
	}

	public void setTotalWithoutVat(SupplierOrderLineMultiCurrencyValue totalWithoutVat) {
		this.totalWithoutVat = totalWithoutVat;
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

	public DataLink getProjectLine() {
		return projectLine;
	}

	public void setProjectLine(DataLink projectLine) {
		this.projectLine = projectLine;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<SpecificData> getExtraData() {
		return extraData;
	}

	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}
}
