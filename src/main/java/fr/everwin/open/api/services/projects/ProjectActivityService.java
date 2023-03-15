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

package fr.everwin.open.api.services.projects;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.projects.activities.ProjectActivity;
import fr.everwin.open.api.model.projects.activities.ProjectActivityList;
import fr.everwin.open.api.services.core.BasicService;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author d.storti
 */
public class ProjectActivityService extends BasicService<ProjectActivity, ProjectActivityList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ProjectActivityService.class);

    public ProjectActivityService(ClientApi client) {
        super(client, "project-activities");
        setModels(ProjectActivity.class, ProjectActivityList.class);
    }

    /**
     * Renew an activity in the same activity
     *
     * @param objectId The id of the activity to renew
     * @param activity The activity to create
     * @return The id of the activity
     * @throws CoreException If the request failed
     */
    public long renewFrom(long objectId, ProjectActivity activity) throws CoreException {
        try (Response response = clientApi.post(path + "/" + objectId + "/line/" + activity.getId(), activity)) {
            readResponse(response, String.class);
            return activity.getId();
        }
    }

    /**
     * Renew an activity to the new one
     *
     * @param activity The activity to create
     * @return The id of the activity
     * @throws CoreException If the request failed
     */
    public long renew(ProjectActivity activity) throws CoreException {
        try (Response response = clientApi.post(path + "/" + activity.getId(), activity)) {
            readResponse(response, String.class);
            return activity.getId();
        }
    }
}