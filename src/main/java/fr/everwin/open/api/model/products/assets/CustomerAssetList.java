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
package fr.everwin.open.api.model.products.assets;

import fr.everwin.open.api.model.core.BasicList;

import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * Customer assets list
 * @author everwin-team
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer-assetlist")
public class CustomerAssetList extends BasicList<CustomerAsset> {

    private final static String METHOD = "query";

    @XmlTransient
    private int limit;

    @XmlTransient
    private int offset;

    @XmlTransient
    private int modelLimit;

    @XmlTransient
    private String filter;

    @XmlTransient
    private String sort;

    @XmlElement(name = "customer-asset")
    @XmlElementWrapper(name = "customer-assets")
    private List<CustomerAsset> items;


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

    @Override
    public List<CustomerAsset> getItems() {
        return items;
    }

    @Override
    public void setItems(List<CustomerAsset> items) {
        this.items = items;
    }
}
