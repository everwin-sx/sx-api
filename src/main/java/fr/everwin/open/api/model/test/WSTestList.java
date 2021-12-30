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

package fr.everwin.open.api.model.test;
import java.util.List;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author d.storti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wstestlist")
public class WSTestList {

		private final static String METHOD="query"; 
		
		@XmlTransient
		private int limit;
		
		@XmlTransient
		private int offset; // Getters for these

		@XmlTransient
		private int modelLimit; // Getters for these

		@XmlTransient
		private String filter; // Getters for these

		@XmlTransient
		private String sort; // Getters for these1

		@XmlElement(name = "company")
		@XmlElementWrapper(name = "companies")
		private List<WSTest> items;

		@XmlElement(name = "selflink")
		protected String href;

		@XmlElement(name = "link")
		@XmlElementWrapper(name = "links")
		@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
		protected List<Link> links;

		/**
		 *
		 */
		public WSTestList() {
			// TODO Auto-generated constructor stub
		}

		public int getLimit() {
			return limit;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public int getModelLimit() {
			return modelLimit;
		}

		public void setModelLimit(int modelLimit) {
			this.modelLimit = modelLimit;
		}

		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		public List<Link> getLinks() {
			return links;
		}

		public void setLinks(List<Link> links) {
			this.links = links;
		}

		public List<WSTest> getItems() {
			return items;
		}

		public void setItems(List<WSTest> items) {
			this.items = items;
		}

		public String getFilter() {
			return filter;
		}

		public void setFilter(String filter) {
			this.filter = filter;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

	}
