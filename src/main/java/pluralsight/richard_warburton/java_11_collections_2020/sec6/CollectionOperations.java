package pluralsight.richard_warburton.java_11_collections_2020.sec6;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionOperations {
	public static Product product1 = new Product("wooden door", 35);
	public static Product product2 = new Product("floor panel", 25);
	public static Product product3 = new Product("glass window", 10);

	public static void main(String[] args) {
		var products1 = List.of(product1, product2, product3);

		// min & max
		Product lightestProduct = Collections.min(products1, Product.BY_WEIGHT);
		Product heaviestProduct = Collections.max(products1, Product.BY_WEIGHT);

		System.out.println(
			"lightest product -> " + lightestProduct +
			" | heaviest product -> " + heaviestProduct
		);

		System.out.println("--------------------------------------------------------------------");

		// addAll()
		var products2 = new ArrayList<Product>();

		Collections.addAll(
			products2,
			product1,
			product2,
			product3
		);

		System.out.println("products2 -> " + products2);

		System.out.println("--------------------------------------------------------------------");

		// shuffle()
		Collections.shuffle(products2);

		System.out.println("products2 -> " + products2);

		System.out.println("--------------------------------------------------------------------");

		// fill()
		Collections.fill(products2, null);

		System.out.println("products2 -> " + products2);
	}
}
