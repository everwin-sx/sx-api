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
package fr.everwin.open.api.model.supplierorders.lines;

import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.nafs.Naf;
import fr.everwin.open.api.model.supplierorders.SupplierOrder;


/**
 * Supplier order lines list
 * @author everwin-team
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "supplierorderlinelist")
public class SupplierOrderLineList extends BasicList<SupplierOrderLine> {

	private final static String METHOD = "query";

	@XmlElement(name = "supplierorderline")
	@XmlElementWrapper(name = "supplierorderlines")
	private List<SupplierOrderLine> items;

	@Override
	public List<SupplierOrderLine> getItems() {
		return items;
	}

	@Override
	public void setItems(List<SupplierOrderLine> items) {
		this.items = items;
	}
}
