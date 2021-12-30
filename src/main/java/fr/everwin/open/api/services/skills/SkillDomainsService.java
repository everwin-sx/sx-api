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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.model.skills.skillsdomains.SkillDomain;
import fr.everwin.open.api.model.skills.skillsdomains.SkillDomainList;
import fr.everwin.open.api.model.skills.skillslevels.SkillLevelList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the skilldomain API resource
 * @author everwin-team
 */
public class SkillDomainsService extends BasicService<SkillDomain, SkillDomainList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public SkillDomainsService(ClientApi client){
        super(client, "skill-domains");
        setModels(SkillDomain.class, SkillDomainList.class);
    }

    public SkillLevelList querySLFromSD(SkillDomain skillDomain, RequestParams params) throws CoreException {
        SkillLevelsService service = new SkillLevelsService(clientApi);
        return service.query(path + "/"+skillDomain.getId()+"/skill-levels", params);
    }

    public SkillList querySkillsFromSD(SkillDomain skillDomain, RequestParams params) throws CoreException {
        SkillsService service = new SkillsService(clientApi);
        return service.query(path + "/"+skillDomain.getId()+"/skills", params);
    }
}
