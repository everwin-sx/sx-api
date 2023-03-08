package fr.everwin.open.api.model.quotes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;

import java.util.List;

/**
 * Quote line class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteLine extends BasicObject {


    protected DataLink type;


    protected QuoteResource resource;


    protected String reference;


    protected String comment;


    protected DataLink vat;


    protected Double vatRate;


    protected Double vat2Rate;


    protected Short order;


    protected List<SpecificData> extraData;

    public QuoteLine() {
        super();
        resource = new QuoteResource();
    }

    public DataLink getType() {
        return type;
    }

    public void setType(DataLink type) {
        this.type = type;
    }

    public QuoteResource getResource() {
        return resource;
    }

    public void setResource(QuoteResource resource) {
        this.resource = resource;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataLink getVat() {
        return vat;
    }

    public void setVat(DataLink vat) {
        this.vat = vat;
    }

    public Double getVatRate() {
        return vatRate;
    }

    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }

    public Double getVat2Rate() {
        return vat2Rate;
    }

    public void setVat2Rate(Double vat2Rate) {
        this.vat2Rate = vat2Rate;
    }

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
