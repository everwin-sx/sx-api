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
package fr.everwin.open.api.model.core;


/**
 * Specialized SpecificData for string
 *
 * @author everwin-team
 */
public class SpecificStringValue extends SpecificData {

    private String value;

    public SpecificStringValue() {
        super();
        this.type = SpecificType.STRING;
    }

    public SpecificStringValue(String name) {
        super(name);
        this.type = SpecificType.STRING;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof SpecificStringValue) {
            String val = ((SpecificStringValue) obj).getValue();
            return (this.value == null && val == null) || this.value.equals(val);
        } else {
            return false;
        }
    }

}
