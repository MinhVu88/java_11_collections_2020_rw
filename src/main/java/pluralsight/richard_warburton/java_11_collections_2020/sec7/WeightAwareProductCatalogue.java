package pluralsight.richard_warburton.java_11_collections_2020.sec7;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;
import pluralsight.richard_warburton.java_11_collections_2020.common.Supplier;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class WeightAwareProductCatalogue implements Iterable<Product> {
	private final NavigableSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

	public void addSupplier(final Supplier supplier) {
		products.addAll(supplier.getProducts());
	}

	public Set<Product> findLighterProducts(final Product product) {
		return products.headSet(product, false);
	}

	@Override
	public Iterator<Product> iterator() {
		return null;
	}
}
