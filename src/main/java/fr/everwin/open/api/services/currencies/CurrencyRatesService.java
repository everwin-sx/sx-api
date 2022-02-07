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

package fr.everwin.open.api.services.currencies;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.currencies.rates.CurrencyRate;
import fr.everwin.open.api.model.currencies.rates.CurrencyRateList;
import fr.everwin.open.api.services.core.BasicService;

/**
 * Service manager to query the currencyrate API resource
 * @author everwin-team
 */
public class CurrencyRatesService extends BasicService<CurrencyRate, CurrencyRateList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public CurrencyRatesService(ClientApi client){
        super(client, "currency-rates");
        setModels(CurrencyRate.class, CurrencyRateList.class);
    }

    /**
     * Create an object and return the new id
     * @param object The instance of BasicObject to send
     * @return long The id of the new object
     * @throws CoreException If the request failed
     */
    public void addOrUpdateRate(CurrencyRate object) throws CoreException {
        Response response = clientApi.post(path,object);
        readResponse(response, String.class);
        /*String locationUri = response.getHeaderString("Location");
        Long id = Long.parseLong(locationUri.substring(locationUri.lastIndexOf("/") + 1, locationUri.length()));
        object.setId(id);
        object.setUpdatedOnTime(get(id).getUpdatedOnTime());
        return get(id).getUpdatedOnTime();*/
    }
}
