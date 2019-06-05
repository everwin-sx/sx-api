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

package com.everwin.open.api.test;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.candidates.CandidateList;
import fr.everwin.open.api.model.candidates.CandidateSkillList;
import fr.everwin.open.api.model.companies.AccAccountList;
import fr.everwin.open.api.model.companies.CompanyAccountList;
import fr.everwin.open.api.model.companies.CompanyList;
import fr.everwin.open.api.model.companies.StatusList;
import fr.everwin.open.api.model.contacts.ContactResponsabilityList;
import fr.everwin.open.api.model.contacts.PersonList;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.currencies.CurrencyRateBasicList;
import fr.everwin.open.api.model.employees.EmployeeList;
import fr.everwin.open.api.model.employees.EmployeeSkillList;
import fr.everwin.open.api.model.entities.EntityList;
import fr.everwin.open.api.model.equipments.EquipmentList;
import fr.everwin.open.api.model.leaverequests.LeaveRequestList;
import fr.everwin.open.api.model.nafs.NafList;
import fr.everwin.open.api.model.opportunities.OpportunityList;
import fr.everwin.open.api.model.products.CustomerAssetList;
import fr.everwin.open.api.model.products.ProductList;
import fr.everwin.open.api.model.projects.ProjectList;
import fr.everwin.open.api.model.skills.SkillDomainList;
import fr.everwin.open.api.model.skills.SkillLevelList;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoiceLineList;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoiceList;
import fr.everwin.open.api.model.supplierorders.SupplierOrderList;
import fr.everwin.open.api.model.supplierorders.SupplierOrderLineList;
import fr.everwin.open.api.services.candidates.CandidateSkillsService;
import fr.everwin.open.api.services.candidates.CandidatesService;
import fr.everwin.open.api.services.companies.CompaniesService;
import fr.everwin.open.api.services.companies.CompanyAccAccountsService;
import fr.everwin.open.api.services.companies.CompanyAccountsService;
import fr.everwin.open.api.services.companies.CompanyStatusService;
import fr.everwin.open.api.services.contacts.ContactResponsabilitiesService;
import fr.everwin.open.api.services.contacts.PersonsService;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.currencyrates.CurrencyRatesService;
import fr.everwin.open.api.services.employees.EmployeesService;
import fr.everwin.open.api.services.employees.EmployeesSkillsService;
import fr.everwin.open.api.services.entities.EntitiesService;
import fr.everwin.open.api.services.equipments.EquipmentsService;
import fr.everwin.open.api.services.leaverequests.LeaveRequestsService;
import fr.everwin.open.api.services.nafs.NafsService;
import fr.everwin.open.api.services.opportunities.OpportunitiesService;
import fr.everwin.open.api.services.products.CustomerAssetsService;
import fr.everwin.open.api.services.products.ProductsService;
import fr.everwin.open.api.services.projects.ProjectLinesService;
import fr.everwin.open.api.services.projects.ProjectsService;
import fr.everwin.open.api.services.skills.SkillDomainsService;
import fr.everwin.open.api.services.skills.SkillLevelsService;
import fr.everwin.open.api.services.skills.SkillsService;
import fr.everwin.open.api.services.supplierinvoices.SupplierInvoiceLineService;
import fr.everwin.open.api.services.supplierinvoices.SupplierInvoiceService;
import fr.everwin.open.api.services.supplierorders.SupplierOrderLineService;
import fr.everwin.open.api.services.supplierorders.SupplierOrderService;

public class ClientApiResourcesTest {

    protected ClientApi clientApi;

    protected String uri = "http://localhost:8080/sx/rest";
    protected String version = "v2";

