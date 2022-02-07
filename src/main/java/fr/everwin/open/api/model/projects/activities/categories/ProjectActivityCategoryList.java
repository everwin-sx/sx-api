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

package fr.everwin.open.api.model.projects.activities.categories;
import java.util.List;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.everwin.open.api.model.core.BasicList;
import fr.everwin.open.api.model.nafs.Naf;

/**
 * ProjectActivityCategory list
 * @author d.storti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "projectactivitycategorylist")
public class ProjectActivityCategoryList extends BasicList<ProjectActivityCategory> {

    private final static String METHOD = "query";

    @XmlElement(name = "projectactivitycategory")
    @XmlElementWrapper(name = "projectactivitycategory")
    private List<ProjectActivityCategory> items;

    @XmlElement(name = "selflink")
    protected String href;

    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    protected List<Link> links;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public List<ProjectActivityCategory> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ProjectActivityCategory> items) {
        this.items = items;
    }
}
