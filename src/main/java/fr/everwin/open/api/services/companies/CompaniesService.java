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
import fr.everwin.open.api.model.companies.accounts.CompanyAccountList;
import fr.everwin.open.api.model.contacts.ContactResponsibilityList;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.opportunities.OpportunityList;
import fr.everwin.open.api.model.products.assets.CustomerAssetList;
import fr.everwin.open.api.model.projects.ProjectList;
import fr.everwin.open.api.model.salesactions.SalesActionList;
import fr.everwin.open.api.services.contacts.ContactResponsibilitiesService;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.leads.LeadService;
import fr.everwin.open.api.services.opportunities.OpportunitiesService;
import fr.everwin.open.api.services.products.CustomerAssetsService;
import fr.everwin.open.api.services.projects.ProjectsService;
import fr.everwin.open.api.services.salesactions.SalesActionsService;
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

    public CompanyAccountList queryAccFromCompany(Company company, RequestParams params) throws CoreException {
        CompanyAccountsService service = new CompanyAccountsService(clientApi);
        return service.query(path + "/" + company.getId() + "/company-accounts", params);
    }

    public CompanyAccountList queryCustomersAccFromCompany(Company company, RequestParams params) throws CoreException {
        CompanyAccountsService service = new CompanyAccountsService(clientApi);
        return service.query(path + "/" + company.getId() + "/company-accounts/customers", params);
    }

    public CompanyAccountList querySuppliersAccFromCompany(Company company, RequestParams params) throws CoreException {
        CompanyAccountsService service = new CompanyAccountsService(clientApi);
        return service.query(path + "/" + company.getId() + "/company-accounts/suppliers", params);
    }

    public CustomerAssetList queryCustomersAssetsFromCompany(Company company, RequestParams params) throws CoreException {
        CustomerAssetsService service = new CustomerAssetsService(clientApi);
        return service.query(path + "/" + company.getId() + "/customer-assets", params);
    }

    public ContactResponsibilityList queryResponsabilitiesFromCompany(Company company, RequestParams params) throws CoreException {
        ContactResponsibilitiesService service = new ContactResponsibilitiesService(clientApi);
        return service.query( path + "/" + company.getId() + "/contact-responsibilities", params);
    }

    public SalesActionList querySAForCompany(Company company, RequestParams params) throws CoreException {
        SalesActionsService service = new SalesActionsService(clientApi);
        return service.query(path + "/" + company.getId() + "/sales-actions", params);
    }

    public ProjectList queryProjectsFromCompany(Company company, RequestParams params) throws CoreException {
        ProjectsService service = new ProjectsService(clientApi);
        return service.query(path + "/" + company.getId() +"/projects", params);
    }

    public LeadList queryLeadsFromCompany(Company company, RequestParams params) throws CoreException {
        LeadService service = new LeadService(clientApi);
        return service.query(path + "/" + company.getId() +"/leads", params);
    }

    public OpportunityList queryOpportunitiesFromCompany(Company company, RequestParams params) throws CoreException {
        OpportunitiesService service = new OpportunitiesService(clientApi);
        return service.query(path + "/" + company.getId() +"/opportunities", params);
    }

    public ContactResponsibilityList queryContactsFromCompany(Company company, RequestParams params) throws CoreException {
        ContactResponsibilitiesService service = new ContactResponsibilitiesService(clientApi);
        return service.query(path + "/" + company.getId() +"/contacts", params);
    }
}
