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

package fr.everwin.open.api.services.currencies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.currencies.Currency;
import fr.everwin.open.api.model.currencies.CurrencyList;
import fr.everwin.open.api.model.entities.Entity;
import fr.everwin.open.api.model.entities.EntityList;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.entities.EntitiesService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class CurrencyService extends BasicService<Currency, CurrencyList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(CurrencyService.class);

    public CurrencyService(ClientApi client) {
        super(client, "currencies");
        setModels(Currency.class, CurrencyList.class);
    }

    public EntityList queryEntity(Entity entity, RequestParams params) throws CoreException {
        EntitiesService service = new EntitiesService(clientApi);
        return service.query("entities/" + entity.getId() + "/currencies", params);
    }
}