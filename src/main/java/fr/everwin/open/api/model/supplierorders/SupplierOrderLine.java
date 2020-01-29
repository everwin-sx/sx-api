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
package fr.everwin.open.api.model.supplierorders;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.ExpenseMultiCurrencyValue;
import fr.everwin.open.api.model.core.MultiCurrencyValue;

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
	private ExpenseMultiCurrencyValue amount;
	
	@XmlElement
	private ExpenseMultiCurrencyValue totalWithoutVat;
	
	@XmlElement
	private DataLink vat;
	
	@XmlElement
	private DataLink project;
	
	@XmlElement
	private DataLink projectLine;
	/**
	 * 
	 */
	public SupplierOrderLine() {
		amount = new ExpenseMultiCurrencyValue();
		totalWithoutVat = new ExpenseMultiCurrencyValue();
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
	public MultiCurrencyValue getAmount() {
		return amount;
	}
	public void setAmount(ExpenseMultiCurrencyValue amount) {
		this.amount = amount;
	}
	public ExpenseMultiCurrencyValue getTotalWithoutVat() {
		return totalWithoutVat;
	}
	public void setTotalWithoutVat(ExpenseMultiCurrencyValue totalWithoutVat) {
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
	@Override
	public String toString() {
		return "SupplierOrderLine [supplierOrder=" + supplierOrder + ", quantity=" + quantity + ", amount=" + amount + ", totalWithoutVat=" + totalWithoutVat + ", project=" + project + ", projectLine=" + projectLine + "]";
	}
	
	
}
