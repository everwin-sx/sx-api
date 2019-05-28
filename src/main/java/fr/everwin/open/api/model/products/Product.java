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
package fr.everwin.open.api.model.products;

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
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Product class
 * @author everwin-team
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product extends BasicObject {

	@XmlElement(required = true, nillable = false)
	private String name;

	@XmlElement
	private String label;

	@XmlElementWrapper(name = "rowTypes")
	@XmlElements(@XmlElement(name = "rowtype", type = DataLink.class))
	private List<DataLink> rowTypes;

	@XmlElement
	private String customerRef;

	@XmlElement
	private DataLink supplier;

	@XmlElement
	private String supplierRef;

	@XmlElement
	private Double salePrice;

	@XmlElement
	private Double purchasePrice;

	@XmlElement
	private Double purchaseListPrice;

	@XmlElement
	private Double purchaseDiscountRate;

	@XmlElement
	private DataLink currency;

	@XmlElement
	private Short isArchived;

	@XmlElement
	private DataLink category;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date createdOnTime;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date updatedOnTime;

	/**
	 * 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<DataLink> getRowTypes() {
		return rowTypes;
	}

	public void setRowTypes(List<DataLink> rowTypes) {
		this.rowTypes = rowTypes;
	}

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public DataLink getSupplier() {
		return supplier;
	}

	public void setSupplier(DataLink supplier) {
		this.supplier = supplier;
	}

	public String getSupplierRef() {
		return supplierRef;
	}

	public void setSupplierRef(String supplierRef) {
		this.supplierRef = supplierRef;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getPurchaseListPrice() {
		return purchaseListPrice;
	}

	public void setPurchaseListPrice(Double purchaseListPrice) {
		this.purchaseListPrice = purchaseListPrice;
	}

	public Double getPurchaseDiscountRate() {
		return purchaseDiscountRate;
	}

	public void setPurchaseDiscountRate(Double purchaseDiscountRate) {
		this.purchaseDiscountRate = purchaseDiscountRate;
	}

	public DataLink getCurrency() {
		return currency;
	}

	public void setCurrency(DataLink currency) {
		this.currency = currency;
	}

	public Short getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Short isArchived) {
		this.isArchived = isArchived;
	}

	public Date getCreatedOnTime() {
		return createdOnTime;
	}

	public void setCreatedOnTime(Date createdOnTime) {
		this.createdOnTime = createdOnTime;
	}

	public Date getUpdatedOnTime() {
		return updatedOnTime;
	}

	public void setUpdatedOnTime(Date updatedOnTime) {
		this.updatedOnTime = updatedOnTime;
	}

	public DataLink getCategory() {
		return category;
	}

	public void setCategory(DataLink category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", label=" + label + "]";
	}

}
