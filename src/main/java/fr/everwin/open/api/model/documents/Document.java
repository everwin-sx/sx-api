/*
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

package fr.everwin.open.api.model.documents;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;

import java.util.Date;
import java.util.List;

/**
 * contactevent
 *
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document extends BasicObject {


    private String title;
    private DataLink type;
    private Short nature;
    private Short viewingLevel;
    private Short modificationLevel;
    private DataLink keywords;
    private String comment;
    private Double size;
    private DataLink author;
    private DataLink thesaurus;
    private String link;
    private String chorusType;
    private Short isSentToChorus;
    private String euserLockDoc;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    private String updatedBy;

    private String linkedClass;

    private Long linkedOid;

    private List<SpecificData> extraData;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DataLink getType() {
        return type;
    }

    public void setType(DataLink type) {
        this.type = type;
    }

    public Short getNature() {
        return nature;
    }

    public void setNature(Short nature) {
        this.nature = nature;
    }

    public Short getViewingLevel() {
        return viewingLevel;
    }

    public void setViewingLevel(Short viewingLevel) {
        this.viewingLevel = viewingLevel;
    }

    public Short getModificationLevel() {
        return modificationLevel;
    }

    public void setModificationLevel(Short modificationLevel) {
        this.modificationLevel = modificationLevel;
    }

    public DataLink getKeywords() {
        return keywords;
    }

    public void setKeywords(DataLink keywords) {
        this.keywords = keywords;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public DataLink getAuthor() {
        return author;
    }

    public void setAuthor(DataLink author) {
        this.author = author;
    }

    public DataLink getThesaurus() {
        return thesaurus;
    }

    public void setThesaurus(DataLink thesaurus) {
        this.thesaurus = thesaurus;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getChorusType() {
        return chorusType;
    }

    public void setChorusType(String chorusType) {
        this.chorusType = chorusType;
    }

    public Short getIsSentToChorus() {
        return isSentToChorus;
    }

    public void setIsSentToChorus(Short isSentToChorus) {
        this.isSentToChorus = isSentToChorus;
    }

    public String getEuserLockDoc() {
        return euserLockDoc;
    }

    public void setEuserLockDoc(String euserLockDoc) {
        this.euserLockDoc = euserLockDoc;
    }

    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getLinkedClass() {
        return linkedClass;
    }

    public void setLinkedClass(String linkedClass) {
        this.linkedClass = linkedClass;
    }

    public Long getLinkedOid() {
        return linkedOid;
    }

    public void setLinkedOid(Long linkedOid) {
        this.linkedOid = linkedOid;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
