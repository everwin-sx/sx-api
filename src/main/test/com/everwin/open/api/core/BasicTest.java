/*
 * Copyright (C) 2022 Everwin (www.everwin.fr)
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

package com.everwin.open.api.core;

import javax.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.core.config.ConfigHelper;
import fr.everwin.open.api.exception.RequestException;
import fr.everwin.open.api.model.comments.Comment;
import fr.everwin.open.api.model.comments.CommentList;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.documents.Document;
import fr.everwin.open.api.model.documents.DocumentList;
import fr.everwin.open.api.services.core.BasicService;

/**
 * @author d.storti
 */
public abstract class BasicTest<T extends BasicObject, S extends BasicService> {

    protected static final org.apache.logging.log4j.Logger LOG4J = org.apache.logging.log4j.LoggerFactory.getLogger();
    protected ClientApi clientApi;
    protected S service;
    protected T objectReceived;
    protected Comment commentReceived;
    protected Document documentReceived;
    protected final static String APIKEY = "";
    private final String filePath = "path";


    // bae02a79bf9884cff23a327a00fd86c6 : GBB
    public String ws_rights; // R : read // W : write // C : comment // D : Document // S : other specific services
    protected boolean isEmptyDB;

    protected abstract T initObject();

    protected abstract void changeObjectForUpdate();

    protected abstract void otherServices();


