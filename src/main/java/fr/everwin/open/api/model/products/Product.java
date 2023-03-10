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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;

import java.util.Date;
import java.util.List;


/**
 * Product class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BasicObject {

    private String name;
    private String label;
    private List<DataLink> rowTypes;
    private String customerRef;
    private DataLink supplier;
    private String supplierRef;
    private Double salePrice;
    private Double purchasePrice;
    private Double purchaseListPrice;
    private Double purchaseDiscountRate;
    private DataLink currency;
    private Short isArchived;
    private DataLink category;
    private Short customerAssetsGeneration;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    private String updatedBy;
    private List<SpecificData> extraData;

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

    public Short getCustomerAssetsGeneration() {
        return customerAssetsGeneration;
    }

    public void setCustomerAssetsGeneration(Short customerAssetsGeneration) {
        this.customerAssetsGeneration = customerAssetsGeneration;
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
        return "Product [name=" + name + ", label=" + label + "]";
    }
}
