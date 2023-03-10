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

package fr.everwin.open.api.model.projects.lines;


import fr.everwin.open.api.model.projects.ProjectState;

/**
 * @author d.storti
 */
public class DiscountableProjectState extends ProjectState {


    private ProjectDebitCredit discount;

    /**
     *
     */
    public DiscountableProjectState() {
        super();
        discount = new ProjectDebitCredit();
    }

    /**
     * @return the discount
     */
    public ProjectDebitCredit getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(ProjectDebitCredit discount) {
        this.discount = discount;
    }

}
