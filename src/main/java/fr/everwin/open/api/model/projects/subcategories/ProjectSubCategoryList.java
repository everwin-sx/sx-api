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
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import fr.everwin.open.api.model.core.BasicList;

/**
 * @author d.storti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "projectsubcategorylist")
public class ProjectSubCategoryList extends BasicList<ProjectSubCategory> {

    private final static String METHOD = "query";

    @XmlElement(name = "projectsubcategory")
    @XmlElementWrapper(name = "projectsubcategory")
    private List<ProjectSubCategory> items;



    @XmlElement(name = "selflink")
    protected String href;

    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    protected List<Link> links;

    @Override
    public List<ProjectSubCategory> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ProjectSubCategory> items) {
        this.items = items;
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public List<Link> getLinks() {
        return links;
    }

    @Override
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
