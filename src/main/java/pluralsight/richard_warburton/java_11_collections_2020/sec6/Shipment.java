package pluralsight.richard_warburton.java_11_collections_2020.sec6;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {
	private static final int LIGHT_VAN_MAX_WEIGHT = 20;
	private static final int MISSING_PRODUCT_INDEX = -1;

	private final List<Product> products = new ArrayList<>();
	private List<Product> lightVanProducts;
	private List<Product> heavyVanProducts;

	public List<Product> getLightVanProducts() {
		return lightVanProducts;
	}

	public List<Product> getHeavyVanProducts() {
		return heavyVanProducts;
	}

	public Iterator<Product> iterator() {
		return products.iterator();
	}

	public void add(Product product) {
		products.add(product);
	}

	public boolean replace(Product oldProduct, Product newProduct) {
		int oldProductIndex = products.indexOf(oldProduct);

		if(oldProductIndex == MISSING_PRODUCT_INDEX) {
			return false;
		}else {
			products.set(oldProductIndex, newProduct);

			return true;
		}
	}

	public void prepare() {
		// sort the product list
		products.sort(Product.BY_WEIGHT);

		// find the split point
		int splitPoint = findSplitPoint();

		// create 2 sub-views of the list (lightVanProducts & heavyVanProducts)
		// use 1 of the Collections class's factory method to avoid breaking
		// encapsulation by calling getLightVanProducts, which returns the private field
		lightVanProducts = Collections.unmodifiableList(products.subList(0, splitPoint));
		heavyVanProducts = products.subList(splitPoint, products.size());
	}

	private int findSplitPoint() {
		for(int i = 0; i < products.size(); i++) {
			Product product = products.get(i);

			if(product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
				return i;
			}
		}

		return 0;
	}
}
