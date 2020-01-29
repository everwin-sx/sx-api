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
package fr.everwin.open.api.model.quotes.crm;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import fr.everwin.open.api.model.core.BasicList;


/**
 * CRM quotes lines list
 * @author everwin-team
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "crmquotelinelist")
public class CRMQuoteLineList extends BasicList<CRMQuoteLine> {

	@XmlElement(name = "crmquoteline")
	@XmlElementWrapper(name = "crmquotelines")
	private List<CRMQuoteLine> items;

	public CRMQuoteLineList() {

	}

	public List<CRMQuoteLine> getItems() {
		return items;
	}

	public void setItems(List<CRMQuoteLine> items) {
		this.items = items;
	}


}
