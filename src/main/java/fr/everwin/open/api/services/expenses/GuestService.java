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

package fr.everwin.open.api.services.expenses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.everwin.open.api.ClientApi;
import fr.everwin.open.api.exception.CoreException;
import fr.everwin.open.api.model.expenses.guests.Guest;
import fr.everwin.open.api.model.expenses.guests.GuestList;
import fr.everwin.open.api.model.expenses.sheets.lines.ExpenseSheetLine;
import fr.everwin.open.api.services.core.BasicService;
import fr.everwin.open.api.util.RequestParams;

/**
 * @author d.storti
 */
public class GuestService extends BasicService<Guest, GuestList> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GuestService.class);

    public GuestService(ClientApi client) {
        super(client, "guests");
        setModels(Guest.class, GuestList.class);
    }

    public GuestList queryGuestFromLine(ExpenseSheetLine line, RequestParams params) throws CoreException {
        return query("/expense-line/" + line.getId() +"/guests", params);
    }
}