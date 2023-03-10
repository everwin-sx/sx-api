package fr.everwin.open.api.model.quotes;


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
 * Quote class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quote extends BasicObject {

    private String code;
    private Long number;
    private DataLink createdBy;
    private DataLink customer;
    private DataLink mainContact;
    private List<DataLink> secondaryContacts;
    private String printHeader;
    private String notes;
    private String paymentConditions;
    private String delay;
    private DataLink entity;
    private DataLink financialEntity;
    private Short status;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date sendingDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date signatureDate;
    private String refusalReason;
    private String printCurrency;
    private Double conversionRate;
    private Short type;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;
    private String updatedBy;
    private List<SpecificData> extraData;
    private String validationStep;

    public String getValidationStep() {
        return validationStep;
    }

    public void setValidationStep(String validationStep) {
        this.validationStep = validationStep;
    }

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "code='" + code + '\'' +
                '}';
    }

    public DataLink getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(DataLink createdBy) {
        this.createdBy = createdBy;
    }

    public DataLink getCustomer() {
        return customer;
    }

    public void setCustomer(DataLink customer) {
        this.customer = customer;
    }

    public DataLink getMainContact() {
        return mainContact;
    }

    public void setMainContact(DataLink mainContact) {
        this.mainContact = mainContact;
    }

    public List<DataLink> getSecondaryContacts() {
        return secondaryContacts;
    }

    public void setSecondaryContacts(List<DataLink> secondaryContacts) {
        this.secondaryContacts = secondaryContacts;
    }

    public String getPrintHeader() {
        return printHeader;
    }

    public void setPrintHeader(String printHeader) {
        this.printHeader = printHeader;
    }

    public String getPaymentConditions() {
        return paymentConditions;
    }

    public void setPaymentConditions(String paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public DataLink getFinancialEntity() {
        return financialEntity;
    }

    public void setFinancialEntity(DataLink financialEntity) {
        this.financialEntity = financialEntity;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public String getPrintCurrency() {
        return printCurrency;
    }

    public void setPrintCurrency(String printCurrency) {
        this.printCurrency = printCurrency;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
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
}
