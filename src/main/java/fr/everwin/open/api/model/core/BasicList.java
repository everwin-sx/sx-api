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

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.core.Link;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Basic list class
 *
 * @author everwin-team
 */
public abstract class BasicList<T extends BasicObject> implements BasicListInterface<T> {

    @JsonProperty("selflink")
    protected String href;

    @JsonProperty("link")
    protected List<EverLink> links;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<EverLink> getLinks() {
        return links;
    }

    public void setLinks(List<EverLink> links) {
        this.links = links;
    }

    public String getNext() {
        return Optional.ofNullable(links)
                .flatMap(l -> l.stream().filter(link -> "next".equals(link.getRel())).findFirst())
                .map(link -> link.getUri().toString())
                .orElse(null);
    }

    public String getPrevious() {
        return Optional.ofNullable(links)
                .flatMap(l -> l.stream().filter(link -> "prev".equals(link.getRel())).findFirst())
                .map(link -> link.getUri().toString())
                .orElse(null);
    }

    public static class EverLink {
        private Map<String, String> params;
        private URI href;

        public EverLink() {
        }

        public void setParams(Map<String, String> params) {
            this.params = params;
        }

        public void setHref(URI href) {
            this.href = href;
        }

        public String getRel() {
            return Optional.ofNullable(params)
                    .map(p -> p.get(Link.REL))
                    .orElse(null);
        }

        public URI getUri() {
            return href;
        }
    }
}
