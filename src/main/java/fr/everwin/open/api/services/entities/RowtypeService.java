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

package fr.everwin.open.api.services.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.entities.rowtypes.Rowtype;
import fr.everwin.open.api.model.entities.rowtypes.RowtypeList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class RowtypeService extends BasicService<Rowtype, RowtypeList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public RowtypeService(ClientApi client) {
        super(client, "rowtypes");
        setModels(Rowtype.class, RowtypeList.class);
    }

    public RowtypeList queryExternal(RequestParams params) throws CoreException {
        return query(path + "/external", params);
    }

    public RowtypeList queryInternal(RequestParams params) throws CoreException {
        return query(path + "/internal", params);
    }

    public RowtypeList queryInternalActivities(RequestParams params) throws CoreException {
        return query(path + "/internal-activities", params);
    }
}