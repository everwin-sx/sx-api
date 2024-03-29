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


/**
 * Specialized SpecificData for link
 *
 * @author everwin-team
 */
public class SpecificLinkValue extends SpecificData {

    private DataLink datalink;

    public SpecificLinkValue() {
        super();
        this.type = SpecificType.LINK;
    }

    public SpecificLinkValue(String name) {
        super(name);
        this.type = SpecificType.LINK;
    }

    public DataLink getDatalink() {
        return datalink;
    }

    public void setDatalink(DataLink datalink) {
        this.datalink = datalink;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof SpecificLinkValue) {
            DataLink datalink = ((SpecificLinkValue) obj).getDatalink();
            return (this.datalink == null && datalink == null) || this.datalink.equals(datalink);
        } else {
            return false;
        }
    }

}
