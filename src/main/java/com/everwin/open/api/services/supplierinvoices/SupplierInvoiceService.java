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

package com.everwin.open.api.services.supplierinvoices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.everwin.open.api.ClientApi;
import com.everwin.open.api.model.supplierinvoices.SupplierInvoice;
import com.everwin.open.api.model.supplierinvoices.SupplierInvoiceList;
import com.everwin.open.api.services.core.BasicService;

/**
 * Service manager to query the supplierinvoice API resource
 * @author everwin-team
 */
public class SupplierInvoiceService extends BasicService<SupplierInvoice, SupplierInvoiceList> {

    protected static final Logger LOGGER = LogManager.getLogger();

    public SupplierInvoiceService(ClientApi client){
        super(client, "supplier-invoices");
        setModels(SupplierInvoice.class, SupplierInvoiceList.class);
    }

}
