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

package fr.everwin.open.api.model.contacts.events;

// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlElementWrapper;
// import javax.xml.bind.annotation.XmlElements;
// import javax.xml.bind.annotation.XmlRootElement;
// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;

import java.util.Date;
import java.util.List;

/**
 * contactevent
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class ContactEvent extends BasicObject {

    private DataLink contactResponsibility;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date;


    private String type;


    private String event;

    private List<SpecificData> extraData;

    public ContactEvent() {
    }

    public DataLink getContactResponsibility() {
        return contactResponsibility;
    }

    public void setContactResponsibility(DataLink contactResponsibility) {
        this.contactResponsibility = contactResponsibility;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        return "Contact responsibility event [id=" + id + ", contactResponsibility=" + contactResponsibility + ", date=" + date + ", type=" + type + ", event=" + event + "]";
    }
}
