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

package fr.everwin.open.api.services.projects;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.products.assets.CustomerAssetList;
import fr.everwin.open.api.model.projects.Project;
import fr.everwin.open.api.model.projects.ProjectList;
import fr.everwin.open.api.model.quotes.poa.POAQuote;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.products.CustomerAssetsService;
import fr.everwin.open.api.util.RequestParams;

/**
 * Service manager to query the project API resource
 * @author everwin-team
 */
public class ProjectsService extends BasicService<Project, ProjectList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ProjectsService.class);

    public ProjectsService(ClientApi client){
        super(client, "projects");
        setModels(Project.class, ProjectList.class);
    }


    /**
     * Create a new poaQuote for the project
     * @param objectId The project to link to the poaQuote
     * @param poaQuote The poaQuote to create
     * @return The id of the new comment
     * @throws CoreException If the request failed
     */
    public long createPOAQuoteFromLineId(long objectId, POAQuote poaQuote) throws CoreException {
        Response response = clientApi.post(path + "/" + objectId + "/create-quote", poaQuote);
        readResponse(response, String.class);
        String locationUri = response.getHeaderString("Location");
        return Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
    }

    public CustomerAssetList queryCustomersAssetsFromProject(Project project, RequestParams params) throws CoreException {
        CustomerAssetsService service = new CustomerAssetsService(clientApi);
        return service.query(path + "/"+project.getId()+"/customer-assets", params);
    }
}