    @BeforeTest
    public void setUp(){
        try {
            clientApi = new ClientApi(uri, version);

            clientApi.setApiKey("311528502c954bb0ce0ca304a47a2c51");
            //clientApi.setAuthInfos("36103e9e671e0806c354f5a289070bfb", "5d1d6d3c7d7950fdbfb4167b6936757f");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Test(priority = 1)
    public void testCandidates() {
        try {
            CandidatesService service = new CandidatesService(clientApi);
            CandidateList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 1)
    public void testCandidateSkills() {
        try {
            CandidateSkillsService service = new CandidateSkillsService(clientApi);
            CandidateSkillList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 1)
    public void testCompanies(){
        try {
            CompaniesService service = new CompaniesService(clientApi);
            CompanyList list = service.query();
            testUpdate(service, list);
        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 1)
    public void testCompanyAccounts() {
        try {
            CompanyAccountsService service = new CompanyAccountsService(clientApi);
            CompanyAccountList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCompanyAccAccounts() {
        try {
            CompanyAccAccountsService service = new CompanyAccAccountsService(clientApi);
            AccAccountList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCompanyStatus() {
        try {
            CompanyStatusService service = new CompanyStatusService(clientApi);
            StatusList list = service.query();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testResponsabilities() {
        try {
            ContactResponsabilitiesService service = new ContactResponsabilitiesService(clientApi);
            ContactResponsabilityList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testPersons() {
        try {
            PersonsService service = new PersonsService(clientApi);
            PersonList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testEntities() {
        try {
            EntitiesService service = new EntitiesService(clientApi);
            EntityList list = service.query();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testEquipments() {
        try {
            EquipmentsService service = new EquipmentsService(clientApi);
            EquipmentList list = service.query();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testEmployees() {
        try {
            EmployeesService service = new EmployeesService(clientApi);
            EmployeeList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testEmployeeSkills() {
        try {
            EmployeesSkillsService service = new EmployeesSkillsService(clientApi);
            EmployeeSkillList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCurrencyRates() {
        try {
            CurrencyRatesService service = new CurrencyRatesService(clientApi);
            CurrencyRateBasicList list = service.query();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testLeaveRequest() {
        try {
            LeaveRequestsService service = new LeaveRequestsService(clientApi);
            LeaveRequestList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testNafs() {
        try {
            NafsService service = new NafsService(clientApi);
            NafList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testOpportunities() {
        try {
            OpportunitiesService service = new OpportunitiesService(clientApi);
            OpportunityList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCustomerAssets() {
        try {
            CustomerAssetsService service = new CustomerAssetsService(clientApi);
            CustomerAssetList list = service.query();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProducts() {
        try {
            ProductsService service = new ProductsService(clientApi);
            ProductList list = service.query();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjects() {
        try {
            ProjectsService service = new ProjectsService(clientApi);
            ProjectList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectLines() {
        try {
            ProjectLinesService service = new ProjectLinesService(clientApi);

            // Not implemented
            //ProjectLineList list = service.query();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSkills() {
        try {
            SkillsService service = new SkillsService(clientApi);
            SkillList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSkillLevels() {
        try {
            SkillLevelsService service = new SkillLevelsService(clientApi);
            SkillLevelList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSkillDomains() {
        try {
            SkillDomainsService service = new SkillDomainsService(clientApi);
            SkillDomainList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierInvoiceLines() {
        try {
            SupplierInvoiceLineService service = new SupplierInvoiceLineService(clientApi);
            SupplierInvoiceLineList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierInvoices() {
        try {
            SupplierInvoiceService service = new SupplierInvoiceService(clientApi);
            SupplierInvoiceList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierOrders() {
        try {
            SupplierOrderService service = new SupplierOrderService(clientApi);
            SupplierOrderList list = service.query();
            //testUpdate(service, list);
            // Not implemented
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierOrderLines() {
        try {
            SupplierOrderLineService service = new SupplierOrderLineService(clientApi);
            SupplierOrderLineList list = service.query();
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }


    public void testUpdate(BasicService service, BasicList list) throws Exception {
        BasicObject object = (BasicObject)list.getItems().get(0);
        service.update(object);
    }
}