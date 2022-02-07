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


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.comments.Comment;
import fr.everwin.open.api.model.comments.CommentList;
import fr.everwin.open.api.model.companies.Company;
import fr.everwin.open.api.model.companies.CompanyList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.companies.CompaniesService;
import fr.everwin.open.api.util.Filter;
import fr.everwin.open.api.util.RequestParams;

public class ClientAuthTest {

    protected ClientApi clientApi;

    //protected String uri = "https://mars2:12443/sx/rest";
    protected String uri = "http://localhost:8080/sx/rest";
    protected String version = "v2";

    @BeforeTest
    public void setUp(){
        try {
            clientApi = new ClientApi(uri, version);
            clientApi.setApiKey("a5a4394a53472c441fd6ed714e70f500");
            //a5a4394a53472c441fd6ed714e70f500
            //bae02a79bf9884cff23a327a00fd86c6
            //clientApi.setAuthInfos("36103e9e671e0806c354f5a289070bfb", "5d1d6d3c7d7950fdbfb4167b6936757f");
            // GBB : ybBvdfA1KnIEB1v7Rd/+2+yzvCI2PpruDZJJeNJ7pOpZQIZhPfDIHg==
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Test(priority = 1)
    public void testList(){
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList list = companyService.query();
            Assert.assertTrue(list.getItems().size() > 0);

        }catch(Exception e){
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 1)
    public void testLink() {
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList list = companyService.query();
            Company company = list.getItems().get(0);
            DataLink dataLink = company.getGroup();
            if (dataLink != null) {
                Company group = companyService.get(dataLink.getHref());
                Assert.assertNotNull(group);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 2)
    public void testDelete() {
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList list = companyService.query();
            Company company = list.getItems().get(0);
            companyService.delete(253744);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 2)
    public void testGetNotExist() {
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            Company company = companyService.get(-1);
            Assert.fail("Company not exist !");
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

    }

    @Test(priority = 2)
    public void testQuery() {
        try {

            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList companyList = companyService.query(new RequestParams.Builder()
                            .sort("code")
                            .filter(new Filter.Builder()
                                    .like("code", "TEST")
                                    .or()
                                    .like("name", "TEST")
                                    .build()
                                    .generate())
                            .offset(0)
                            .limit(100)
                            .build());
            Assert.assertEquals(companyList.getItems().size(), 100);

        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }

    }

    @Test(priority = 2)
    public void testMultiPage() {
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList list = companyService.query(new RequestParams.Builder()
                                                    .offset(0)
                                                    .limit(50)
                                                    .build());
            String nextPage = list.getNext();
            Assert.assertEquals(nextPage, uri + "/" + version + "/companies?filter=&sort=&offset=50&limit=50&fields=");
            // Go to next page
            list = companyService.query(nextPage);
            String prevPage = list.getPrevious();
            Assert.assertEquals(prevPage, uri + "/" + version + "/companies?filter=&sort=&offset=0&limit=50&fields=");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail("Multi page error : " + e.getMessage());
        }

    }

    @Test(priority = 2)
    public void testUpdate() {
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList companyList = companyService.query();
            Company company = companyList.getItems().get(0);
            company.setName("test WS");
            companyService.update(company);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail("Unable to update company");
        }

    }

    @Test(priority = 2)
    public void testComments() {
        try {
            CompaniesService companyService = new CompaniesService(clientApi);
            CompanyList companyList = companyService.query();
            Company company = companyList.getItems().get(0);

            CommentList comments = companyService.queryComments(company.getId(), null);
            Assert.assertNotNull(comments);
            for(Comment comment : comments.getItems()){
                Assert.assertTrue(comment.getText().length() > 0);
            }
            Comment comment = new Comment();
            comment.setText("test");
            short i = 1;
            comment.setMode(i);
            //long commentId = companyService.createComment(company.getId(), comment);
            //Assert.assertTrue(commentId > 0);

            //companyService.deleteComment(company.getId(), commentId);


        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail("Unable to get company comments");
        }

    }

}
