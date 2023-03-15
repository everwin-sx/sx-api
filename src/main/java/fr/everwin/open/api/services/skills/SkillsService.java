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
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.skills.Skill;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevelList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the skill API resource
 *
 * @author everwin-team
 */
public class SkillsService extends BasicService<Skill, SkillList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SkillsService.class);

    public SkillsService(ClientApi client) {
        super(client, "skills");
        setModels(Skill.class, SkillList.class);
    }

    public SkillLevelList querySLFromSkill(Skill skill, RequestParams params) throws CoreException {
        SkillLevelsService service = new SkillLevelsService(clientApi);
        return service.query(path + "/" + skill.getId() + "/levels", params);
    }
}
