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

package fr.everwin.open.api.services.skills;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevel;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevelList;
import fr.everwin.open.api.services.core.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the skilllevel API resource
 *
 * @author everwin-team
 */
public class SkillLevelsService extends BasicService<SkillLevel, SkillLevelList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SkillLevelsService.class);

    public SkillLevelsService(ClientApi client) {
        super(client, "skill-levels");
        setModels(SkillLevel.class, SkillLevelList.class);
    }

}
