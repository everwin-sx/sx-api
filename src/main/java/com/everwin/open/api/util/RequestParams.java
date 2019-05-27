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

package com.everwin.open.api.util;

import java.util.HashMap;
import java.util.Map;

/**
 * A wrapper class for query parameters
 * @author everwin-team
 */
public class RequestParams {
    private Map<String, String> params;

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    /**
     * The RequestParams Builder
     */
    public static class Builder{
        private Map<String, String> params;
        public Builder(){
            this.params = new HashMap<String, String>();
        }


        public Builder param(String param, String value) {
            if (params == null) {
                params = new HashMap<String, String>();
            }
            params.put(param, value);
            return this;
        }

        public Builder limit(int value){
            return param("limit", value + "");
        }

        public Builder offset(int value) {
            return param("offset", value + "");
        }

        public Builder filter(String value) {
            return param("filter", value);
        }

        public Builder fields(String value) {
            return param("fields", value);
        }

        public Builder sort(String value) {
            return param("sort", value);
        }

        public RequestParams build(){
            RequestParams requestParams = new RequestParams();
            requestParams.setParams(params);
            return requestParams;
        }
    }
}
