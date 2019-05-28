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

package fr.everwin.open.api.services.companies;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.companies.Company;
import fr.everwin.open.api.model.companies.CompanyList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the companies API resource
 * @author everwin-team
 */
public class CompaniesService extends BasicService<Company, CompanyList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public CompaniesService(ClientApi client){
        super(client, "companies");
        setModels(Company.class, CompanyList.class);
    }

    public CompanyList queryCustomers(RequestParams params) throws CoreException {
        return query(path + "/customers", params);
    }

    public CompanyList querySuppliers(RequestParams params) throws CoreException {
        return query(path + "/suppliers", params);
    }

}
