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

package com.everwin.open.api.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ListAndServiceGenerator {
    public static void main(String[] args){
//        buildTemplate(new TemplateBuilder("C:\\DEV\\intellijWorkspace\\sx-api\\templates\\ObjectsService.tpl",
//                                "C:\\DEV\\intellijWorkspace\\sx-api\\src\\main\\java\\com\\everwin\\open\\api\\services\\supplierorders\\SupplierOrderService.java")
//                .objectClass("SupplierOrder")
//                .className("SupplierOrder")
//                .objectXml("supplierorder")
//                .objectXmlWrapper("supplierorders")
//                .serviceClass("SupplierOrderService")
//                .serviceMethod("SupplierOrder")
//                .serviceObject("order")
//                .serviceObjects("orders")
//                .servicePath("supplier-orders")
//                .build());

//        buildTemplate(new TemplateBuilder("C:\\DEV\\intellijWorkspace\\sx-api\\templates\\ObjectsService.tpl",
//                "C:\\DEV\\intellijWorkspace\\sx-api\\src\\main\\java\\com\\everwin\\open\\api\\services\\candidates\\CandidateSkillsService.java")
//                .objectClass("CandidateSkill")
//                .className("CandidateSkill")
//                .objectXml("candidateskill")
//                .objectXmlWrapper("candidateskills")
//                .serviceClass("CandidateSkillService")
//                .serviceMethod("CandidateSkill")
//                .serviceObject("candidateskill")
//                .serviceObjects("candidateskills")
//                .servicePath("candidate-skills")
//                .build());


    }

    public static void buildTemplate(TemplateParams params){

        BufferedWriter writer = null;
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(params.getTemplateFile()));
            writer = new BufferedWriter(new FileWriter(params.getDestFile()));
            String line = null;
            while((line = reader.readLine()) != null){
                line = params.apply(line);
                writer.write(line + "\n");
            }
        }catch(Exception e){
            e.printStackTrace(System.err);
        }finally{
            try {
                writer.flush();
            }catch(Exception e){}
        }
    }

    public static class TemplateParams{
        private String templateFile;
        private String destFile;
        private String xmlRoot;
        private String comment;
        private String className;
        private String objectXml;
        private String objectClass;
        private String objectXmlWrapper;
        private String serviceClass;
        private String servicePath;
        private String serviceMethod;
        private String serviceObjects;
        private String serviceObject;

        public TemplateParams(String templateFile, String destFile){
            this.templateFile = templateFile;
            this.destFile = destFile;
        }

        public String getXmlRoot() {
            return xmlRoot;
        }

        public void setXmlRoot(String xmlRoot) {
            this.xmlRoot = xmlRoot;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getObjectXml() {
            return objectXml;
        }

        public void setObjectXml(String objectXml) {
            this.objectXml = objectXml;
        }

        public String getObjectClass() {
            return objectClass;
        }

        public void setObjectClass(String objectClass) {
            this.objectClass = objectClass;
        }

        public String getObjectXmlWrapper() {
            return objectXmlWrapper;
        }

        public void setObjectXmlWrapper(String objectXmlWrapper) {
            this.objectXmlWrapper = objectXmlWrapper;
        }

        public String getServiceClass() {
            return serviceClass;
        }

        public void setServiceClass(String serviceClass) {
            this.serviceClass = serviceClass;
        }

        public String getServicePath() {
            return servicePath;
        }

        public void setServicePath(String servicePath) {
            this.servicePath = servicePath;
        }

        public String getServiceMethod() {
            return serviceMethod;
        }

        public void setServiceMethod(String serviceMethod) {
            this.serviceMethod = serviceMethod;
        }

        public String getServiceObjects() {
            return serviceObjects;
        }

        public void setServiceObjects(String serviceObjects) {
            this.serviceObjects = serviceObjects;
        }

        public String getServiceObject() {
            return serviceObject;
        }

        public void setServiceObject(String serviceObject) {
            this.serviceObject = serviceObject;
        }

        public String getTemplateFile() {
            return templateFile;
        }

        public void setTemplateFile(String templateFile) {
            this.templateFile = templateFile;
        }

        public String getDestFile() {
            return destFile;
        }

        public void setDestFile(String destFile) {
            this.destFile = destFile;
        }

        public String apply(String line){
            String[][] replacements = new String[][]{{"\\$\\(list_xmlroot\\)", xmlRoot},
                    {"\\$\\(list_comment\\)", comment},
                    {"\\$\\(list_class\\)", className + "List"},
                    {"\\$\\(object_xml\\)", objectXml},
                    {"\\$\\(object_class\\)", objectClass},
                    {"\\$\\(object_xmlwrapper\\)", objectXmlWrapper},
                    {"\\$\\(services_class\\)", serviceClass},
                    {"\\$\\(services_path\\)", servicePath},
                    {"\\$\\(services_method\\)", serviceMethod},
                    {"\\$\\(services_objects\\)", serviceObjects},
                    {"\\$\\(services_object\\)", serviceObject}
            };
            for(int i = 0; i < replacements.length; i++){
                String[] replacement = replacements[i];
                if(replacement[1] != null) {
                    line = line.replaceAll(replacement[0], replacement[1]);
                }
            }
            return line;
        }
    }

    public static class TemplateBuilder{
        private String templateFile;
        private String destFile;
        private String xmlRoot;
        private String comment;
        private String className;
        private String objectXml;
        private String objectClass;
        private String objectXmlWrapper;
        private String serviceClass;
        private String servicePath;
        private String serviceMethod;
        private String serviceObjects;
        private String serviceObject;

        public TemplateBuilder(String templateFile, String destFile){
            this.templateFile = templateFile;
            this.destFile = destFile;
        }

        public TemplateBuilder xmlRoot(String xmlRoot) {
            this.xmlRoot = xmlRoot;
            return this;
        }

        public TemplateBuilder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public TemplateBuilder className(String className) {
            this.className = className;
            return this;
        }

        public TemplateBuilder objectXml(String objectXml) {
            this.objectXml = objectXml;
            return this;
        }

        public TemplateBuilder objectClass(String objectClass) {
            this.objectClass = objectClass;
            return this;
        }

        public TemplateBuilder objectXmlWrapper(String objectXmlWrapper) {
            this.objectXmlWrapper = objectXmlWrapper;
            return this;
        }

        public TemplateBuilder serviceClass(String serviceClass) {
            this.serviceClass = serviceClass;
            return this;
        }

        public TemplateBuilder servicePath(String servicePath) {
            this.servicePath = servicePath;
            return this;
        }

        public TemplateBuilder serviceMethod(String serviceMethod) {
            this.serviceMethod = serviceMethod;
            return this;
        }

        public TemplateBuilder serviceObjects(String serviceObjects) {
            this.serviceObjects = serviceObjects;
            return this;
        }

        public TemplateBuilder serviceObject(String serviceObject) {
            this.serviceObject = serviceObject;
            return this;
        }

        public TemplateParams build(){
            TemplateParams template = new TemplateParams(templateFile, destFile);
            template.setServiceClass(serviceClass);
            template.setClassName(className);
            template.setComment(comment);
            template.setObjectClass(objectClass);
            template.setObjectXml(objectXml);
            template.setObjectXmlWrapper(objectXmlWrapper);
            template.setServiceMethod(serviceMethod);
            template.setServiceObject(serviceObject);
            template.setServiceObjects(serviceObjects);
            template.setServicePath(servicePath);
            template.setXmlRoot(xmlRoot);

            return template;
        }
    }
}
