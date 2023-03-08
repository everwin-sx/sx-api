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

package fr.everwin.open.api.exception;

/**
 * Request exception to manage response informations like status code, message and developer message
 *
 * @author everwin-team
 */
public class RequestException extends CoreException {
    private String developperMessage;
    private int status;
    private int code;

    public RequestException(String msg) {
        super(msg);
    }

    public String getDevelopperMessage() {
        return developperMessage;
    }

    public void setDevelopperMessage(String developperMessage) {
        this.developperMessage = developperMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        String s = this.getClass().getName();
        String message = "Message : " + super.getMessage() + "\n" +
                "Error code : " + getCode() + "\n" +
                "Status : " + getStatus() + "\n" +
                "Developer message : " + getDevelopperMessage();
        return s + ": " + message;
    }
}
