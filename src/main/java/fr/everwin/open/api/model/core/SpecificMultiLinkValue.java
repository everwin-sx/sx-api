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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.util.JsonListDatalink;
import fr.everwin.open.api.util.JsonListDatalinkKey;

import java.util.List;
import java.util.Objects;

/**
 * Specialized SpecificData for multi link
 *
 * @author everwin-team
 */
public class SpecificMultiLinkValue extends SpecificData {

    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "datalink")
    private List<DataLink> datalinks;

    public SpecificMultiLinkValue() {
        super();
        this.type = SpecificType.MULTILINK;
    }

    public SpecificMultiLinkValue(String name) {
        super(name);
        this.type = SpecificType.MULTILINK;
    }

    public List<DataLink> getDatalinks() {
        return datalinks;
    }

    public void setDatalinks(List<DataLink> datalinks) {
        this.datalinks = datalinks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof SpecificMultiLinkValue) {
            List<DataLink> links = ((SpecificMultiLinkValue) obj).getDatalinks();
            return (Objects.isNull(this.datalinks) && Objects.isNull(links)) || (Objects.nonNull(this.datalinks) && this.datalinks.equals(links));
        } else {
            return false;
        }
    }
}
