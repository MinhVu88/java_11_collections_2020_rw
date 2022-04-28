package pluralsight.richard_warburton.java_11_collections_2020.sec2;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts {
	public static void main(String[] args) {
		Product door = new Product("wooden door", 35);
		Product floorPanel = new Product("floor panel", 25);
		Product table = new Product("table", 15);
		Product window = new Product("glass window", 10);

		Collection<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(table);
		products.add(window);

		System.out.println(
			"size -> " + products.size() +
			" | isEmpty -> " + products.isEmpty() +
			" | contains(window) -> " + products.contains(window) +
			" | remove(window) -> " + products.remove(window) +
			" | contains(window) -> " + products.contains(window)
		);

		System.out.println();

		for(Product product : products) {
			System.out.println(
				"name: " + product.getName() + " | weight: " + product.getWeight()
			);
		}

		System.out.println();

		/*
		// ConcurrentModificationException is thrown in this case because
		// a collection's elements can't be modified as it's being iterated over
		for(Product product : products) {
			if(product.getWeight() > 20) {
				products.remove(product);
			}
		}
		*/

		// to perform the above action, use Iterator
		Iterator<Product> productsIterator = products.iterator();

		while(productsIterator.hasNext()) {
			Product product = productsIterator.next();

			if(product.getWeight() > 20) {
				productsIterator.remove();
			}
		}

		System.out.println(products);

		System.out.println();

		Collection<Product> removedProducts = new ArrayList<>();
		removedProducts.add(door);
		removedProducts.add(floorPanel);

		products.add(door);
		products.add(floorPanel);
		products.add(window);

		products.removeAll(removedProducts);

		System.out.println(products);
	}
}
