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

import java.util.List;

// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlElementWrapper;
// import javax.xml.bind.annotation.XmlElements;
// import javax.xml.bind.annotation.XmlRootElement;

/**
 * Specialized SpecificData for multi link
 *
 * @author everwin-team
 */
public class SpecificMultiLinkValue extends SpecificData {

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
            List<DataLink> datalinks = ((SpecificMultiLinkValue) obj).getDatalinks();
            return (this.datalinks == null && datalinks == null) || this.datalinks.equals(datalinks);
        } else {
            return false;
        }
    }
}
