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
package com.everwin.open.api.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Generic class for links
 * @author everwin-team
 */
@XmlRootElement(name="datalink")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataLink {

	@XmlElement
	protected Long id;

	@XmlElement
	protected String value;

	@XmlElement
	protected String href;

	public DataLink() {

	}
	public DataLink(Long id, String value) {
		this.id = id;
		this.value = value;
	}

	public Long getId() {
		if (id == null) {
			return Long.valueOf(-1);
		}
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}


	@Override
	public String toString() {
		return "DataLink [id=" + id + ", value=" + value + ", href=" + href + "]";
	}

}
