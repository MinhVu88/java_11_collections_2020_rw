package pluralsight.richard_warburton.java_11_collections_2020.sec2;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;

import java.util.Arrays;

public class TheArrayProblem {
	private static Product[] add(Product product, Product[] products) {
		int productQuantity = products.length;

		Product[] newProductQuantity = Arrays.copyOf(products, productQuantity + 1);

		newProductQuantity[productQuantity] = product;

		return newProductQuantity;
	}

	public static void main(String[] args) {
		Product door = new Product("wooden door", 35);
		Product floorPanel = new Product("floor panel", 25);
		Product window = new Product("glass window", 10);

		// Create
		Product[] products = { door, floorPanel };

		// Print
		System.out.println("products -> " + products);
		System.out.println("Arrays.toString(products) -> " + Arrays.toString(products));

		// Add
		products = add(window, products);
		System.out.println("products -> " + Arrays.toString(products));

		// Duplicate
		products = add(window, products);
		System.out.println("products -> " + Arrays.toString(products));
	}
}
