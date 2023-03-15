package fr.everwin.open.api.model.quotes.crm;


import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.quotes.Quote;

/**
 * CRM Quote class
 *
 * @author everwin-team
 */
public class CRMQuote extends Quote {

    private DataLink opportunity;
    private DataLink originQuote;
    private Long duplicationNumber;
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
