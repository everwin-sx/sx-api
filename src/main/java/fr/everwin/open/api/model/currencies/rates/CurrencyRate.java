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

/**
 *
 */
package fr.everwin.open.api.model.currencies.rates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;

import java.util.Date;
import java.util.List;

/**
 * Currency rate class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRate extends BasicObject {


    private DataLink entity;
    private String baseCurrency;
    private String counterCurrency;
    private Double rate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date startDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date endDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;
    private Short updateMainRate;

    private List<SpecificData> extraData;

    /**
     *
     */
    public CurrencyRate() {

    }

    /**
     * @return the entity
     */
    public DataLink getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    /**
     * @return the baseCurrency
     */
    public String getBaseCurrency() {
        return baseCurrency;
    }

    /**
     * @param baseCurrency the baseCurrency to set
     */
    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    /**
     * @return the counterCurrency
     */
    public String getCounterCurrency() {
        return counterCurrency;
    }

    /**
     * @param counterCurrency the counterCurrency to set
     */
    public void setCounterCurrency(String counterCurrency) {
        this.counterCurrency = counterCurrency;
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the updatedOnTime
     */
    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    /**
     * @param updatedOnTime the updatedOnTime to set
     */
    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    /**
     * @return the createdOnTime
     */
    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    /**
     * @param createdOnTime the createdOnTime to set
     */
    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    /**
     * @return the updateMainRate
     */
    public Short getUpdateMainRate() {
        return updateMainRate;
    }

    /**
     * @param updateMainRate the updateMainRate to set
     */
    public void setUpdateMainRate(Short updateMainRate) {
        this.updateMainRate = updateMainRate;
    }

    /**
     * @return the extraData
     */
    public List<SpecificData> getExtraData() {
        return extraData;
    }

    /**
     * @param extraData the extraData to set
     */
    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CurrencyRate [entity=" + entity + ", baseCurrency=" + baseCurrency + ", counterCurrency=" + counterCurrency + ", rate=" + rate + ", startDate=" + startDate + ", endDate=" + endDate + ", updatedOnTime=" + updatedOnTime + ", createdOnTime=" + createdOnTime + "]";
    }
}
