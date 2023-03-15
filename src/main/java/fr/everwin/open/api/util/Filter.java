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

package fr.everwin.open.api.util;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a filter condition in RSQL to send as a query parameter.
 * RSQL is a super-set of the Feed Item Query Language (FIQL) – a clean and simple filter syntax for feeds; so it fits quite naturally into a REST API.
 * https://tools.ietf.org/html/draft-nottingham-atompub-fiql-00
 *
 * @author everwin-team
 */
public class Filter {
    protected List<String> conds;

    public List<String> getConds() {
        return conds;
    }

    public void setConds(List<String> conds) {
        this.conds = conds;
    }

    public String generate() {
        return conds.stream().collect(Collectors.joining(" "));
    }

    public static class Builder {
        protected List<String> conds = new ArrayList<String>();

        public Builder like(String field, String value) {
            conds.add(field + "=lk=" + value);
            return this;
        }

        public Builder in(String field, String values) {
            conds.add(field + "=in=" + values);
            return this;
        }

        public Builder notIn(String field, String values) {
            conds.add(field + "=out=" + values);
            return this;
        }

        public Builder equal(String field, String value) {
            conds.add(field + "==" + value);
            return this;
        }

        public Builder notEqual(String field, String value) {
            conds.add(field + "!=" + value);
            return this;
        }

        public Builder less(String field, String value) {
            conds.add(field + "=lt=" + value);
            return this;
        }

        public Builder greater(String field, String value) {
            conds.add(field + "=gt=" + value);
            return this;
        }

        public Builder lessOrEqual(String field, String value) {
            conds.add(field + "=le=" + value);
            return this;
        }

        public Builder greaterOrEqual(String field, String value) {
            conds.add(field + "=ge=" + value);
            return this;
        }

        public Builder start(String field, String value) {
            conds.add(field + "=st=" + value);
            return this;
        }

        public Builder end(String field, String value) {
            conds.add(field + "=en=" + value);
            return this;
        }

        public Builder or() {
            conds.add("or");
            return this;
        }

        public Builder and() {
            conds.add("and");
            return this;
        }

        public Builder filter(Filter filter) {
            conds.add(filter.generate());
            return this;
        }

        public Filter build() {
            Filter filter = new Filter();
            filter.setConds(conds);
            return filter;
        }
    }
}
