package fr.everwin.open.api.model.quotes;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * Quote class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quote extends BasicObject {

    @XmlElement
    private String code;

    @XmlElement
    private Long number;

    @XmlElement
    private DataLink createdBy;

    @XmlElement
    private DataLink customer;

    @XmlElement
    private DataLink mainContact;

    @XmlElementWrapper(name = "secondaryContacts")
    @XmlElements(@XmlElement(name = "secondaryContact", type = DataLink.class))
    private List<DataLink> secondaryContacts;

    @XmlElement
    private String printHeader;

    @XmlElement
    private String notes;

    @XmlElement
    private String paymentConditions;

    @XmlElement
    private String delay;

    @XmlElement
    private DataLink entity;

    @XmlElement
    private DataLink financialEntity;

    @XmlElement
    private Short status;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date sendingDate;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date signatureDate;

    @XmlElement
    private String refusalReason;

    @XmlElement
    private String printCurrency;

    @XmlElement
    private Double conversionRate;

    @XmlElement
    private Short type;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;

    @XmlElement
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;

    @XmlElement
    private String updatedBy;

    @XmlElementWrapper(name = "extraData")
    @XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
            @XmlElement(name = "dateval", type = SpecificDateValue.class),
            @XmlElement(name = "numberval", type = SpecificNumberValue.class),
            @XmlElement(name = "link", type = SpecificLinkValue.class),
            @XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
    private List<SpecificData> extraData;

    public DataLink getEntity(){
        return entity;
    }
    public  void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCode() {
        return code;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "code='" + code + '\'' +
                '}';
    }
}
