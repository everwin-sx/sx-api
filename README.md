# SX-API
<img src='https://www.everwin.fr/images/logo-Rest-API.png' width='200px'>

![SX](https://img.shields.io/badge/compatible-SX-orange.svg) ![CXM](https://img.shields.io/badge/compatible-CXM-a00d59.svg) ![Version](https://img.shields.io/badge/compatible-APIv2-green.svg) ![License](https://img.shields.io/hexpm/l/plug.svg)

SX/CXM API wrapper in Java.
This Java library implements the complete functionality of the SX and CXM API.
More informations about our products on https://www.everwin.fr.

## Installation
Jar files are available from Maven Central. To use sx-api you have to include it in your project dependencies :
```xml 
<dependency>
  <groupId>fr.everwin.open.api</groupId>
  <artifactId>sx-api</artifactId>
  <version>0.1.4</version>
</dependency>
```

## Authentication
The SX API wrapper supports authentication using either OAuth or an API key.

### Authentication with API key
The API key can be found in your SX application in the administration console. 
Then you can use the API key with an instance of the ClientApi class :
```java
// Create the API client with the main uri and the version of the API
ClientApi clientApi = new ClientApi("http://example.com/sx/rest", "v2");
// Set the api key
clientApi.setApiKey("your api key");
```

### Authentication with OAuth
To authenticate throught OAuth, you have to create OAuth informations in your SX application in the 
administration console. Then with the generated clientId and the clientSecret you can access to the API :
```java
// Create the API client with the main uri and the version of the API
ClientApi clientApi = new ClientApi("http://example.com/sx/rest", "v2");
// Set the oauth informations
clientApi.setAuthInfos("your client id", "your client secret");
```

## Examples
### Get a companies collection
To load a collection of objects, instanciate the appropriate service and call one of the get() method. For companies the CompaniesService has a getCompanies() method to get a collection of companies : 
```java
try {
    CompaniesService companyService = new CompaniesService(clientApi);
    CompanyList list = companyService.query();
    Company company = list.getItems().get(0);
} catch (Exception e) {
    e.printStackTrace(System.err);
}
```

### Query companies
To filter a collections of objects, you have to use a RequestParams object which can make sort, filter, multipage query.
 
```java
try {
    CompaniesService companyService = new CompaniesService(clientApi);
    CompanyList companyList = companyService.query(new RequestParams.Builder()
                                .sort("code")
                                .filter(new Filter.Builder()
                                        .like("code", "TEST")
                                        .build()
                                        .generate())
                                .offset(0)
                                .limit(100)
                                .build());
} catch (Exception e) {
    e.printStackTrace(System.err);
}
```

### Get comments collection
To load a collection of comments linked to an object, call queryComments() method on the object service. Create / update and delete methods are available too : 
```java
try {
    // Instanciate comment
    Comment comment = new Comment();
    comment.setMode(1);
    comment.setText("Text");

    // Find a company
    CompaniesService companiesService = new CompaniesService(clientApi);
    Company company = companiesService.queryCustomers(null).getItems().get(0);
    
    // Add the comment to the company
    companiesService.createComment(company.getId(),comment);
    
    // Get comments of the company
    CommentList commentList = companiesService.queryComments(company.getId(), null);
} catch (Exception e) {
    e.printStackTrace(System.err);
}

## Reference

Resource                             | Classes
--------------------                 |-------------
/xxx/{xid}/comments                  | Comment
  -    -      -    /                 |Get a comment collection for the current object (GET)
  -    -      -    /                 |Create a comment for the current object (POST)
  -    -      -    /{cid}            |Full update of a comment (PUT)
  -    -      -    /{cid}            |Partial update of a comment (POST)
  -    -      -    /{cid}            |Delete a comment (DELETE)
/xxx/{xid}/documents                 | Document
  -    -      -     /                |Get a document collection or the current object (GET)
  -    -      -     /{id}            |Get a document for the current object (GET)
  -    -      -     /                |Create a new document (POST)
  -    -      -     /{id}            |Partial update of a document (POST)
  -    -      -     /{id}            |Full update of a document. If document doesn't exist, it's created (PUT)
  -    -      -     /{id}            |Delete a document (DELETE)
  -    -      -     /{id}/upload     |Upload physical file linked to document (POST)
  -    -      -     /{id}/download   |Get physical file linked to the document (GET)
/acc-accounts                        | AccAccountService, AccAccount
/accounts                            | AccountService, Account
/candidates                          | CandidatesService, Candidate
    -    /{id}/comments              |
    -    /{id}/skills                |Get the collection of skills for the candidate (GET)
/candidate-skills                    | CandidateSkillsService, CandidateSkill
/companies                           | CompaniesService, Company
    -    /{id}/documents             |
    -    /{id}/comments              |
    -    /{id}/sales-actions         |Get a collection of sales actions for company (GET)
    -    /{id}/projects              |Get a collection of projects for company (GET)
    -    /{id}/leads                 |Get a collection of leads for company (GET)
    -    /{id}/customer-assets       |Get a collection of customer assets for company (GET)
    -    /{id}/company-accounts      |Get a collection of company accounts linked to the company (GET)
    -    /{id}/opportunities         |Get a collection of opportunities for company (GET)
    -    /{id}/contacts              |Get a collection of contacts for company (GET)
    - /{id}/contact-responsibilities |Get a collection of responsibilities for company
  - /{id}/company-accounts/customers |Get a collection of company customer accounts linked to the company (GET)
  - /{id}/company-accounts/suppliers |Get a collection of company supplier accounts linked to the company (GET)
/company-accounts                    | CompanyAccountsService, CompanyAccount
/company-activities                  | NaceService, Nace
/company-activity-groups             | NaceGroupService, NaceGroup
/company-status                      | CompanyStatusService, CompanyStatus
/contact-responsibilities            | ContactResponsabilitiesService, ContactResponsability
    -    /{id}/documents             |
    -    /{id}/comments              |
/contact-events                      | ContactEventService, ContactEvent
/contacts                            | PersonsService, Person
    -    /{id}/documents             |
    -    /{id}/comments              |
    -    /{id}/sales-action          |Get the collection of sales actions for contact (GET)
    -    /{id}/leads                 |Get the collection of leads for contact (GET)
    -    /{id}/responsibilities      |Get the collection of responsibilities for contact (GET)
/countries                           | CountryService, Country
/crm-quotelines                      | CRMQuoteLinesService, CRMQuoteLine
/crm-quotes                          | CRMQuotesService, CRMQuote
/currencies                          | CurrencyService, Currency
/currency-rates                      | CurrencyRatesService, CurrencyRate
/customer-assets                     | CustomerAssetsService, CustomerAsset
/employees                           | EmployeesService, Employee
    -    /{id}/documents             |
    -    /{id}/comments              |
    -    /{id}/vehicles              |Get a collection of vehicles for employee (GET)
    -    /{id}/leads	             |Get the collection of leads for employee (GET)
    -    /{id}/skills                |Get the collection of emplooyee skills for employee (GET)
    -    /{id}/leave-request-types   |Get a collection of leave request type for employee (GET)
/employees/{id}/vehicle              | EmployeesService, Vehicle
/employee-skills                     | EmployeeSkillsService,EmployeeSkill
/entities                            | EntitiesService, Entity
    -    /{id}/currencies            |Get a collection of currencies for entity (GET)
    -    /{id}/rowtypes              |Get a collection of rowtypes for entity (GET)
    -    /{id}/currency-rates        |Get currency rate for entity (GET)
    -    /{id}/currencies/{cid}/rates|Get currency rate for entity and currency (GET)
    -    /{id}/accounts	             |Get a account collection for entity (GET)
    -    /{id}/accounts/expense-sheet|Get a account collection for expense sheet of entity (GET)
/equipments                          | EquipmentsService, Equipment
    -    /{id}/documents             |
/families                            | FamilyService, Family
/expense-sheet-lines                 | ExpenseSheetLineService, ExpenseSheetLine
/expense-sheet                       | ExpenseSheetService, ExpenseSheet
/geographical-areas                  | GeographicalAreaService, GeographicArea
/guests                              | GuestService, Guest
/expense-lines/{id}/guests           |Get a guests collection of the expense line idenfied by the id (GET)
/leads-events                        | LeadEventService, LeadEvent
/leads                               | LeadService, Lead
    -    /{id}/lead-events	         |Get a collection of lead events for the lead
    -    /{id}/lead-events/{eid}	 |Get a contact event for lead and lead event
/leads-sources                       | LeadSourceService, LeadSource
/leads-state                         | LeadStateService, LeadState
/leave-request-type                  | LeaveRequestTypeService, LeaveRequestType
/leave-requests                      | LeaverequestService, Leaverequest
    -    /{id}/documents             |
/mission-orders                      | MissionOrderService, MissionOrder
    -    /{id}/documents             |
/opportunities                       | OpportunitiesService, Opportunity
    -    /{id}/documents             |
    -    /{id}/comments              |
    -    /{id}/sales-actions         |Get a collection of sales actions for opportunity (GET)
    -    /{id}/leads                 |Get a collection of leads for opportunity (GET)
/poa-items                           | POAQuoteItemService, POAQuoteItem
/poa-quotelines                      | ???
/poa-quote-subitems                  | ???
/poa-quote                           | POAQuoteService, POAQuote
/product-categories                  | CategoriesService, Category
/products                            | ProductsService, Product
/profiles                            | ProfilesService, Profile
/project-activities                  | ProjectActivitiesService, ProjectActivity
    -    /{id}/line/{lid}/renew      |Renew an activity in the same activity (GET)
    -    /{id}/renew                 |Renew an activity in a new one (GET)
/project-activities                  | ProjectActivitiesService, ProjectActivity
/project-activity-category           | ProjectActivityCategoryService, ProjectActivityCategory
/project-categories                  |ProjectCategoryService, ProjectCategory
/project-sub-category                |ProjectSubCategoryService, ProjectSubCategory
/project-phases                      | ProjectPhaseService, ProjectPhase
/project-phases-category             | ProjectPhaseCategoryService, ProjectPhaseCategory
/project-lines                       | ProjectLinesService, ProjectLine
/projects                            | ProjectsService, Project
    -    /{id}/documents             |
    -    /{id}/comments              |
    -    /{id}/customer-assets       |Get a collection of customer assets for the given project id (GET)
/rowtypes                            | EntitiesRowTypesService, Rowtypes
/sales-actions                       | SalesActionsService, SalesActionsService
    -    /{id}/documents             |
    -    /{id}/comments              |
    -    /{id}/leads	             |Get the collection of leads for employee (GET)
/scales                              | ScaleService, Scale
/skill-domains                       | SkillDomainsService, SkillDomain
    -    /{id}/skills                |Get the collection of skills from the skill domain (GET)
    -    /{id}/skill-levels          |Get the collection of skill levels from the skill domain (GET) 
/skill-levels                        | SkillLevelsService, SkillLevel
/skills                              | SkillsService, Skill
/supplier-deliveries                 | ???
/supplier-delivery-lines             | ???
/supplier-invoice-lines              | SupplierInvoiceLineService, SupplierInvoiceLine
/supplier-invoices                   | SupplierInvoiceService, SupplierInvoice
    -    /{id}/documents             |
/supplier-order-lines                | SupplierOrderLineService, SupplierOrderLine
/supplier-orders                     | SupplierOrderService, SupplierOrder
    -    /{id}/documents             |
/supplier-receiving-note-lines       | SupplierReceivingNoteLineService, SupplierReceivingNoteLine
/supplier-receiving-notes            | SupplierReceivingNoteService, SupplierReceivingNote
/supplier-settlement-lines           | SuppliersettlementLineService, SupplierSettlementLine
/supplier-settlements                | SuppliersettlementService, SupplierSettlement
/vehicles                            | VehicleService, Vehicle
/work-units                          | WorkUnitService, WorkUnit

 
