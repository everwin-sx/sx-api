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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.quotes.QuoteLine;
import fr.everwin.open.api.model.quotes.QuoteLineDebitCredit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "crmQuoteLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class CRMQuoteLine extends QuoteLine {

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

}
