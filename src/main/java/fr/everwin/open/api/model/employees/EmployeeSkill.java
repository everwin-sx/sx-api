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
 * Employee skill class
 * @author everwin-team
 */
package fr.everwin.open.api.model.employees;

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
 * Represents an employee skill
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "employeeSkill")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeSkill extends BasicObject {

	@XmlElement
	private DataLink employee;
	
	@XmlElement
	private DataLink skill;
	
	@XmlElement
	private DataLink level;
	
	@XmlElement
	private String comment;
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date startDate;
	
	@XmlElement
	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date endDate;
	
	
	@XmlElementWrapper(name = "extraData")
	@XmlElements({@XmlElement(name = "stringval", type = SpecificStringValue.class),
	@XmlElement(name = "dateval", type = SpecificDateValue.class),
	@XmlElement(name = "numberval", type = SpecificNumberValue.class),
	@XmlElement(name = "link", type = SpecificLinkValue.class),
	@XmlElement(name = "multilink", type = SpecificMultiLinkValue.class)})
	private List<SpecificData> extraData;
	/**
	 * 
	 */
	public EmployeeSkill() {

	}
	
	public DataLink getSkill() {
		return skill;
	}
	public void setSkill(DataLink skill) {
		this.skill = skill;
	}
	public DataLink getLevel() {
		return level;
	}
	public void setLevel(DataLink level) {
		this.level = level;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<SpecificData> getExtraData() {
		return extraData;
	}
	public void setExtraData(List<SpecificData> extraData) {
		this.extraData = extraData;
	}

	public DataLink getEmployee() {
		return employee;
	}

	public void setEmployee(DataLink employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeSkill [employee=" + employee + ", skill=" + skill + ", level=" + level + "]";
	}
	
	

}
