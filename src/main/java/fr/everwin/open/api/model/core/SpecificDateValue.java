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
package fr.everwin.open.api.model.core;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Specialized SpecificData for date
 * @author everwin-team
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecificDateValue extends SpecificData {

	@XmlElement
	private Date value;

	/**
	 * 
	 */
	public SpecificDateValue() {
		super();
		this.type = SpecificType.DATE;
	}

	public SpecificDateValue(String name) {
		super(name);
		this.type = SpecificType.DATE;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof SpecificDateValue) {
			Date date = ((SpecificDateValue) obj).getValue();
			return (this.value == null && date == null) || this.value.equals(date);
		} else {
			return false;
		}
	}

}
