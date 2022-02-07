/*
* Copyright (C) 2021 Everwin (www.everwin.fr)
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

package fr.everwin.open.api.services.employees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.employees.Employee;
import fr.everwin.open.api.model.employees.EmployeeList;
import fr.everwin.open.api.model.employees.skills.EmployeeSkillList;
import fr.everwin.open.api.model.employees.vehicles.VehicleList;
import fr.everwin.open.api.model.leads.LeadList;
import fr.everwin.open.api.model.leaverequests.types.TypeList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.leads.LeadService;
import fr.everwin.open.api.services.leaverequests.TypeService;
import fr.everwin.open.api.services.vehicles.VehiclesService;
import fr.everwin.open.api.util.RequestParams;

/**
* Service manager to query the employee API resource
* @author d.storti
*/
public class EmployeesService extends BasicService<Employee, EmployeeList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public EmployeesService(ClientApi client){
        super(client, "employees");
        setModels(Employee.class, EmployeeList.class);
    }

    public EmployeeList queryManager(RequestParams params) throws CoreException {
        return query(path + "/managers", params);
    }

    public EmployeeList queryProjectManager(RequestParams params) throws CoreException {
        return query(path + "/project-managers", params);
    }

    public EmployeeList queryCommercial(RequestParams params) throws CoreException {
        return query(path + "/commercials", params);
    }

    public EmployeeList queryProjectDirector(RequestParams params) throws CoreException {
        return query(path + "/project-directors", params);
    }

    public VehicleList queryVehicle(Employee employee, RequestParams params) throws CoreException {
        VehiclesService vehiclesService = new VehiclesService(clientApi);
        return vehiclesService.query(path + "/"+employee.getId()+"/vehicles", params);
    }

    public TypeList queryLRType(Employee employee, RequestParams params) throws CoreException {
        TypeService TypeService = new TypeService(clientApi);
        return TypeService.query(path + "/"+employee.getId()+"/leave-request-types", params);
    }

    public LeadList queryLeadsFromEmployee(Employee employee, RequestParams params) throws CoreException {
        LeadService service = new LeadService(clientApi);
        return service.query(path + "/" + employee.getId() +"/leads", params);
    }

    public EmployeeSkillList querySkillsFromEmployee(Employee employee, RequestParams params) throws CoreException {
        EmployeesSkillsService service = new EmployeesSkillsService(clientApi);
        return service.query(path + "/" + employee.getId() + "/skills", params);
    }
}
