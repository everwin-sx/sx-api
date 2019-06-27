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
package fr.everwin.open.api.model.products;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * CustomerAsset class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "customer-asset")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerAsset extends BasicObject {

	@XmlElement(required = true, nillable = false)
	private DataLink company;

	@XmlElement
	private DataLink product;

	@XmlElement
	private String comment;

	@XmlElement
	private DataLink project;

	@XmlElement
	private DataLink projectRow;

	@XmlElement
	private Double quantity;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date validationDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date orderDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date deliveryDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date installationDate;

	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date maintenanceDate;

	@XmlElement
	private Short isActive;

	public CustomerAsset() {

	}

	/**
	 * @return the company
	 */
	public DataLink getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(DataLink company) {
		this.company = company;
	}

	/**
	 * @return the product
	 */
	public DataLink getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(DataLink product) {
		this.product = product;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the project
	 */
	public DataLink getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(DataLink project) {
		this.project = project;
	}

	/**
	 * @return the projectRow
	 */
	public DataLink getProjectRow() {
		return projectRow;
	}

	/**
	 * @param projectRow the projectRow to set
	 */
	public void setProjectRow(DataLink projectRow) {
		this.projectRow = projectRow;
	}

	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the validationDate
	 */
	public Date getValidationDate() {
		return validationDate;
	}

	/**
	 * @param validationDate the validationDate to set
	 */
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the installationDate
	 */
	public Date getInstallationDate() {
		return installationDate;
	}

	/**
	 * @param installationDate the installationDate to set
	 */
	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	/**
	 * @return the maintenanceDate
	 */
	public Date getMaintenanceDate() {
		return maintenanceDate;
	}

	/**
	 * @param maintenanceDate the maintenanceDate to set
	 */
	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	/**
	 * @return the isActive
	 */
	public Short getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer asset [id=" + id + ", comment=" + comment + ", quantity=" + quantity + "]";
	}
}
