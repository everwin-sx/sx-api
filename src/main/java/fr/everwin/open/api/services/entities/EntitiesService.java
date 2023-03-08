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

package fr.everwin.open.api.services.entities;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.accounts.AccountList;
import fr.everwin.open.api.model.currencies.Currency;
import fr.everwin.open.api.model.currencies.CurrencyList;
import fr.everwin.open.api.model.currencies.rates.CurrencyRateList;
import fr.everwin.open.api.model.entities.Entity;
import fr.everwin.open.api.model.entities.EntityList;
import fr.everwin.open.api.model.entities.rowtypes.RowtypeList;
import fr.everwin.open.api.services.accounts.AccountService;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.services.currencies.CurrencyRatesService;
import fr.everwin.open.api.services.currencies.CurrencyService;
import fr.everwin.open.api.util.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service manager to query the entity API resource
 *
 * @author everwin-team
 */
public class EntitiesService extends BasicService<Entity, EntityList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(EntitiesService.class);

    public EntitiesService(ClientApi client) {
        super(client, "entities");
        setModels(Entity.class, EntityList.class);
    }

    public EntityList queryOperational(RequestParams params) throws CoreException {
        return query(path + "/operational", params);
    }

    public EntityList queryFinancial(RequestParams params) throws CoreException {
        return query(path + "/financial", params);
    }

    public EntityList queryAccounting(RequestParams params) throws CoreException {
        return query(path + "/accounting", params);
    }

    public EntityList queryOperationalLast(RequestParams params) throws CoreException {
        return query(path + "/operational-last", params);
    }

    public EntityList queryFinancialLast(RequestParams params) throws CoreException {
        return query(path + "/financial-last", params);
    }

    public CurrencyList queryCurrencyFromEntity(Entity entity, RequestParams params) throws CoreException {
        CurrencyService service = new CurrencyService(clientApi);
        return service.query(path + "/" + entity.getId() + "/currencies", params);
    }

    public RowtypeList queryRowTypeFromEntity(Entity entity, RequestParams params) throws CoreException {
        RowtypeService service = new RowtypeService(clientApi);
        return service.query(path + "/" + entity.getId() + "/rowtypes", params);
    }

    public CurrencyRateList queryCurrencyRateFromEntity(Entity entity, RequestParams params) throws Exception {
        CurrencyRatesService service = new CurrencyRatesService(clientApi);
        return service.query(path + "/" + entity.getId() + "/currency-rates", params);
    }

    public CurrencyRateList queryCurrencyRateFromEntityAndCurrency(Entity entity, Currency currency, RequestParams params) throws Exception {
        CurrencyRatesService service = new CurrencyRatesService(clientApi);
        return service.query(path + "/" + entity.getId() + "/currencies/" + currency.getId() + "/rates", params);
    }

    public AccountList queryAccountFromEntity(Entity entity, RequestParams params) throws Exception {
        AccountService service = new AccountService(clientApi);
        return service.query(path + "/" + entity.getId() + "/accounts", params);
    }

    public AccountList queryAccountFromEntityForExpenseSheet(Entity entity, RequestParams params) throws Exception {
        AccountService service = new AccountService(clientApi);
        return service.query(path + "/" + entity.getId() + "/accounts/expense-sheet", params);
    }
}
