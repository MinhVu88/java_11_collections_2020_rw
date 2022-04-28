package pluralsight.richard_warburton.java_11_collections_2020.sec4;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable {
	private Map<Integer, Product> products = new HashMap<>();

	@Override
	public void addProduct(final Product addedProduct) {
		int addedProductId = addedProduct.getId();

		if(products.containsKey(addedProductId)) {
			throw new IllegalArgumentException(
				"unable to add product - duplicate id for " + addedProduct
			);
		}

		products.put(addedProductId, addedProduct);
	}

	@Override
	public Product lookupById(final int id) {
		return products.get(id);
	}

	@Override
	public void clear() {
		products.clear();
	}
}
