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

package com.everwin.open.api.core.auth;

/**
 * Authentication object to manage OAuth2 or apiKey access
 * @author everwin-team
 */
public class Authentication {

    public static int TYPE_OAUTH = 0;
    public static int TYPE_APIKEY = 1;

    private int type;
    private String clientId;
    private String clientSecret;
    private String apiKey;
    private String token;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Builder class of the Authentication object
     */
    public static class Builder{
        private String clientId;
        private String clientSecret;
        private String apiKey;

        public Authentication build(){
            Authentication authentication = new Authentication();
            authentication.setApiKey(apiKey);
            authentication.setClientId(clientId);
            authentication.setClientSecret(clientSecret);
            if(apiKey != null){
                authentication.setType(TYPE_APIKEY);
            }else{
                authentication.setType(TYPE_OAUTH);
            }
            return authentication;
        }

        public Builder withClientInfos(String clientId, String clientSecret){
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder withApiKey(String apiKey){
            this.apiKey = apiKey;
            return this;
        }
    }
}
