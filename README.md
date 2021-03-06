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

Resource                    | Classes
--------------------        |-------------
/candidates                 |CandidatesService, Candidate
/candidate-skills           |CandidateSkillsService, CandidateSkill
/companies                  |CompaniesService, Company
/company-apes               |NafsService, Naf
/acc-accounts               |CompanyAccAccountsService, AccAccount
/crm-quotes                 |CRMQuotesService, CRMQuote
/crm-quotelines             |CRMQuoteLinesService, CRMQuoteLine
/company-accounts           |CompanyAccountsService, CompanyAccount
/company-statuts            |CompanyStatusService, Status
/contact-responsibilities   |ContactResponsabilitiesService, ContactResponsability
/contacts                   |PersonsService, Person
/currency-rates             |CurrencyRatesService, CurrencyRate
/customer-assets            |CustomerAssetsService, CustomerAsset
/employees                  |EmployeesService, Employee
/employee-skills            |EmployeeSkillsService,EmployeeSkill
/entities                   |EntitiesService, Entity
/equipments                 |EquipmentsService, Equipment
/leave-requests             |LeaveRequestsService, LeaveRequest
/opportunities              |OpportunitiesService, Opportunity
/products                   |ProductsService, Product
/product-categories         |CategoriesService, Category
/projects                   |ProjectsService, Project
/project-lines              |ProjectLinesService, ProjectLine
/profiles                   |ProfilesService, Profile
/sales-actions              |SalesActionsService, SalesActionsService
/skills                     |SkillsService, Skill
/skill-levels               |SkillLevelsService, SkillLevel
/skill-domains              |SkillDomainsService, SkillDomain
/supplier-invoices          |SupplierInvoicesService, SupplierInvoice
/supplier-invoice-lines     |SupplierInvoiceLinesService, SupplierInvoiceLine
/supplier-orders            |SupplierOrdersService, SupplierOrder
/supplier-order-lines       |SupplierOrderLinesService, SupplierOrderLine

 
