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

package fr.everwin.open.api.services.candidates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.candidates.Candidate;
import fr.everwin.open.api.model.candidates.CandidateList;
import fr.everwin.open.api.model.skills.SkillList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.skills.SkillsService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the candidates API resource
 * @author everwin-team
 */
public class CandidatesService extends BasicService<Candidate, CandidateList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public CandidatesService(ClientApi client){
        super(client, "candidates");
        setModels(Candidate.class, CandidateList.class);
    }

    public SkillList querySkillsFromCandidates(Candidate candidate, RequestParams params) throws CoreException {
        SkillsService skillsService = new SkillsService(clientApi);
        return skillsService.query(path + "/"+candidate.getId()+"/skills", params);
    }
}
