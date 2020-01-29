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
package fr.everwin.open.api.model.companies;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.everwin.open.api.model.core.BasicObject;


/**
 * Status class
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
public class Status extends BasicObject {

	@XmlElement
	private String name;

	@XmlElement
	private String label;

	@XmlElement
	private Short access;

	@XmlElement
	private int defaultStatus;

	@XmlElement
	private String color;

	@XmlElement
	private Short archived;

	@XmlElement
	private Short corporamaStatus;

	public Status() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(Short access) {
		this.access = access;
	}

	public int getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(Short defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Short getArchived() {
		return archived;
	}

	public void setArchived(Short archived) {
		this.archived = archived;
	}

	public Short getCorporamaStatus() {
		return corporamaStatus;
	}

	public void setCorporamaStatus(Short corporamaStatus) {
		this.corporamaStatus = corporamaStatus;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + ", label=" + label + ", access=" + access + ", defaultStatus=" + defaultStatus + ", color=" + color + ", archived=" + archived + ", corporamaStatus=" + corporamaStatus + "]";
	}

}
