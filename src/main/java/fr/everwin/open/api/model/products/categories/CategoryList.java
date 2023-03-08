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
package fr.everwin.open.api.model.products.categories;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.everwin.open.api.model.core.BasicList;

import java.util.List;


/**
 * Product categories list
 *
 * @author everwin-team
 */


public class CategoryList extends BasicList<Category> {

    private final static String METHOD = "query";


    private int limit;


    private int offset;


    private int modelLimit;


    private String filter;


    private String sort;

    //    @JsonProperty("product-category")
    @JsonProperty("product-categories")
    private List<Category> items;

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
    public List<Category> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Category> items) {
        this.items = items;
    }
}
