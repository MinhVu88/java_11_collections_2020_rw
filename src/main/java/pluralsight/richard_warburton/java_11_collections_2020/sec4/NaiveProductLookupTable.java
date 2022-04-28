package pluralsight.richard_warburton.java_11_collections_2020.sec4;

import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable{
	private final List<Product> products = new ArrayList<>();

	@Override
	public void addProduct(final Product addedProduct) {
		int id = addedProduct.getId();

		for(Product product : products) {
			if(product.getId() == id) {
				throw new IllegalArgumentException(
					"unable to add product - duplicate id for " + addedProduct
				);
			}
		}

		products.add(addedProduct);
	}

	@Override
	public Product lookupById(final int id) {
		for(final Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}

		return null;
	}

	@Override
	public void clear() {
		products.clear();
	}
}
