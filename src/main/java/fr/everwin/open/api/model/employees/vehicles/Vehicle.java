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

package fr.everwin.open.api.model.employees.vehicles;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;

/**
 * Vehicle
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle extends BasicObject {


    private Short type;
    private String label;
    private String registration;
    private Short fiscalPower;
    private Short fuel;
    private DataLink scale;
    private DataLink owner;
    private Short isArchived;

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Short getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(Short fiscalPower) {
        this.fiscalPower = fiscalPower;
    }

    public Short getFuel() {
        return fuel;
    }

    public void setFuel(Short fuel) {
        this.fuel = fuel;
    }

    public DataLink getScale() {
        return scale;
    }

    public void setScale(DataLink scale) {
        this.scale = scale;
    }

    public DataLink getOwner() {
        return owner;
    }

    public void setOwner(DataLink owner) {
        this.owner = owner;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }
}
