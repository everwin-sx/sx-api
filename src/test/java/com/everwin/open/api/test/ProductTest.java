/*
 * Copyright (C) 2022 Everwin (www.everwin.fr)
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

package com.everwin.open.api.test;

import com.everwin.open.api.core.BasicTest;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.products.Product;
import fr.everwin.open.api.services.products.ProductsService;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d.storti
 */
public class ProductTest extends BasicTest<Product, ProductsService> {

	public final long ROWLINK = 105925;  // rowtype
	public final long CATLINK = 106136;  // category

	@Override
	@BeforeClass
	public void setUp() {
		super.setUp();
		service = new ProductsService(clientApi);
		ws_rights = "RW";
	}

	@Override
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Override
	protected Product initObject() {
		Product product = new Product();
		product.setName("WS-ARTICLE");
		product.setLabel("WS-ARTICLE");
		product.setCategory(new DataLink(CATLINK, ""));

		List<DataLink> rowtypes = new ArrayList<>();
		rowtypes.add(new DataLink(ROWLINK, ""));
		product.setRowTypes(rowtypes);

		product.setIsArchived((short)0);
		product.setCustomerRef("REF-CUSTOMER");
		product.setSupplierRef("REF-SUPPLIER");
		product.setSalePrice(200d);
		product.setPurchaseDiscountRate(0d);
		product.setPurchaseListPrice(100d);
		product.setPurchasePrice(100d);

		product.setUpdatedBy("EVERWIN_UNITTEST");

		product.setCustomerAssetsGeneration((short)1);

		return product;
	}

    @Override
    protected void changeObjectForUpdate() {
        objectReceived.setLabel("WS-ARTICLE-MODIFIED");

	}

    @Override
    protected void otherServices() {
        if (isEmptyDB) throw new SkipException("Empty DB, cannot dos this test");
    }
}
