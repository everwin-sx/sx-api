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
package fr.everwin.open.api.model.skills;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.everwin.open.api.model.core.BasicList;

import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * Skills list
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "skilllist")
public class SkillList extends BasicList<Skill> {

    private final static String METHOD = "query";

    @XmlElement(name = "skill")
    @XmlElementWrapper(name = "skills")
    private List<Skill> items;

    @Override
    public List<Skill> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Skill> items) {
        this.items = items;
    }
}
