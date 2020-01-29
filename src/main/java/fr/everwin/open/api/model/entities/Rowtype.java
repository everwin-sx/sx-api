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

package fr.everwin.open.api.model.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;

/**
 * Represents a rowtype for a given entity
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "rowtype")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rowtype extends BasicObject {

	@XmlElement
	private String code;

	@XmlElement
	private Short type;

	@XmlElement
	private Short mode;

	@XmlElementWrapper(name = "entities")
	@XmlElements(@XmlElement(name = "entity", type = DataLink.class))
	private List<DataLink> entities;

	@XmlElementWrapper(name = "rowtypes")
	@XmlElements(@XmlElement(name = "rowtype", type = DataLink.class))
	private DataLink parent;

	@XmlElement
	private Short group;

	@XmlElement
	private Short isWorkUnit;

	@XmlElement
	private Double flateRateAmount;

	@XmlElementWrapper(name = "rowtypes")
	@XmlElements(@XmlElement(name = "rowtype", type = DataLink.class))
	private DataLink subscriptionRowtype;

	@XmlElementWrapper(name = "rowtypes")
	@XmlElements(@XmlElement(name = "rowtype", type = DataLink.class))
	private List<DataLink> subscriptionTimeRowtypes;

	@XmlElement
	private Short isInvoiceable;

	@XmlElement
	private Short isExcludedFromProductionCalculation;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Short getMode() {
		return mode;
	}

	public void setMode(Short mode) {
		this.mode = mode;
	}

	public List<DataLink> getEntities() {
		return entities;
	}

	public void setEntities(List<DataLink> entities) {
		this.entities = entities;
	}

	public DataLink getParent() {
		return parent;
	}

	public void setParent(DataLink parent) {
		this.parent = parent;
	}

	public Short getGroup() {
		return group;
	}

	public void setGroup(Short group) {
		this.group = group;
	}

	public Short getIsWorkUnit() {
		return isWorkUnit;
	}

	public void setIsWorkUnit(Short isWorkUnit) {
		this.isWorkUnit = isWorkUnit;
	}

	public Double getFlateRateAmount() {
		return flateRateAmount;
	}

	public void setFlateRateAmount(Double flateRateAmount) {
		this.flateRateAmount = flateRateAmount;
	}

	public DataLink getSubscriptionRowtype() {
		return subscriptionRowtype;
	}

	public void setSubscriptionRowtype(DataLink subscriptionRowtype) {
		this.subscriptionRowtype = subscriptionRowtype;
	}

	public List<DataLink> getSubscriptionTimeRowtypes() {
		return subscriptionTimeRowtypes;
	}

	public void setSubscriptionTimeRowtypes(List<DataLink> subscriptionTimeRowtypes) {
		this.subscriptionTimeRowtypes = subscriptionTimeRowtypes;
	}

	public Short getIsInvoiceable() {
		return isInvoiceable;
	}

	public void setIsInvoiceable(Short isInvoiceable) {
		this.isInvoiceable = isInvoiceable;
	}

	public Short getIsExcludedFromProductionCalculation() {
		return isExcludedFromProductionCalculation;
	}

	public void setIsExcludedFromProductionCalculation(Short isExcludedFromProductionCalculation) {
		this.isExcludedFromProductionCalculation = isExcludedFromProductionCalculation;
	}
}
