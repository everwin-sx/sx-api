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

package fr.everwin.open.api.model.quotes.poa.items;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.model.core.SpecificDateValue;
import fr.everwin.open.api.model.core.SpecificLinkValue;
import fr.everwin.open.api.model.core.SpecificMultiLinkValue;
import fr.everwin.open.api.model.core.SpecificNumberValue;
import fr.everwin.open.api.model.core.SpecificStringValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author d.storti
 */
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @XmlRootElement(name = "poaquoteitem")
        @XmlAccessorType(XmlAccessType.FIELD)
public class POAQuoteItem extends BasicObject {

    @XmlElement
    private String code;

    @XmlElement
    private String title;

    @XmlElement
    private String comment;

    @XmlElement
    private DataLink quote;

    @XmlElement
    private Short order;

    @XmlElement
    private Short printingMode;

    @XmlElement
    private DataLink projectPhase;

    @XmlElement
    private Long number;

    @XmlElementWrapper(name = "extraData")
    @XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
            @XmlElement(name = "dateval", type = SpecificDateValue.class),
            @XmlElement(name = "numberval", type = SpecificNumberValue.class),
            @XmlElement(name = "link", type = SpecificLinkValue.class),
            @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
    private List<SpecificData> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataLink getQuote() {
        return quote;
    }

    public void setQuote(DataLink quote) {
        this.quote = quote;
    }

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    public Short getPrintingMode() {
        return printingMode;
    }

    public void setPrintingMode(Short printingMode) {
        this.printingMode = printingMode;
    }

    public DataLink getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(DataLink projectPhase) {
        this.projectPhase = projectPhase;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
