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

package fr.everwin.open.api.model.projects.lines;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "writable-project-line")
@XmlAccessorType(XmlAccessType.FIELD)
public class WritableProjectLine extends BasicObject {

    @XmlElement
    private DataLink activity;

    @XmlElement
    private DataLink type;

    @XmlElement
    private DataLink resource;

    @XmlElement
    private String comment;

    @XmlElement
    private Short invoicingMode;

    @XmlElement
    private DataLink product;

    @XmlElement
    private String unit;

    @XmlElement
    private String currency;

    @XmlElement
    private Short order;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date initialStartDate;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date initialEndDate;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedStartDate;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedEndDate;

    @XmlElement
    private Revenue estimatedRevenue;

    @XmlElement(nillable = true)
    private Discount estimatedDiscount;

    @XmlElement(nillable = true)
    private Expenditure estimatedExpenditure;

    @XmlElement(nillable = true)
    private Revenue forecastRevenue;

    @XmlElement(nillable = true)
    private Expenditure forecastExpenditure;

    @XmlElementWrapper(name = "extraData")
    @XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
            @XmlElement(name = "dateval", type = SpecificDateValue.class),
            @XmlElement(name = "numberval", type = SpecificNumberValue.class),
            @XmlElement(name = "link", type = SpecificLinkValue.class),
            @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
    private List<SpecificData> extraData;

    public WritableProjectLine() {

    }
}
