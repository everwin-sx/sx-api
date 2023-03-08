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

package fr.everwin.open.api.model.equipments.families;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;

/**
 * Family class
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class Family extends BasicObject {


    private String code;


    private DataLink entity;


    private DataLink financialEntity;


    private DataLink workMode;


    private Short isArchived;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public DataLink getFinancialEntity() {
        return financialEntity;
    }

    public void setFinancialEntity(DataLink financialEntity) {
        this.financialEntity = financialEntity;
    }

    public DataLink getWorkMode() {
        return workMode;
    }

    public void setWorkMode(DataLink workMode) {
        this.workMode = workMode;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }
}
