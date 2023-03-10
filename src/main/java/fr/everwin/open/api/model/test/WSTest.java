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

package fr.everwin.open.api.model.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;

import java.util.Date;
import java.util.List;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WSTest {

    private Long id;
    private String idWst;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date dateWst;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date date2Wst;
    private Short decodeIntWst;
    private String decodeStrWst;
    private String notNullWst;
    private String stringWst;
    private Short shortWst;
    private Integer intWst;
    private Long longWst;
    private Double doubleWst;
    private String labelWst;
    private DataLink wstWss;
    private List<DataLink> wstWscs;
    private DataLink wst2Wss;
    private String id2Wst;
    private List<SpecificData> extraData;

    public WSTest() {
        // Constructor empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdWst() {
        return idWst;
    }

    public void setIdWst(String idWst) {
        this.idWst = idWst;
    }

    public Date getDateWst() {
        return dateWst;
    }

    public void setDateWst(Date dateWst) {
        this.dateWst = dateWst;
    }

    public Short getDecodeIntWst() {
        return decodeIntWst;
    }

    public void setDecodeIntWst(Short decodeIntWst) {
        this.decodeIntWst = decodeIntWst;
    }

    public String getDecodeStrWst() {
        return decodeStrWst;
    }

    public void setDecodeStrWst(String decodeStringWst) {
        this.decodeStrWst = decodeStringWst;
    }

    public String getNotNullWst() {
        return notNullWst;
    }

    public void setNotNullWst(String notNullWst) {
        this.notNullWst = notNullWst;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    public Short getShortWst() {
        return shortWst;
    }

    public void setShortWst(Short shortWst) {
        this.shortWst = shortWst;
    }

    public Integer getIntWst() {
        return intWst;
    }

    public void setIntWst(Integer intWst) {
        this.intWst = intWst;
    }

    public Long getLongWst() {
        return longWst;
    }

    public void setLongWst(Long longWst) {
        this.longWst = longWst;
    }

    public String getLabelWst() {
        return labelWst;
    }

    public void setLabelWst(String labelWst) {
        this.labelWst = labelWst;
    }

    public DataLink getWstWss() {
        return wstWss;
    }

    public void setWstWss(DataLink wstWss) {
        this.wstWss = wstWss;
    }

    public List<DataLink> getWstWscs() {
        return wstWscs;
    }

    public void setWstWscs(List<DataLink> wstWscs) {
        this.wstWscs = wstWscs;
    }

    public Double getDoubleWst() {
        return doubleWst;
    }

    public void setDoubleWst(Double doubleWst) {
        this.doubleWst = doubleWst;
    }

    public Date getDate2Wst() {
        return date2Wst;
    }

    public void setDate2Wst(Date date2Wst) {
        this.date2Wst = date2Wst;
    }

    public String getStringWst() {
        return stringWst;
    }

    public void setStringWst(String stringWst) {
        this.stringWst = stringWst;
    }

    public DataLink getWst2Wss() {
        return wst2Wss;
    }

    public void setWst2Wss(DataLink wst2Wss) {
        this.wst2Wss = wst2Wss;
    }

    public String getId2Wst() {
        return id2Wst;
    }

    public void setId2Wst(String id2Wst) {
        this.id2Wst = id2Wst;
    }


}
