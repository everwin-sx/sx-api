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

package fr.everwin.open.api.services.naces;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.naces.groups.NaceGroup;
import fr.everwin.open.api.model.naces.groups.NaceGroupList;
import fr.everwin.open.api.services.core.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author d.storti
 */
public class NaceGroupService extends BasicService<NaceGroup, NaceGroupList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(NaceGroupService.class);

    public NaceGroupService(ClientApi client) {
        super(client, "company-activity-groups");
        setModels(NaceGroup.class, NaceGroupList.class);
    }
}