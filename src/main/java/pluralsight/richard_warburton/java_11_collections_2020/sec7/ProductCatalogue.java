package pluralsight.richard_warburton.java_11_collections_2020.sec7;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;
import pluralsight.richard_warburton.java_11_collections_2020.common.Supplier;

import java.util.*;

public class ProductCatalogue implements Iterable<Product> {
	// private final List<Product> products = new ArrayList<>();
	private final Set<Product> products = new HashSet<>();

	public void addSupplier(final Supplier supplier) {
		// without using Set, this fails the tests in ProductCatalogueTest
		// products.addAll(supplier.getProducts());

		// this passes the tests but is quite inefficient
		List<Product> suppliedProducts = supplier.getProducts();

		suppliedProducts.forEach(suppliedProduct -> {
			if(!products.contains(suppliedProduct)) {
				products.add(suppliedProduct);
			}
		});

		// with using Set
		products.addAll(supplier.getProducts());
	}

	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}
}
