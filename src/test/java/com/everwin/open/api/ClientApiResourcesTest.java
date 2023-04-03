package com.everwin.open.api;/*
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

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.accounts.Account;
import fr.everwin.open.api.model.accounts.AccountList;
import fr.everwin.open.api.model.candidates.Candidate;
import fr.everwin.open.api.model.candidates.CandidateList;
import fr.everwin.open.api.model.candidates.skills.CandidateSkill;
import fr.everwin.open.api.model.candidates.skills.CandidateSkillList;
import fr.everwin.open.api.model.comments.Comment;
import fr.everwin.open.api.model.comments.CommentList;
import fr.everwin.open.api.model.companies.Company;
import fr.everwin.open.api.model.companies.CompanyList;
import fr.everwin.open.api.model.companies.accounts.CompanyAccount;
import fr.everwin.open.api.model.companies.accounts.CompanyAccountList;
import fr.everwin.open.api.model.companies.accounts.acc.AccAccount;
import fr.everwin.open.api.model.companies.accounts.acc.AccAccountList;
import fr.everwin.open.api.model.companies.status.Status;
import fr.everwin.open.api.model.companies.status.StatusList;
import fr.everwin.open.api.model.contacts.ContactResponsibility;
import fr.everwin.open.api.model.contacts.ContactResponsibilityList;
import fr.everwin.open.api.model.contacts.Person;
import fr.everwin.open.api.model.contacts.PersonList;
import fr.everwin.open.api.model.contacts.events.ContactEvent;
import fr.everwin.open.api.model.contacts.events.ContactEventList;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.currencies.Currency;
import fr.everwin.open.api.model.currencies.CurrencyList;
import fr.everwin.open.api.model.currencies.rates.CurrencyRate;
import fr.everwin.open.api.model.currencies.rates.CurrencyRateList;
import fr.everwin.open.api.model.documents.Document;
import fr.everwin.open.api.model.employees.Employee;
import fr.everwin.open.api.model.employees.EmployeeList;
import fr.everwin.open.api.model.employees.skills.EmployeeSkill;
import fr.everwin.open.api.model.employees.skills.EmployeeSkillList;
import fr.everwin.open.api.model.entities.Entity;
import fr.everwin.open.api.model.entities.EntityList;
import fr.everwin.open.api.model.entities.rowtypes.Rowtype;
import fr.everwin.open.api.model.entities.rowtypes.RowtypeList;
import fr.everwin.open.api.model.equipments.Equipment;
import fr.everwin.open.api.model.equipments.EquipmentList;
import fr.everwin.open.api.model.equipments.families.Family;
import fr.everwin.open.api.model.equipments.families.FamilyList;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.leads.state.LeadState;
import fr.everwin.open.api.model.leads.state.LeadStateList;
import fr.everwin.open.api.model.leaverequests.LeaveRequest;
import fr.everwin.open.api.model.leaverequests.LeaveRequestList;
import fr.everwin.open.api.model.leaverequests.types.Type;
import fr.everwin.open.api.model.leaverequests.types.TypeList;
import fr.everwin.open.api.model.missionorders.MissionOrder;
import fr.everwin.open.api.model.missionorders.MissionOrderList;
import fr.everwin.open.api.model.naces.Nace;
import fr.everwin.open.api.model.naces.NaceList;
import fr.everwin.open.api.model.naces.groups.NaceGroup;
import fr.everwin.open.api.model.naces.groups.NaceGroupList;
import fr.everwin.open.api.model.opportunities.Opportunity;
import fr.everwin.open.api.model.opportunities.OpportunityList;
import fr.everwin.open.api.model.products.Product;
import fr.everwin.open.api.model.products.ProductList;
import fr.everwin.open.api.model.products.assets.CustomerAssetList;
import fr.everwin.open.api.model.products.categories.Category;
import fr.everwin.open.api.model.products.categories.CategoryList;
import fr.everwin.open.api.model.profiles.Profile;
import fr.everwin.open.api.model.profiles.ProfileList;
import fr.everwin.open.api.model.projects.Project;
import fr.everwin.open.api.model.projects.ProjectList;
import fr.everwin.open.api.model.projects.phases.ProjectPhase;
import fr.everwin.open.api.model.projects.phases.ProjectPhaseList;
import fr.everwin.open.api.model.projects.phases.categories.ProjectPhaseCategory;
import fr.everwin.open.api.model.projects.phases.categories.ProjectPhaseCategoryList;
import fr.everwin.open.api.model.quotes.crm.lines.CRMQuoteLine;
import fr.everwin.open.api.model.quotes.crm.lines.CRMQuoteLineList;
import fr.everwin.open.api.model.quotes.poa.POAQuote;
import fr.everwin.open.api.model.salesactions.SalesAction;
import fr.everwin.open.api.model.salesactions.SalesActionList;
import fr.everwin.open.api.model.skills.Skill;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.model.skills.skillsdomains.SkillDomain;
import fr.everwin.open.api.model.skills.skillsdomains.SkillDomainList;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevel;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevelList;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoice;
import fr.everwin.open.api.model.supplierinvoices.SupplierInvoiceList;
import fr.everwin.open.api.model.supplierinvoices.lines.SupplierInvoiceLine;
import fr.everwin.open.api.model.supplierinvoices.lines.SupplierInvoiceLineList;
import fr.everwin.open.api.model.supplierorders.lines.SupplierOrderLine;
import fr.everwin.open.api.model.supplierorders.lines.SupplierOrderLineList;
import fr.everwin.open.api.model.supplierreceivingnotes.SupplierReceivingNote;
import fr.everwin.open.api.model.supplierreceivingnotes.SupplierReceivingNoteList;
import fr.everwin.open.api.services.accounts.AccountService;
import fr.everwin.open.api.services.candidates.CandidateSkillsService;
import fr.everwin.open.api.services.candidates.CandidatesService;
import fr.everwin.open.api.services.companies.AccAccountService;
import fr.everwin.open.api.services.companies.CompaniesService;
import fr.everwin.open.api.services.companies.CompanyAccountsService;
import fr.everwin.open.api.services.companies.CompanyStatusService;
import fr.everwin.open.api.services.contacts.ContactEventService;
import fr.everwin.open.api.services.contacts.ContactResponsibilitiesService;
import fr.everwin.open.api.services.contacts.PersonsService;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.currencies.CurrencyRatesService;
import fr.everwin.open.api.services.currencies.CurrencyService;
import fr.everwin.open.api.services.employees.EmployeesService;
import fr.everwin.open.api.services.employees.EmployeesSkillsService;
import fr.everwin.open.api.services.entities.EntitiesService;
import fr.everwin.open.api.services.entities.RowtypeService;
import fr.everwin.open.api.services.equipments.EquipmentsService;
import fr.everwin.open.api.services.equipments.FamilyService;
import fr.everwin.open.api.services.leads.LeadEventService;
import fr.everwin.open.api.services.leads.LeadService;
import fr.everwin.open.api.services.leads.LeadStateService;
import fr.everwin.open.api.services.leaverequests.LeaveRequestsService;
import fr.everwin.open.api.services.leaverequests.TypeService;
import fr.everwin.open.api.services.missionorders.MissionOrderService;
import fr.everwin.open.api.services.naces.NaceGroupService;
import fr.everwin.open.api.services.naces.NaceService;
import fr.everwin.open.api.services.opportunities.OpportunitiesService;
import fr.everwin.open.api.services.products.CategoriesService;
import fr.everwin.open.api.services.products.CustomerAssetsService;
import fr.everwin.open.api.services.products.ProductsService;
import fr.everwin.open.api.services.profiles.ProfilesService;
import fr.everwin.open.api.services.projects.ProjectPhaseCategoryService;
import fr.everwin.open.api.services.projects.ProjectPhaseService;
import fr.everwin.open.api.services.projects.ProjectsService;
import fr.everwin.open.api.services.quotes.crm.CRMQuoteLinesService;
import fr.everwin.open.api.services.quotes.poa.POAQuoteItemService;
import fr.everwin.open.api.services.salesactions.SalesActionsService;
import fr.everwin.open.api.services.skills.SkillDomainsService;
import fr.everwin.open.api.services.skills.SkillLevelsService;
import fr.everwin.open.api.services.skills.SkillsService;
import fr.everwin.open.api.services.supplierinvoices.SupplierInvoiceLineService;
import fr.everwin.open.api.services.supplierinvoices.SupplierInvoiceService;
import fr.everwin.open.api.services.supplierorders.SupplierOrderLineService;
import fr.everwin.open.api.services.supplierreceivingnote.SupplierReceivingNoteService;
import fr.everwin.open.api.services.suppliersettlements.SupplierSettlementLineService;
import fr.everwin.open.api.services.suppliersettlements.SupplierSettlementService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientApiResourcesTest {

    protected ClientApi clientApi;
    protected String uri = "http://localhost:8080/sx/rest";
    protected String version = "v2";

    @BeforeTest
    public void setUp(){
        try {
            clientApi = new ClientApi(uri, version);

            clientApi.setApiKey("");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Test(priority = 1)
    public void testAccAccount() {
        try {
            AccAccountService service = new AccAccountService(clientApi);
            AccAccountList list = service.query();
            AccAccount accAccount = list.getItems().get(0);

            service.get(accAccount.getId());
            testUpdate(service, list);

        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testAccount() {
        try {
            AccountService service = new AccountService(clientApi);
            AccountList list = service.query();
            Account account = list.getItems().get(0);

            service.get(account.getId());
            service.queryExpSheetAccounts(null);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCandidates() {
        try {
            CandidatesService service = new CandidatesService(clientApi);
            CandidateList list = service.query();
            Candidate candidate = list.getItems().get(0);

            service.get(candidate.getId());

            service.querySkillsFromCandidates(candidate,null);
            testComment(service, candidate);
            testDocument(service, candidate);

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
            CandidateSkill candidateSkill = list.getItems().get(0);

            service.get(candidateSkill.getId());
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
            CompanyList list = service.queryCustomers(null);
            Company company = list.getItems().get(0);

            service.get(company.getId());
            service.queryCustomers(null);
            service.querySuppliers(null);
            service.queryAccFromCompany(company, null);
            service.queryCustomersAccFromCompany(company, null);
            service.querySuppliersAccFromCompany(company, null);
            service.queryCustomersAssetsFromCompany(company, null);

            //service.queryResponsabilitiesFromCompany(company, null);
            service.querySAForCompany(company, null);
            service.queryProjectsFromCompany(company, null);
            //service.queryLeadsFromCompany(company, null);
            service.queryContactsFromCompany(company, null);
            service.queryOpportunitiesFromCompany(company, null);

            testComment(service, company);
            testDocument(service, company);
            testUpdate(service, list);
        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCompanyAccounts(){
        try {
            CompanyAccountsService service = new CompanyAccountsService(clientApi);
            CompanyAccountList list = service.query();
            CompanyAccount companyAcc = list.getItems().get(0);

            service.get(companyAcc.getId());
            service.queryCustomers(null);
            service.querySuppliers(null);
            //testUpdate(service, list);
        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCompanyActivity(){
        try {
            NaceService service = new NaceService(clientApi);
            NaceList list = service.query();
            Nace nace = list.getItems().get(0);

            service.get(nace.getId());
        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCompanyActivityGroup(){
        try {
            NaceGroupService service = new NaceGroupService(clientApi);
            NaceGroupList list = service.query();
            NaceGroup nace = list.getItems().get(0);

            service.get(nace.getId());
        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCompanyStatus(){
        try {
            CompanyStatusService service = new CompanyStatusService(clientApi);
            StatusList list = service.query();
            Status status = list.getItems().get(0);

            service.get(status.getId());
            service.querySuppliers(null);
            service.queryCustomers(null);
            //service.queryDefaultSupplier(null);
            //service.queryDefaultCustomer(null);
        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testResponsabilities() {
        try {
            ContactResponsibilitiesService service = new ContactResponsibilitiesService(clientApi);
            ContactResponsibilityList list = service.query();
            ContactResponsibility contactResponsibility = list.getItems().get(0);

            ContactEventService Eservice = new ContactEventService(clientApi);
            ContactEventList Elist = Eservice.query();
            ContactEvent event = Elist.getItems().get(0);

            //service.queryEventFromResponsibility(contactResponsibility, event, null);
            service.queryEventsFromResponsibility(contactResponsibility, null);
            service.get(contactResponsibility.getId());

            testComment(service, contactResponsibility);
            testDocument(service, contactResponsibility);
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    //confighper

    @Test(priority = 1)
    public void testEvent() {
        try {
            ContactEventService service = new ContactEventService(clientApi);
            ContactEventList list = service.query();
            ContactEvent event = list.getItems().get(0);

            service.get(event.getId());
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testContact() {
        try {
            PersonsService service = new PersonsService(clientApi);
            PersonList list = service.query();
            Person person = list.getItems().get(0);

            service.get(person.getId());
            //service.querySAForContact(person, null);
            //service.queryLeadsFromContact(person, null);
            service.queryResponsabilitiesFromPerson(person, null);

            testComment(service, person);
            testDocument(service, person);
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCountries() {
        try {
//            CountryService service = new CountryService(clientApi);
//            CountryList list = service.query();
//            Country country = list.getItems().get(0);
//
//            service.get(country.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCRMQuoteLine() {
        try {
            CRMQuoteLinesService service = new CRMQuoteLinesService(clientApi);
            CRMQuoteLineList list = service.query();
            CRMQuoteLine crmQuoteLine = list.getItems().get(0);

            service.get(crmQuoteLine.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCRMQuote() {
        try {
//            CRMQuotesService service = new CRMQuotesService(clientApi);
//            CRMQuoteList list = service.query();
//            CRMQuote crmQuote = list.getItems().get(0);
//
//            service.get(crmQuote.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCurrencies() {
        try {
//            CurrencyService service = new CurrencyService(clientApi);
//            CurrencyList list = service.query();
//            Currency currency = list.getItems().get(0);
//            EntitiesService Eservice = new EntitiesService(clientApi);
//            EntityList Elist = Eservice.query();
//            Entity entity = Elist.getItems().get(0);
//
//            service.get(currency.getId());
//            service.queryEntity(entity, null);
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testCurrenciesRates() {
        try {
            CurrencyRatesService service = new CurrencyRatesService(clientApi);
            CurrencyRateList list = service.query();
            CurrencyRate currencyRate = list.getItems().get(0);

            /*EntitiesService Eservice = new EntitiesService(clientApi);
            EntityList Elist = Eservice.query();
            Entity entity = Elist.getItems().get(0);

            CurrencyService Cservice = new CurrencyService(clientApi);
            CurrencyList Clist = Cservice.query();
            Currency currency = Clist.getItems().get(0);*/

            service.get(currencyRate.getId());
            //testUpdate(service, list);
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
            //CustomerAsset customerAsset = list.getItems().get(0);

            //service.get(customerAsset.getId());
            //testUpdate(service, list);
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
            Employee employee = list.getItems().get(0);

            employee.setLoginMode("sx");
            service.queryVehicle(employee, null);
            service.queryLRType(employee, null);
            service.queryCommercial(null);
            service.queryManager(null);
            service.queryProjectDirector(null);
            service.queryProjectManager(null);

            testComment(service, employee);
            testDocument(service, employee);
            //service.queryLeadsFromEmployee(employee,null);
            service.querySkillsFromEmployee(employee, null);

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
            EmployeeSkill employeeSkill = list.getItems().get(0);

            EmployeesService Eservice = new EmployeesService(clientApi);
            EmployeeList Elist = Eservice.query();
            Employee employee = Elist.getItems().get(0);

            service.get(employeeSkill.getId());
            //service.querySkillsFromEmployee(employee, null);
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
            Entity entity = list.getItems().get(0);


            CurrencyService Cservice = new CurrencyService(clientApi);
            CurrencyList Clist = Cservice.query();
            Currency currency = Clist.getItems().get(0);

            service.get(entity.getId());
            service.queryFinancial(null);
            service.queryOperational(null);
            service.queryFinancialLast(null);
            service.queryOperationalLast(null);
            service.queryCurrencyRateFromEntityAndCurrency(entity, currency, null);
            service.queryCurrencyRateFromEntity(entity,null);
            service.queryCurrencyFromEntity(entity, null);
            service.queryRowTypeFromEntity(entity, null);
            service.queryAccountFromEntity(entity, null);
            service.queryAccountFromEntityForExpenseSheet(entity, null);

        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testEquipment() {
        try {
            EquipmentsService service = new EquipmentsService(clientApi);
            EquipmentList list = service.query();
            Equipment equipment = list.getItems().get(0);

            service.get(equipment.getId());
            testDocument(service, equipment);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testExpenseSheetLines() {
        try {
//            ExpenseSheetLineService service = new ExpenseSheetLineService(clientApi);
//            ExpenseSheetLineList list = service.query();
//            ExpenseSheetLine expenseSheetLine = list.getItems().get(0);
//
//            ExpenseSheetService ESservice = new ExpenseSheetService(clientApi);
//            ExpenseSheetList ESlist = ESservice.query();
//            ExpenseSheet expenseSheet = ESlist.getItems().get(0);
//
//            service.get(expenseSheetLine.getId());
//            service.queryLinesFromExpenseSheet(expenseSheet, null);
//            service.queryLinebyId(expenseSheet, expenseSheetLine, null);
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testExpenseSheet() {
        try {
//            ExpenseSheetService service = new ExpenseSheetService(clientApi);
//            ExpenseSheetList list = service.query();
//            ExpenseSheet expenseSheet = list.getItems().get(0);
//
//            service.get(expenseSheet.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testFamilies() {
        try {
            FamilyService service = new FamilyService(clientApi);
            FamilyList list = service.query();
            Family family = list.getItems().get(0);

            service.get(family.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testGeographicalAreas() {
        try {
//            GeographicalAreaService service = new GeographicalAreaService(clientApi);
//            GeographicalAreaList list = service.query();
//            GeographicalArea family = list.getItems().get(0);
//
//            service.get(family.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testGuests() {
        try {
//            GuestService service = new GuestService(clientApi);
//            GuestList list = service.query();
//            Guest guest = list.getItems().get(0);
//
//            ExpenseLineService ESLservice = new ExpenseSheetLineService(clientApi);
//            ExpenseLineList ESLlist = ESLservice.query();
//            ExpenseLine line = ESLlist.getItems().get(0);
//
//            service.get(guest.getId());
//            service.queryGuestFromLine(line, null);
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testLeadEvents() {
        try {
//            LeadEventService service = new LeadEventService(clientApi);
//            LeadEventList list = service.query();
//            LeadEvent leadEvent = list.getItems().get(0);
//
//            service.get(leadEvent.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testLeads() {
        try {
            LeadService service = new LeadService(clientApi);
            LeadList list = service.query();
            //Lead lead= list.getItems().get(0);

            //service.queryLeadEvents(lead, null);

            LeadEventService LEservice = new LeadEventService(clientApi);
            //LeadEventList LElist = LEservice.query();
            //LeadEvent leadEvent = LElist.getItems().get(0);
            //service.queryLeadEventById(lead, leadEvent, null);

            //service.get(lead.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testLeadSource() {
        try {
//            LeadSourceService service = new LeadSourceService(clientApi);
//            LeadSourceList list = service.query();
//            LeadSource leadSource = list.getItems().get(0);
//
//            service.get(leadSource.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testLeadState() {
        try {
            LeadStateService service = new LeadStateService(clientApi);
            LeadStateList list = service.query();
            LeadState leadState = list.getItems().get(0);

            service.get(leadState.getId());
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
            LeaveRequest leaveRequest = list.getItems().get(0);

            testDocument(service, leaveRequest);
            service.get(leaveRequest.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testLeaveRequestType() {
        try {
            TypeService service = new TypeService(clientApi);
            TypeList list = service.query();
            Type type = list.getItems().get(0);

            service.get(type.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testMissionOrder() {
        try {
            MissionOrderService service = new MissionOrderService(clientApi);
            MissionOrderList list = service.query();
            MissionOrder missionOrder = list.getItems().get(0);

            service.get(missionOrder.getId());
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
            Opportunity opportunity = list.getItems().get(0);

            testComment(service, opportunity);
            testDocument(service, opportunity);
            service.querySAForOpportinity(opportunity, null);
            //service.queryLeadsFromOpportunity(opportunity, null);
            service.get(opportunity.getId());
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testPOAQuoteItems() {
        try {
            POAQuoteItemService service = new POAQuoteItemService(clientApi);
            //POAQuoteItemList list = service.query();
            //POAQuoteItem poaQuoteItem = list.getItems().get(0);

//            POAQuoteService PQservice = new POAQuoteService(clientApi);
//            POAQuoteList PQlist = PQservice.query();
//            POAQuote poaQuote = PQlist.getItems().get(0);
//            service.updatePOAQuote(poaQuote.getId(), poaQuoteItem);

            //service.get(poaQuoteItem.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

   @Test(priority = 1)
    public void testPOAQuoteLine() {
        try {
//            POAQuoteLineService service = new POAQuoteLineService(clientApi);
//            POAQuoteLineList list = service.query();
//            POAQuoteLine poaQuoteLine = list.getItems().get(0);
//
//
//            service.get(poaQuoteLine.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testPOAQuote() {
        try {
//            POAQuoteService service = new POAQuoteService(clientApi);
//            POAQuoteList list = service.query();
//            POAQuote poaQuote = list.getItems().get(0);
//
//            service.get(poaQuote.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testPOAQuoteSubItem() {
        try {
//            POAQuoteSubItemService service = new POAQuoteSubItemService(clientApi);
//            POAQuoteSubItemList list = service.query();
//            POAQuote poaQuoteSubItem = list.getItems().get(0);
//
//            service.get(poaQuoteSubItem.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProductCategories() {
        try {
            CategoriesService service = new CategoriesService(clientApi);
            CategoryList list = service.query();
            Category category = list.getItems().get(0);

            service.get(category.getId());
            testUpdate(service, list);
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
            Product product = list.getItems().get(0);

            service.get(product.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProfiles() {
        try {
            ProfilesService service = new ProfilesService(clientApi);
            ProfileList list = service.query();
            Profile profile = list.getItems().get(0);

            service.get(profile.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectActivityCategory() {
        try {
//            ProjectActivityCategoryService service = new ProjectActivityCategoryService(clientApi);
//            ProjectActivityCategoryList list = service.query();
//            ProjectActivityCategory category = list.getItems().get(0);
//
//            service.get(category.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectActivity() {
        try {
//            ProjectActivityService service = new ProjectActivityService(clientApi);
//            ProjectActivityList list = service.query();
//            ProjectActivity activity = list.getItems().get(0);
//
//            service.renew(activity);
//            service.renewFrom(activity.getId(), activity);
//            service.get(activity.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectLines() {
        try {
//            ProjectLinesService service = new ProjectLinesService(clientApi);
//            ProjectLineList list = service.query();
//            ProjectLine projectLine = list.getItems().get(0);
//
//            service.get(projectLine.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectSubCategory() {
        try {
//            ProjectSubCategoryService service = new ProjectSubCategoryService(clientApi);
//            ProjectSubCategoryList list = service.query();
//            ProjectSubCategory projectSubCategory = list.getItems().get(0);
//
//            service.get(projectLine.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectCategory() {
        try {
//            ProjectCategoryService service = new ProjectCategoryService(clientApi);
//            ProjectCategoryList list = service.query();
//            ProjectCategory projectCategory = list.getItems().get(0);
//
//            service.get(projectCategory.getId());
//            service.querySubCategory(projectCategory, null)
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }












    @Test(priority = 1)
    public void testProjectPhaseCategory() {
        try {
            ProjectPhaseCategoryService service = new ProjectPhaseCategoryService(clientApi);
            ProjectPhaseCategoryList list = service.query();
            ProjectPhaseCategory phase = list.getItems().get(0);

            service.get(phase.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectPhase() {
        try {
            ProjectPhaseService service = new ProjectPhaseService(clientApi);
            ProjectPhaseList list = service.query();
            ProjectPhase phase = list.getItems().get(0);

            //service.get(1177);
            //testUpdate(service, list);
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
            Project project = list.getItems().get(0);

            service.get(project.getId());
            testComment(service, project);
            testDocument(service, project);
            service.queryCustomersAssetsFromProject(project, null);
            testUpdate(service, list);

            POAQuote poaQuote = new POAQuote();
            poaQuote.setNotes("Text");

            //service.createPOAQuoteFromLineId(project, poaQuote);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testProjectsSubCategory() {
        try {
//            ProjectSubCategoryService project = new ProjectSubCategoryService(clientApi);
//            ProjectSubCategoryList list = service.query();
//            ProjectSubCategory category = list.getItems().get(0);
//
//            service.get(category.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testRowType() {
        try {
            RowtypeService service = new RowtypeService(clientApi);
            RowtypeList list = service.query();
            Rowtype rowtype = list.getItems().get(0);

            service.queryExternal(null);
            service.queryInternal(null);
            service.queryInternalActivities(null);
            service.get(rowtype.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }


    @Test(priority = 1)
    public void testSalesActions() {
        try {
            SalesActionsService service = new SalesActionsService(clientApi);
            SalesActionList list = service.query();
            SalesAction salesAction = list.getItems().get(0);

            //service.queryLeadsFromSalesAction(salesAction, null);
            testComment(service, salesAction);
            testDocument(service, salesAction);
            service.get(salesAction.getId());
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testScales() {
        try {
//            ScaleService service = new ScaleService(clientApi);
//            ScaleList list = service.query();
//            Scale scale = list.getItems().get(0);
//
//            service.get(scale.getId());
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
            SkillDomain skillDomain = list.getItems().get(0);

            service.querySkillsFromSD(skillDomain, null);
            service.querySLFromSD(skillDomain, null);
            service.querySkillsLevelsFromSD(skillDomain, null);
            service.get(skillDomain.getId());
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
            SkillLevel skillLevel = list.getItems().get(0);

            service.get(skillLevel.getId());
            testUpdate(service, list);
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
            Skill skill = list.getItems().get(0);

            //service.querySLFromSkill(skill, null);
            service.get(skill.getId());
            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierDeliveries() {
        try {
//            SupplierDeliveriesService service = new SupplierDeliveriesService(clientApi);
//            SupplierDeliveriesList list = service.query();
//            SupplierDelivery supplierDelivery = list.getItems().get(0);
//
//            service.get(supplierDelivery.getId());
//            testUpdate(service, list);
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
            SupplierInvoiceLine supplierInvoiceLine = list.getItems().get(0);

            service.get(supplierInvoiceLine.getId());
            //testUpdate(service, list);
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
            SupplierInvoice supplierInvoice = list.getItems().get(0);

            testDocument(service, supplierInvoice);
            service.get(supplierInvoice.getId());
            //testUpdate(service, list);
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
            SupplierOrderLine supplierOrderLine = list.getItems().get(0);

            service.get(supplierOrderLine.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierOrders() {
        try {
//            SupplierOrderService service = new SupplierOrderService(clientApi);
//            SupplierOrderList list = service.query();
//            SupplierOrder supplierOrder = list.getItems().get(0);
//
//            testDocument(service, supplierOrder);;
//            service.get(supplierOrder.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierReceivingNoteLine() {
        try {
//            SupplierReceivingNoteLineService service = new SupplierReceivingNoteLineService(clientApi);
//            SupplierReceivingNoteLineList list = service.query();
//            SupplierReceivingNoteLine supplierReceivingNoteLine = list.getItems().get(0);
//
//            service.get(supplierReceivingNoteLine.getId());
//            testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierReceivingNote() {
        try {
            SupplierReceivingNoteService service = new SupplierReceivingNoteService(clientApi);
            SupplierReceivingNoteList list = service.query();
            SupplierReceivingNote supplierReceivingNote = list.getItems().get(0);

            service.get(supplierReceivingNote.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierSettlement() {
        try {
            SupplierSettlementService service = new SupplierSettlementService(clientApi);
            //SupplierSettlementList list = service.query();
            //SupplierSettlement supplierDelivery = list.getItems().get(0);

            //service.get(supplierDelivery.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSupplierSettlementLines() {
        try {
            String string = "21/04/1978";

            DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyyy");

                LocalDate date = LocalDate.parse(string, format);

            SupplierSettlementLineService service = new SupplierSettlementLineService(clientApi);
            //SupplierSettlementLineList list = service.query();
            //SupplierSettlementLine line = list.getItems().get(0);

            //service.get(line.getId());
            //testUpdate(service, list);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testSystemService() {
        try {
            CompanyStatusService service = new CompanyStatusService(clientApi);
            StatusList list = service.query();
            Status status = list.getItems().get(0);

            service.queryCustomers(null);
            service.querySuppliers(null);
            //service.queryDefaultSupplier(null);
            //service.queryDefaultCustomer(null);
            service.get(status.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testVehicle() {
        try {
//            VehiclesService service = new VehiclesService(clientApi);
//            VehicleList list = service.query();
//            Vehicle vehicle = list.getItems().get(0);
//
//            service.get(vehicle.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testWorkUnits() {
        try {
//            WorkUnitService service = new WorkUnitService(clientApi);
//            WorkUnitList list = service.query();
//            WorkUnit workunit = list.getItems().get(0);
//            service.get(workunit.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    public void testUpdate(BasicService service, BasicList list) throws Exception {
        BasicObject object = (BasicObject)list.getItems().get(0);
        service.update(object);
        service.updatePartially(object);
    }

    public void testComment(BasicService service, BasicObject object) {
        try {

            CommentList before = service.queryComments(object.getId(), null);


            Comment comment = new Comment();
            short i = 1;
            comment.setMode(i);
            comment.setText("Text");

            long id = 999;
            comment.setId(id);


            service.createComment(object.getId(), comment);


            CommentList after = service.queryComments(object.getId(), null);


            service.getComment(object.getId(), comment.getId());
            //service.updateComment(object.getId(), comment); // "resource" parameter is null.
            //service.updatePartiallyComment(object.getId(), comment); // The resource you are trying to update does not exist in the database
            service.deleteComment(object.getId(), comment.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    public void testDocument(BasicService service, BasicObject object) throws Exception {
        try {

            service.queryDocument(object.getId(), null);
            Document document = new Document();
            short i = 1;
            //document.setComment("Text");
            document.setTitle("Text");
            document.setNature(i);
            document.setLink("link");
            //document.setViewingLevel(i);
            long docHry = 118829;
            //document.setThesaurus(new DataLink(docHry, ""));
            long id = 999;
            //document.setId(id);
            System.out.println(document.getId());

            service.createDocument(object.getId(), document); // Erreur d'intégrité, [29001]Lien non valide
            //service.updateDocument(object.getId(), comment);
            //service.updatePartiallyDocument(object.getId(), comment);
            //service.queryDocuments(object.getId(), null);
            //service.deleteDocument(object.getId(), document.getId());

        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }
}
