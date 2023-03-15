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

package fr.everwin.open.api.services.vehicles;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.employees.vehicles.Vehicle;
import fr.everwin.open.api.model.employees.vehicles.VehicleList;
import fr.everwin.open.api.services.core.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the employee API resource
 *
 * @author d.storti
 */
public class VehiclesService extends BasicService<Vehicle, VehicleList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(VehiclesService.class);

    public VehiclesService(ClientApi client) {
        super(client, "vehicles");
        setModels(Vehicle.class, VehicleList.class);
    }
}