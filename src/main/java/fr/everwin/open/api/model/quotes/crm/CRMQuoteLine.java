package fr.everwin.open.api.model.quotes.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.quotes.QuoteLine;
import fr.everwin.open.api.model.quotes.QuoteLineDebitCredit;

/**
 * CRM Quote line class
 * @author everwin-team
 */
@XmlRootElement(name = "crmQuoteLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class CRMQuoteLine extends QuoteLine {

    @XmlElement
    private DataLink quote;

    @XmlElement
    protected DataLink parent;

    @XmlElement
    private DataLink opportunity;

    @XmlElement
    private DataLink product;

    @XmlElement
    private Short level;

    @XmlElement
    private boolean leaf;

    @XmlElement
    private DataLink unit;

    @XmlElement
    protected Double discount;

    @XmlElement
    protected Double discountPercent;

    @XmlElement
    private Double revenueQuantity;

    @XmlElement
    private QuoteLineDebitCredit revenue;

    @XmlElement
    private QuoteLineDebitCredit revenueNet;

    @XmlElement
    private QuoteLineDebitCredit revenueDiscount;

    @XmlElement
    private Double expenditureQuantity;

    @XmlElement
    private QuoteLineDebitCredit expenditure;

    public CRMQuoteLine() {
        super();
        revenue = new QuoteLineDebitCredit();
        revenueNet = new QuoteLineDebitCredit();
        revenueDiscount = new QuoteLineDebitCredit();
        expenditure = new QuoteLineDebitCredit();
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public void setLeaf(Short leaf) {
        this.leaf = leaf == 1;
    }

    public Short isLeaf() {
        return leaf ? (short)1 : (short)0;
    }

    public DataLink getQuote() {
        return quote;
    }

    public void setQuote(DataLink quote) {
        this.quote = quote;
    }

    public DataLink getParent() {
        return parent;
    }

    public void setParent(DataLink parent) {
        this.parent = parent;
    }

    public DataLink getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(DataLink opportunity) {
        this.opportunity = opportunity;
    }

    public DataLink getProduct() {
        return product;
    }

    public void setProduct(DataLink product) {
        this.product = product;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public DataLink getUnit() {
        return unit;
    }

    public void setUnit(DataLink unit) {
        this.unit = unit;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getRevenueQuantity() {
        return revenueQuantity;
    }

    public void setRevenueQuantity(Double revenueQuantity) {
        this.revenueQuantity = revenueQuantity;
    }

    public QuoteLineDebitCredit getRevenue() {
        return revenue;
    }

    public void setRevenue(QuoteLineDebitCredit revenue) {
        this.revenue = revenue;
    }

    public QuoteLineDebitCredit getRevenueNet() {
        return revenueNet;
    }

    public void setRevenueNet(QuoteLineDebitCredit revenueNet) {
        this.revenueNet = revenueNet;
    }

    public QuoteLineDebitCredit getRevenueDiscount() {
        return revenueDiscount;
    }

    public void setRevenueDiscount(QuoteLineDebitCredit revenueDiscount) {
        this.revenueDiscount = revenueDiscount;
    }

    public Double getExpenditureQuantity() {
        return expenditureQuantity;
    }

    public void setExpenditureQuantity(Double expenditureQuantity) {
        this.expenditureQuantity = expenditureQuantity;
    }

    public QuoteLineDebitCredit getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(QuoteLineDebitCredit expenditure) {
        this.expenditure = expenditure;
    }
}
