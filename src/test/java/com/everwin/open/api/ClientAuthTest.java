package com.everwin.open.api;/*
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


import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.comments.Comment;
import fr.everwin.open.api.model.comments.CommentList;
import fr.everwin.open.api.model.companies.Company;
import fr.everwin.open.api.model.companies.CompanyList;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.services.companies.CompaniesService;
import fr.everwin.open.api.util.Filter;
import fr.everwin.open.api.util.RequestParams;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClientAuthTest {

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
            Map<String, String> nextUriParameters = getParameters(list.getNext());
            // uri + "/" + version + "/companies?filter=&sort=&offset=50&limit=50&fields="
            Assert.assertEquals(nextUriParameters.get("offset"), "50");
            Assert.assertEquals(nextUriParameters.get("limit"), "50");
            Assert.assertEquals(nextUriParameters.get("filter"), "");
            Assert.assertEquals(nextUriParameters.get("sort"), "");


            // Go to previous page
            list = companyService.query(list.getNext());
            Map<String, String> previousUriParameters = getParameters(list.getPrevious());
            //uri + "/" + version + "/companies?filter=&sort=&offset=0&limit=50&fields="
            Assert.assertEquals(previousUriParameters.get("offset"), "0");
            Assert.assertEquals(previousUriParameters.get("limit"), "50");
            Assert.assertEquals(previousUriParameters.get("filter"), "");
            Assert.assertEquals(previousUriParameters.get("sort"), "");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail("Multi page error : " + e.getMessage());
        }

    }

    private Map<String, String> getParameters(String stringUri) throws URISyntaxException, UnsupportedEncodingException {
        URI uri = new URI(stringUri);
        Map<String, String> parameters = new LinkedHashMap<>();
        for (String pair : uri.getQuery().split("&")) {
            int idx = pair.indexOf("=");
            parameters.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return parameters;
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
