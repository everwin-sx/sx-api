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

package fr.everwin.open.api.model.companies.accounts.acc;

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
 * Acc accounts represents an account for a company account. <br>
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class AccAccount extends BasicObject {


    private DataLink companyAccount;


    private List<DataLink> entities;


    private String generalAccount;


    private String subsidiaryAccount;


    private String book;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;


    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;

    private String updatedBy;

    private List<SpecificData> extraData;

    public AccAccount() {
    }

    public DataLink getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(DataLink companyAccount) {
        this.companyAccount = companyAccount;
    }

    public List<DataLink> getEntities() {
        return entities;
    }

    public void setEntities(List<DataLink> entities) {
        this.entities = entities;
    }


    public String getGeneralAccount() {
        return generalAccount;
    }

    public void setGeneralAccount(String generalAccount) {
        this.generalAccount = generalAccount;
    }

    public String getSubsidiaryAccount() {
        return subsidiaryAccount;
    }

    public void setSubsidiaryAccount(String subsidiaryAccount) {
        this.subsidiaryAccount = subsidiaryAccount;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

}
