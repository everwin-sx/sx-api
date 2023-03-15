/*
 * Copyright (C) 2021 Everwin (www.everwin.fr)
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

package fr.everwin.open.api.model.quotes.crm.lines;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.quotes.QuoteLine;
import fr.everwin.open.api.model.quotes.QuoteLineDebitCredit;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRMQuoteLine extends QuoteLine {

    protected DataLink parent;
    protected Double discount;
    protected Double discountPercent;
    private DataLink quote;
    private DataLink opportunity;
    private DataLink product;
    private Short level;
    private boolean leaf;
    private DataLink unit;
    private Double revenueQuantity;
    private QuoteLineDebitCredit revenue;
    private QuoteLineDebitCredit revenueNet;
    private QuoteLineDebitCredit revenueDiscount;
    private Double expenditureQuantity;
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
        return leaf ? (short) 1 : (short) 0;
    }

    @Override
    public String toString() {
        return "CRMQuoteLine{" +
                "quote id='" + quote + '\'' +
                "level='" + level + '\'' +
                "order='" + order + '\'' +
                "leaf='" + leaf + '\'' +
                "comment='" + comment + '\'' +
                "reference='" + reference + '\'' +
                '}';
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
