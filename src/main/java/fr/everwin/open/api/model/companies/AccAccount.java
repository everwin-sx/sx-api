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

package fr.everwin.open.api.model.companies;

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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Acc accounts represents an account for a company account. <br>
 * @author everwin-team
 */

@XmlRootElement(name = "accaccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccAccount extends BasicObject {

	@XmlElement
	private DataLink companyAccount;

	@XmlElement
	private List<DataLink> entities;

	@XmlElement
	private String generalAccount;

	@XmlElement
	private String subsidiaryAccount;

	@XmlElement
	private String book;

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
	public AccAccount() {}

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
