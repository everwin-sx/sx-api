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

package fr.everwin.open.api.services.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.model.products.CustomerAsset;
import fr.everwin.open.api.model.products.CustomerAssetList;
import fr.everwin.open.api.services.core.BasicService;

/**
 * Service manager to query the customerasset API resource
 * @author everwin-team
 */
public class CustomerAssetsService extends BasicService<CustomerAsset, CustomerAssetList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public CustomerAssetsService(ClientApi client){
        super(client, "customer-assets");
        setModels(CustomerAsset.class, CustomerAssetList.class);
    }

}
