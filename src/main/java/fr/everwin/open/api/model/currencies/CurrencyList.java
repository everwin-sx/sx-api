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

package fr.everwin.open.api.model.currencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.everwin.open.api.model.core.BasicList;

import java.util.List;

/**
 * currency list
 *
 * @author d.storti
 */


public class CurrencyList extends BasicList<Currency> {

    private final static String METHOD = "query";

    //    @JsonProperty("currency")
    @JsonProperty("currencies")
    private List<Currency> items;

    public CurrencyList() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Currency> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Currency> items) {
        this.items = items;
    }
}
