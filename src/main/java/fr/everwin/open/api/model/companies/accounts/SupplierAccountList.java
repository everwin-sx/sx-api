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

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.everwin.open.api.model.core.BasicList;

import java.util.List;

/**
 * @author d.storti
 */
public class SupplierAccountList extends BasicList<CompanyAccount> {

    @JsonProperty("companyaccount")
    private List<CompanyAccount> items;

    public SupplierAccountList() {

    }

    @Override
    public List<CompanyAccount> getItems() {
        return this.items;
    }

    @Override
    public void setItems(List items) {
        this.items = items;
    }
}
