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
package fr.everwin.open.api.model.companies.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDate;

import java.util.Date;
import java.util.List;


/**
 * Company accounts represents a company managed by business management module. <br>
 * Customer accounts keep administrative information about customers and suppliers safe from any CRM module changes.
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyAccount extends BasicObject {

    private String code;
    private DataLink company;
    private List<DataLink> entities;
    private String identifierNumber;
    private String vatNumber;
    private String billingName;
    private short isActive;
    private String billingRecipient;
    private String billingAddress;
    private String billingAddress2;
    private String billingAddress3;
    private String billingPostalCode;
    private String billingCity;
    private DataLink billingCountry;
    private String billingPhone;
    private String billingFax;
    private String shippingName;
    private String shippingRecipient;
    private String shippingAddress;
    private String shippingAddress2;
    private String shippingAddress3;
    private String shippingPostalCode;
    private String shippingCity;
    private String headquartersName;
    private String headquartersRecipient;
    private String headquartersAddress;
    private String headquartersAddress2;
    private String headquartersAddress3;
    private String headquartersPostalCode;
    private String headquartersCity;
    private DataLink headquartersCountry;
    private DataLink shippingCountry;
    private String shippingPhone;
    private String shippingFax;
    private DataLink paymentTerms;
    private Short vatSystem;
    private DataLink defaultVat;
    private DataLink defaultBank;
    private DataLink fiscalPosition;
    private Short visibility;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date visibilityDate;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDate.Deserializer.class)
    @JsonSerialize(using = JsonDate.Serializer.class)
    private Date createdOnTime;
    private String updatedBy;
    private DataLink factor;
    private List<SpecificData> extraData;

    public CompanyAccount() {
        // Constructor empty
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataLink getCompany() {
        return company;
    }

    public void setCompany(DataLink company) {
        this.company = company;
    }

    public List<DataLink> getEntities() {
        return entities;
    }

    public void setEntities(List<DataLink> entities) {
        this.entities = entities;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getBillingRecipient() {
        return billingRecipient;
    }

    public void setBillingRecipient(String billingRecipient) {
        this.billingRecipient = billingRecipient;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingAddress3() {
        return billingAddress3;
    }

    public void setBillingAddress3(String billingAddress3) {
        this.billingAddress3 = billingAddress3;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public DataLink getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(DataLink billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingFax() {
        return billingFax;
    }

    public void setBillingFax(String billingFax) {
        this.billingFax = billingFax;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingRecipient() {
        return shippingRecipient;
    }

    public void setShippingRecipient(String shippingRecipient) {
        this.shippingRecipient = shippingRecipient;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingAddress3() {
        return shippingAddress3;
    }

    public void setShippingAddress3(String shippingAddress3) {
        this.shippingAddress3 = shippingAddress3;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public DataLink getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(DataLink shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingFax() {
        return shippingFax;
    }

    public void setShippingFax(String shippingFax) {
        this.shippingFax = shippingFax;
    }

    public DataLink getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(DataLink paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Short getVatSystem() {
        return vatSystem;
    }

    public void setVatSystem(Short vatSystem) {
        this.vatSystem = vatSystem;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public DataLink getDefaultVat() {
        return defaultVat;
    }

    public void setDefaultVat(DataLink defaultVat) {
        this.defaultVat = defaultVat;
    }

    public DataLink getDefaultBank() {
        return defaultBank;
    }

    public void setDefaultBank(DataLink defaultBank) {
        this.defaultBank = defaultBank;
    }

    public DataLink getFiscalPosition() {
        return fiscalPosition;
    }

    public void setFiscalPosition(DataLink fiscalPosition) {
        this.fiscalPosition = fiscalPosition;
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

    public DataLink getFactor() {
        return factor;
    }

    public void setFactor(DataLink factor) {
        this.factor = factor;
    }

    public String getHeadquartersName() {
        return headquartersName;
    }

    public void setHeadquartersName(String headquartersName) {
        this.headquartersName = headquartersName;
    }

    public String getHeadquartersRecipient() {
        return headquartersRecipient;
    }

    public void setHeadquartersRecipient(String headquartersRecipient) {
        this.headquartersRecipient = headquartersRecipient;
    }

    public String getHeadquartersAddress() {
        return headquartersAddress;
    }

    public void setHeadquartersAddress(String headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    public String getHeadquartersAddress2() {
        return headquartersAddress2;
    }

    public void setHeadquartersAddress2(String headquartersAddress2) {
        this.headquartersAddress2 = headquartersAddress2;
    }

    public String getHeadquartersAddress3() {
        return headquartersAddress3;
    }

    public void setHeadquartersAddress3(String headquartersAddress3) {
        this.headquartersAddress3 = headquartersAddress3;
    }

    public String getHeadquartersPostalCode() {
        return headquartersPostalCode;
    }

    public void setHeadquartersPostalCode(String headquartersPostalCode) {
        this.headquartersPostalCode = headquartersPostalCode;
    }

    public String getHeadquartersCity() {
        return headquartersCity;
    }

    public void setHeadquartersCity(String headquartersCity) {
        this.headquartersCity = headquartersCity;
    }

    public DataLink getHeadquartersCountry() {
        return headquartersCountry;
    }

    public void setHeadquartersCountry(DataLink headquartersCountry) {
        this.headquartersCountry = headquartersCountry;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
        this.visibility = visibility;
    }

    public Date getVisibilityDate() {
        return visibilityDate;
    }

    public void setVisibilityDate(Date visibilityDate) {
        this.visibilityDate = visibilityDate;
    }
}
