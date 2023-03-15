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

package fr.everwin.open.api.model.projects.subcategories;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;

/**
 * @author d.storti
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectSubCategory extends BasicObject {

    private Short type;
    private String label;
    private Short archived;
    private DataLink category;

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public Short getArchived() {
        return archived;
    }

    public void setArchived(Short archived) {
        this.archived = archived;
    }

    public DataLink getCategory() {
        return category;
    }

    public void setCategory(DataLink category) {
        this.category = category;
    }
}
