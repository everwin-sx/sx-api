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
 * SpecificData class to manage extra data field
 *
 * @author everwin-team
 */
package fr.everwin.open.api.model.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "dateval", value = SpecificDateValue.class),
        @JsonSubTypes.Type(name = "numberval", value = SpecificNumberValue.class),
        @JsonSubTypes.Type(name = "stringval", value = SpecificStringValue.class),
        @JsonSubTypes.Type(name = "link", value = SpecificLinkValue.class),
        @JsonSubTypes.Type(name = "multilink", value = SpecificMultiLinkValue.class)})
public abstract class SpecificData {

    @JsonIgnore
    protected SpecificType type;
    private String name;

    public SpecificData() {
        // Constructor empty
    }

    public SpecificData(String name) {
        this.name = name;
    }

    public SpecificType getType() {
        return type;
    }

    public void setType(SpecificType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum SpecificType {

        STRING("string"), NUMBER("number"), DATE("date"), LINK("link"), MULTILINK("multilink");

        public final String name;

        SpecificType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

}
