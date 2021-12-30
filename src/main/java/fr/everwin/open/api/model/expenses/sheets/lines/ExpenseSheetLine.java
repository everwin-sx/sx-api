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

package fr.everwin.open.api.model.expenses.sheets.lines;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.model.core.SpecificDateValue;
import fr.everwin.open.api.model.core.SpecificLinkValue;
import fr.everwin.open.api.model.core.SpecificMultiLinkValue;
import fr.everwin.open.api.model.core.SpecificNumberValue;
import fr.everwin.open.api.model.core.SpecificStringValue;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.XMLDateAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ExpenseSheetLine class
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "expensessheetline")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExpenseSheetLine extends BasicObject {

    @XmlElement
    private DataLink expenseSheet;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date;

    @XmlElement
    private DataLink project;

    @XmlElement
    private DataLink type;

    @XmlElement
    private DataLink projectLine;

    @XmlElement
    private DataLink missionOrder;

    @XmlElement
    private String title;

    @XmlElement
    private String comment;

    @XmlElement
    private String place;

    @XmlElement
    private String lettering;

    @XmlElement
    private Double quantity;

    @XmlElement
    private DataLink currency;

    @XmlElement
    private ExpenseSheetLineMultiCurrencyValue amount;

    @XmlElement
    private ExpenseSheetLineMultiCurrencyValue totalIncludingVat;

    @XmlElement
    private ExpenseSheetLineMultiCurrencyValue totalWithoutVat;

    @XmlElement
    private ExpenseSheetLineMultiCurrencyValue totalInvoiceAgain;

    @XmlElement
    private Double vat;

    @XmlElement
    private Short reinvoiceable;

    @XmlElement
    private String startingAddress;

    @XmlElement
    private String arrivalAddress;

    @XmlElement
    private DataLink account;

    @XmlElement
    private DataLink vehicle;

    @XmlElement
    private Double distanceToDate;

    @XmlElement
    private Short nonRefundable;

    @XmlElementWrapper(name = "extraData")
    @XmlElements({
            @XmlElement(
                    name = "stringval",
                    type = SpecificStringValue.class
            ),
            @XmlElement(
                    name = "dateval",
                    type = SpecificDateValue.class
            ),
            @XmlElement(
                    name = "numberval",
                    type = SpecificNumberValue.class
            ),
            @XmlElement(name = "link", type = SpecificLinkValue.class
            ),
            @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class
            )
    })
    private List<SpecificData> extraData;

    public ExpenseSheetLine() {
        amount = new ExpenseSheetLineMultiCurrencyValue();
        totalIncludingVat = new ExpenseSheetLineMultiCurrencyValue();
        totalWithoutVat = new ExpenseSheetLineMultiCurrencyValue();
        totalInvoiceAgain = new ExpenseSheetLineMultiCurrencyValue();
    }

    @Override
    public String toString() {
        return "Supplier invoice line [supplierInvoice=" + (expenseSheet!=null ? expenseSheet.getId() : null) + ", Title=" + title + "]";
    }
}