    @BeforeClass
    public void setUp() {
        try {
            clientApi = new ClientApi(ConfigHelper.URI_WS, ConfigHelper.VERSION);
            clientApi.setApiKey(APIKEY);
            isEmptyDB = false;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @AfterClass
    public void tearDown() {
    }

    @Test(priority = 1)
    public void testCreate() {
        if (!hasRights("W")) throw new SkipException("No access to this method");
        try {
            objectReceived = initObject();
            service.create(objectReceived);
            T objectFromAPI = (T) service.get(objectReceived.getId());
            Assert.assertTrue(compare(objectReceived, objectFromAPI));
        } catch (RequestException r) {
            if (r.getStatus() == Response.Status.FORBIDDEN.getStatusCode()) {
                ws_rights.replace("W", "");
                throw new SkipException("No access to this method");
            } else {
                r.printStackTrace(System.err);
                Assert.fail(r.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testGetAll() {
        if (!hasRights("R")) throw new SkipException("No access to this method");
        try {
            BasicList list = service.query();
            if (!hasRights("W")) objectReceived = (T) list.getItems().get(0);
            list.getItems().size();
        } catch (NullPointerException i) {
            isEmptyDB = true;
            if (!hasRights("W")) throw new SkipException("No access to this method"); // if empty but can create
            i.printStackTrace();
            Assert.fail("Error while get all objects", i);
        } catch (RequestException e) {
            e.printStackTrace();
            if (e.getStatus() != 200) Assert.fail("Error while get all objects", e);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while get all objects", e);
        }
    }

    @Test(priority = 3)
    public void testGet() {
        if (isEmptyDB || !hasRights("R")) throw new SkipException("No access to this method");
        try {
            T object = (T) service.get(objectReceived.getId());
            Assert.assertEquals(object.getId(), objectReceived.getId());
        } catch (RequestException e) {
            e.printStackTrace();
            if (e.getStatus() != 200) Assert.fail("Error while get one object", e);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while get one object", e);
        }
    }

    @Test(priority = 4)
    public void testUpdatePartially() {
        if (!hasRights("W")) throw new SkipException("No access to this method");
        try {
            T objectOld = objectReceived;
            changeObjectForUpdate();
            service.updatePartially(objectReceived);
            T objectModified = (T) service.get(objectReceived.getId());

            Assert.assertTrue(compare(objectReceived, objectModified));
            service.updatePartially(objectOld);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }

    @Test(priority = 5)
    public void testUpdateFull() {
        if (!hasRights("W")) throw new SkipException("No access to this method");
        try {
            T objectOld = objectReceived;
            changeObjectForUpdate();
            service.update(objectReceived);
            T objectModified = (T) service.get(objectReceived.getId());

            Assert.assertTrue(compare(objectReceived, objectModified));
            service.update(objectOld);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }

    @Test(priority = 999)
    public void testDelete() {
        if (!hasRights("W")) throw new SkipException("No access to this method");
        boolean forbidden = false;
        try {
            service.delete(objectReceived.getId());
        } catch (RequestException e) {
            e.printStackTrace();
            if (e.getStatus() != 403) Assert.fail("Error while delete object", e);
            else forbidden = true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
        try {
            service.get(objectReceived.getId());
            if (!forbidden) Assert.fail("Error while deleting : the object still exists");
        } catch (Exception ignored) {
        }
    }

    @Test(priority = 7)
    public void otherObjectServices() {
        if (!hasRights("S")) throw new SkipException("No access to this method");
        otherServices();
    }

    protected T loadFirstObject() {
        try {
            BasicList list = service.query();
            return (T) list.getItems().get(0);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
        return null;
    }

    protected Date parseTime(String timeValue) {
        SimpleDateFormat df = new SimpleDateFormat(ConfigHelper.TIMEFORMAT);
        Date time = null;
        try {
            time = df.parse(timeValue);
        } catch (ParseException e) {
            LOG4J.error(e.getMessage(), e);
        }
        return time;
    }

    protected Date parseDate(String dateValue) {
        SimpleDateFormat df = new SimpleDateFormat(ConfigHelper.DATETIMEFORMAT);
        Date dateStart = null;
        try {
            dateStart = df.parse(dateValue);
        } catch (ParseException e) {
            LOG4J.error(e.getMessage(), e);
        }
        return dateStart;
    }

    protected boolean compare(BasicObject obj1, BasicObject obj2) throws RequestException, IllegalAccessException {
        if (obj1.getClass() != obj2.getClass()) return false;
        Class<?> objClass1 = obj1.getClass();
        Class<?> objClass2 = obj2.getClass();
        Field[] fields1 = objClass1.getDeclaredFields();
        Field[] fields2 = objClass2.getDeclaredFields();
        int id = 0;
        for (Field field1 : fields1) {
            field1.setAccessible(true);
            fields2[id].setAccessible(true);
            if(isEcluded(field1.getName())) {
                id++;
                continue;
            }
            if (List.class.equals(field1.getType())) {
                if (listNotEquals(obj1, obj2, fields2, id, field1)) return false;
            } else if (DataLink.class.equals(field1.getType())) {
                if (dataLinkNotEquals(obj1, obj2, fields2, id, field1)) return false;
            } else {
                if (fieldNotEquals(obj1, obj2, fields2, id, field1)) {
                    return false;
                }
            }
            id += 1;
        }
        return true;
    }

    private boolean fieldNotEquals(BasicObject obj1, BasicObject obj2, Field[] fields2, int id, Field field1) throws IllegalAccessException {
        if (field1.get(obj1) == null
                && fields2[id].get(obj2) == null) {
            return false;
        } else if (!(field1.get(obj1).equals(fields2[id].get(obj2)))) {
            System.out.println(">>> Propriétés du POJO différentes : propertyName=" + field1.getName());
            System.out.println(">>> Valeurs : " + field1.get(obj1) + " ? " + fields2[id].get(obj2));
            return true;
        }
        return false;
    }

    private boolean dataLinkNotEquals(BasicObject obj1, BasicObject obj2, Field[] fields2, int id, Field field1) throws IllegalAccessException {
        if ((field1.get(obj1)) != null) {
            if (!(((DataLink) field1.get(obj1)).getId()
                    .equals((((DataLink) fields2[id]
                            .get(obj2)))
                            .getId()
                    ))) {
                printErrorDL(field1, ">>> Valeurs : " + ((DataLink) field1.get(obj1)).getId() + " ? " + ((DataLink) fields2[id].get(obj2)).getId());
                return true;
            }
        } else if ((fields2[id].get(obj2)) != null) {
            printErrorDL(field1, ">>> Valeurs : " + ((DataLink) field1.get(obj1)).getId() + " ? " + ((DataLink) fields2[id].get(obj2)).getId());
            return true;
        }
        return false;
    }

    private void printErrorDL(Field field1, String x) {
        System.out.println(">>> Propriétés du POJO différentes : propertyName=" + field1.getName());
        System.out.println(x);
    }

    private boolean listNotEquals(BasicObject obj1, BasicObject obj2, Field[] fields2, int id, Field field1) throws IllegalAccessException {
        if (field1.get(obj1) != null) {
            int i = 0;
            for (DataLink data : (ArrayList<DataLink>) field1.get(obj1)) {
                if (!(data.getId()
                        .equals(((ArrayList<DataLink>) fields2[id]
                                .get(obj2))
                                .get(i)
                                .getId()
                        ))) {
                    printErrorDL(field1, ">>> Valeurs : " + ((DataLink) field1.get(obj1)).getId() + " ? " + ((DataLink) fields2[id].get(obj2)).getId());
                    return true;
                }
                i += 1;
            }
        } else if ((fields2[id].get(obj2)) != null) {
            printErrorDL(field1, ">>> Valeurs : " + ((DataLink) field1.get(obj1)).getId() + " ? " + ((DataLink) fields2[id].get(obj2)).getId());
            return true;
        }
        return false;
    }

    public boolean isEcluded(String s) {
        String[] excludedArray = {"createdBy", "createdOnTime", "updatedBy", "updatedOnTime", "code", "repartitionStatus",
                "financialEntity", "comment", "spanco", "isLdapOut", "fullCostPrice", "directCostPrice", "totalIncludingVat",
                "totalWithoutVat", "total", "totalToBeCharged", "totalVat", "dueDate", "issuer", "totalToBeCharged", "amount",
                "vatAmount", "vatAmount2"};
        for (String value : excludedArray) {
            if (s.equals(value)) return true;
        }
        return false;
    }

    public boolean compareDocument(Document obj1, Document obj2) {
        if ((obj1 == null && obj2 == null))
            return false;
        return Objects.equals(obj1.getId(), obj2.getId())
                && Objects.equals(obj1.getTitle(), obj2.getTitle())
                && Objects.equals(obj1.getNature(), obj2.getNature())
                && Objects.equals(obj1.getLink(), obj2.getLink());
    }

    public boolean compareComment(Comment obj1, Comment obj2) {
        if ((obj1 == null && obj2 == null))
            return false;
        return Objects.equals(obj1.getId(), (obj2).getId())
                && Objects.equals(obj1.getText(), (obj2).getText());
    }

    protected boolean hasRights(String letter) {
        return ws_rights.contains(letter);
    }

    protected Comment initComment() {
        Comment comment = new Comment();
        comment.setText("Text");
        comment.setAuthor(new DataLink(237345L, ""));

        // !! others columns are readOnly
        return comment;
    }

    protected Document initDocument() {
        Document document = new Document();
        short i = 1;
        document.setTitle("Text");
        document.setNature(i);
        document.setLink("link");
        document.setAuthor(new DataLink(237345L, ""));
        return document;
    }

    protected void changeCommentForUpdate() {
        commentReceived.setText("Textmodified");
    }

    protected void changeDocumentForUpdate() {
        documentReceived.setTitle("Titlemodified");
    }

    @Test(priority = 8)
    public void testCreateComment() {
        if (!hasRights("C")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            commentReceived = initComment();
            commentReceived.setCreatedOnTime(service.createComment(objectReceived.getId(), commentReceived));
            Assert.assertTrue(compare(commentReceived, service.getComment(objectReceived.getId(), commentReceived.getId())));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 9)
    public void testGetAllComment() {
        if (!hasRights("C")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            CommentList list = service.queryComments(objectReceived.getId(), null);
            Assert.assertTrue(list.getItems().size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while get all objects", e);
        }
    }

    @Test(priority = 10)
    public void testGetComment() {
        if (!hasRights("C")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            Comment comment = service.getComment(objectReceived.getId(), commentReceived.getId());
            Assert.assertEquals(comment.getId(), commentReceived.getId());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while get one object", e);
        }
    }

    @Test(priority = 11)
    public void testUpdatePartiallyComment() {
        if (!hasRights("C")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            Comment commentBase = commentReceived;
            changeCommentForUpdate();
            Date date = service.updatePartiallyComment(objectReceived.getId(), commentReceived);
            commentReceived.setUpdatedOnTime(date);
            Comment commentModified = service.getComment(objectReceived.getId(), commentReceived.getId());

            Assert.assertTrue(compare(commentReceived, commentModified));
            commentReceived = commentBase;
            date = service.updatePartiallyComment(objectReceived.getId(), commentBase);
            commentReceived.setUpdatedOnTime(date);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }

    @Test(priority = 12)
    public void testUpdateFullComment() {
        if (!hasRights("C")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            Comment commentBase = commentReceived;
            changeCommentForUpdate();
            Date date = service.updateComment(objectReceived.getId(), commentReceived);
            commentReceived.setUpdatedOnTime(date);
            Comment commentModified = service.getComment(objectReceived.getId(), commentReceived.getId());

            Assert.assertTrue(compare(commentReceived, commentModified));
            commentReceived = commentBase;
            date = service.updateComment(objectReceived.getId(), commentBase);
            commentReceived.setUpdatedOnTime(date);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }

    @Test(priority = 13)
    public void testDeleteComment() {
        if (!hasRights("C")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            service.deleteComment(objectReceived.getId(), commentReceived.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
        try {
            service.getComment(objectReceived.getId(), commentReceived.getId());
            Assert.fail("Error while deleting : the object still exists");
        } catch (Exception ignored) {
        }
    }

    @Test(priority = 14)
    public void testCreateDocument() {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            documentReceived = initDocument();
            documentReceived.setCreatedOnTime(service.createDocument(objectReceived.getId(), documentReceived));
            Assert.assertTrue(compare(documentReceived, service.getDocument(objectReceived.getId(), documentReceived.getId())));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 15)
    public void testGetAllDocument() {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            DocumentList list = service.queryDocument(objectReceived.getId(), null);
            Assert.assertTrue(list.getItems().size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while get all objects", e);
        }
    }

    @Test(priority = 16)
    public void testGetDocument() {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            Document document = service.getDocument(objectReceived.getId(), documentReceived.getId());
            Assert.assertEquals(document.getId(), documentReceived.getId());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while get one object", e);
        }
    }

    @Test(priority = 17)
    public void testUpdatePartiallyDocument() {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            Document documentBase = documentReceived;
            changeDocumentForUpdate();
            Date date = service.updatePartiallyDocument(objectReceived.getId(), documentReceived);
            documentReceived.setUpdatedOnTime(date);
            Document commentModified = service.getDocument(objectReceived.getId(), documentReceived.getId());

            Assert.assertTrue(compare(documentReceived, commentModified));
            documentReceived = documentBase;
            date = service.updatePartiallyDocument(objectReceived.getId(), documentBase);
            documentReceived.setUpdatedOnTime(date);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }

    @Test(priority = 18)
    public void testUpdateFullDocument() {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            Document documentBase = documentReceived;
            changeDocumentForUpdate();
            Date date = service.updateDocument(objectReceived.getId(), documentReceived);
            documentReceived.setUpdatedOnTime(date);
            Document commentModified = service.getDocument(objectReceived.getId(), documentReceived.getId());

            Assert.assertTrue(compare(documentReceived, commentModified));
            documentReceived = documentBase;
            date = service.updateDocument(objectReceived.getId(), documentBase);
            documentReceived.setUpdatedOnTime(date);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        }
    }

    @Test(priority = 18)
    public void testUploadDocument() throws IOException {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
/*        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        try {
            File file = new File(filePath);
            service.uploadDocument(objectReceived.getId(), documentReceived, file);
            reader1 = new BufferedReader(new FileReader(service.downloadDocument(objectReceived.getId(), documentReceived)));
            reader2 = new BufferedReader(new FileReader(filePath));
            Assert.assertTrue(compareFiles(reader1, reader2));
            reader1.close();
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        } finally {
            reader1.close();
            reader2.close();
        }*/
    }

    @Test(priority = 18)
    public void testDownloadDocument() throws IOException {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
/*        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        try {
            File file = new File(filePath);
            File file2 = service.downloadDocument(objectReceived.getId(), documentReceived);
            reader1 = new BufferedReader(new FileReader(file));
            reader2 = new BufferedReader(new FileReader(file2));
            Assert.assertTrue(compareFiles(reader1, reader2));
            reader1.close();
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while comparing object", e);
        } finally {
            reader1.close();
            reader2.close();
        }*/
    }

    private boolean compareFiles(BufferedReader reader1, BufferedReader reader2) throws IOException {
        boolean areEqual = true;
        int lineNum = 1;
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }
        return areEqual;
    }

    @Test(priority = 19)
    public void testDeleteDocument() {
        if (!hasRights("D")) throw new SkipException("No access to this method");
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
        try {
            service.deleteDocument(objectReceived.getId(), documentReceived.getId());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Assert.fail(e.getMessage());
        }
        try {
            service.getDocument(objectReceived.getId(), documentReceived.getId());
            Assert.fail("Error while deleting : the object still exists");
        } catch (Exception ignored) {
        }
    }
}