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
import fr.everwin.open.api.model.projects.categories.ProjectCategory;
import fr.everwin.open.api.model.projects.categories.ProjectCategoryList;
import fr.everwin.open.api.model.projects.subcategories.ProjectSubCategoryList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author d.storti
 */
public class ProjectCategoryService extends BasicService<ProjectCategory, ProjectCategoryList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ProjectCategoryService.class);

    public ProjectCategoryService(ClientApi client) {
        super(client, "project-categories");
        setModels(ProjectCategory.class, ProjectCategoryList.class);
    }

    public ProjectSubCategoryList querySProjectSubCategories(ProjectCategory category, RequestParams params) throws CoreException {
        ProjectSubCategoryService service = new ProjectSubCategoryService(clientApi);
        return service.query(path + "/" + category.getId() + "/project-sub-categories", params);
    }
}
