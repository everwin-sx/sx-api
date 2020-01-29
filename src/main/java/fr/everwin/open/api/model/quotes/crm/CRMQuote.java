package fr.everwin.open.api.model.quotes.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.quotes.Quote;

/**
 * CRM Quote class
 * @author everwin-team
 */
@XmlRootElement(name = "crmQuote")
@XmlAccessorType(XmlAccessType.FIELD)
public class CRMQuote extends Quote {

    @XmlElement
    private DataLink opportunity;

    @XmlElement
    private DataLink originQuote;

    @XmlElement
    private Long duplicationNumber;

    @XmlElement
    private Short repartitionStatus;

    public DataLink getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(DataLink opportunity) {
        this.opportunity = opportunity;
    }

    public DataLink getOriginQuote() {
        return originQuote;
    }

    public void setOriginQuote(DataLink originQuote) {
        this.originQuote = originQuote;
    }

    public Long getDuplicationNumber() {
        return duplicationNumber;
    }

    public void setDuplicationNumber(Long duplicationNumber) {
        this.duplicationNumber = duplicationNumber;
    }

    public Short getRepartitionStatus() {
        return repartitionStatus;
    }

    public void setRepartitionStatus(Short repartitionStatus) {
        this.repartitionStatus = repartitionStatus;
    }
}
