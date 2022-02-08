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
package fr.everwin.open.api.model.companies.accounts;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.everwin.open.api.model.core.BasicList;


/**
 * CompanyAccount list
 * @author everwin-team
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "companyaccountlist")
public class CompanyAccountList extends BasicList<CompanyAccount> {

	private final static String METHOD="query";

	@XmlElement(name = "companyaccount")
	@XmlElementWrapper(name = "companyaccounts")
	private List<CompanyAccount> items;

	@XmlElement(name = "selflink")
	protected String href;

	@XmlElement(name = "link")
	@XmlElementWrapper(name = "links")
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	protected List<Link> links;

	public CompanyAccountList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CompanyAccount> getItems() {
		return this.items;
	}

	@Override
	public List getLinks() {
		return links;
	}

	@Override
	public void setItems(List items) {
		this.items = items;
	}
}