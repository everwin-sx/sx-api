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

package fr.everwin.open.api.model.core;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Optional;

/**
 * Basic list class
 *
 * @author everwin-team
 */
public abstract class BasicList<T extends BasicObject> implements BasicListInterface<T> {

    @XmlElement(name = "selflink")
    protected String href;

    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    protected java.util.List<Link> links;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public java.util.List<Link> getLinks() {
        return links;
    }

    public void setLinks(java.util.List<Link> links) {
        this.links = links;
    }

    public String getNext() {
        if (links != null) {
            Optional<Link> result = links.stream().filter(link -> link.getRel().equals("next")).findFirst();
            return result.isPresent() ? result.get().getUri().toString() : null;
        }
        return null;
    }

    public String getPrevious() {
        if (links != null) {
            Optional<Link> result = links.stream().filter(link -> link.getRel().equals("prev")).findFirst();
            return result.isPresent() ? result.get().getUri().toString() : null;
        }
        return null;
    }

}
