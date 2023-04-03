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

/**
 *
 */
package fr.everwin.open.api.model.skills.skillsdomains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonListDatalink;
import fr.everwin.open.api.util.JsonListDatalinkKey;

import java.util.List;

/**
 * Represents a skill domain
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkillDomain extends BasicObject {

    private String label;
    private String description;
    private Short isUnique;
    private Short hasDynamicSkills;
    private Short hasDate;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "entity")
    private List<DataLink> entities;
    private Short order;
    private Short cvparserType;
    private Short hasComment;

    private List<SpecificData> extraData;

    /**
     *
     */
    public SkillDomain() {
        // Constructor empty
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(Short isUnique) {
        this.isUnique = isUnique;
    }

    public Short getHasDynamicSkills() {
        return hasDynamicSkills;
    }

    public void setHasDynamicSkills(Short hasDynamicSkills) {
        this.hasDynamicSkills = hasDynamicSkills;
    }

    public Short getHasDate() {
        return hasDate;
    }

    public void setHasDate(Short hasDate) {
        this.hasDate = hasDate;
    }

    public List<DataLink> getEntities() {
        return entities;
    }

    public void setEntities(List<DataLink> entities) {
        this.entities = entities;
    }

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    public Short getCvparserType() {
        return cvparserType;
    }

    public void setCvparserType(Short cvparserType) {
        this.cvparserType = cvparserType;
    }

    public Short getHasComment() {
        return hasComment;
    }

    public void setHasComment(Short hasComment) {
        this.hasComment = hasComment;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        return "SkillDomain [label=" + label + ", entities=" + entities + "]";
    }
}
