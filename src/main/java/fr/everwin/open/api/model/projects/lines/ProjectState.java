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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author d.storti
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectState {

    protected ProjectDebitCredit revenue;
    protected ProjectDebitCredit expenditure;

    /**
     *
     */
    public ProjectState() {
        revenue = new ProjectDebitCredit();
        expenditure = new ProjectDebitCredit();
    }

    /**
     * @return the revenue
     */
    public ProjectDebitCredit getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(ProjectDebitCredit revenue) {
        this.revenue = revenue;
    }

    /**
     * @return the expenditure
     */
    public ProjectDebitCredit getExpenditure() {
        return expenditure;
    }

    /**
     * @param expenditure the expenditure to set
     */
    public void setExpenditure(ProjectDebitCredit expenditure) {
        this.expenditure = expenditure;
    }

}
