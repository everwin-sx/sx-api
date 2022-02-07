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

package fr.everwin.open.api.model.projects.activities;
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
 * ProjectActivity class
 * @author d.storti
 */
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @XmlRootElement(name = "projectactivity")
        @XmlAccessorType(XmlAccessType.FIELD)
public class ProjectActivity extends BasicObject {

    @XmlElement
    private String code;

    @XmlElement
    private String label;

    @XmlElement
    private DataLink phase;

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
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date realStartDate;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date realEndDate;

    @XmlElement
    private String comment;

    @XmlElement
    private DataLink category;

    @XmlElement
    private DataLink defaultLineCurrency;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public DataLink getPhase() {
        return phase;
    }

    public void setPhase(DataLink phase) {
        this.phase = phase;
    }

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    public Date getInitialStartDate() {
        return initialStartDate;
    }

    public void setInitialStartDate(Date initialStartDate) {
        this.initialStartDate = initialStartDate;
    }

    public Date getInitialEndDate() {
        return initialEndDate;
    }

    public void setInitialEndDate(Date initialEndDate) {
        this.initialEndDate = initialEndDate;
    }

    public Date getUpdatedStartDate() {
        return updatedStartDate;
    }

    public void setUpdatedStartDate(Date updatedStartDate) {
        this.updatedStartDate = updatedStartDate;
    }

    public Date getUpdatedEndDate() {
        return updatedEndDate;
    }

    public void setUpdatedEndDate(Date updatedEndDate) {
        this.updatedEndDate = updatedEndDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataLink getCategory() {
        return category;
    }

    public void setCategory(DataLink category) {
        this.category = category;
    }

    public DataLink getDefaultLineCurrency() {
        return defaultLineCurrency;
    }

    public void setDefaultLineCurrency(DataLink defaultLineCurrency) {
        this.defaultLineCurrency = defaultLineCurrency;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
