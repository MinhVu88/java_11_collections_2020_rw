package pluralsight.richard_warburton.java_11_collections_2020.sec4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {
	public static void main(String[] args) {
		final Map<Integer, Product> products = new HashMap<>();

		products.put(1, ProductFixtures.door);
		products.put(2, ProductFixtures.floorPanel);
		products.put(3, ProductFixtures.window);

		Set<Integer> productKeys = products.keySet();

		System.out.println("product keys: " + productKeys);
		System.out.println("products: " + products);

		System.out.println("--------------------------------------------------------------------");

		productKeys.remove(1);

		System.out.println("product keys: " + productKeys);
		System.out.println("products: " + products);

		// UnsupportedOperationException
		// -> can't add a key without its associated value to a set
		// ids.add(5);

		System.out.println("--------------------------------------------------------------------");

		Collection<Product> productValues = products.values();

		System.out.println("products: " + products);
		System.out.println("product values: " + productValues);

		productValues.remove(ProductFixtures.window);

		System.out.println("products: " + products);
		System.out.println("product values: " + productValues);

		// UnsupportedOperationException
		// -> can't add a value without its corresponding key to a set
		// productValues.add(ProductFixtures.window);

		System.out.println("--------------------------------------------------------------------");

		// before Java 10
		// Set<Map.Entry<Integer, Product>> productEntries = products.entrySet();

		// from java 10 onwards
		var productEntries = products.entrySet();

		for(Map.Entry<Integer, Product> entry : productEntries) {
			System.out.println("entry -> " + entry);
			System.out.println("entry.getKey() -> " + entry.getKey());
			System.out.println("entry.getValue() -> " + entry.getValue());

			entry.setValue(ProductFixtures.window);
		}

		System.out.println("products: " + products);

		// create a new entry
		var newEntry = Map.entry(3, ProductFixtures.window);

		// UnsupportedOperationException
		// productEntries.add(newEntry);
	}
}
