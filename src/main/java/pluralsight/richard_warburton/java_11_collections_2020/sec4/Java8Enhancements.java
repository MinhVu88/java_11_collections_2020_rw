package pluralsight.richard_warburton.java_11_collections_2020.sec4;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements {
	public static void main(String[] args) {
		Product defaultProduct = new Product(-1, "anything", 100);

		Map<Integer, Product> products = new HashMap<>();
		products.put(1, ProductFixtures.door);
		products.put(2, ProductFixtures.floorPanel);
		products.put(3, ProductFixtures.window);

		// forEach()
		products.forEach((id, product) -> System.out.println("Id: " + id + " -> " + product));

		System.out.println("--------------------------------------------------------------------");

		// getOrDefault()
		System.out.println("product #4 before getOrDefault() -> " + products.get(4));

		System.out.println(
			"product #4 after getOrDefault() -> " + products.getOrDefault(4, defaultProduct)
		);

		System.out.println("--------------------------------------------------------------------");

		// replace()
		Product oldProduct = products.replace(
			1,
			new Product(1, "iron door", 50)
		);

		System.out.println(
			"product before replace() -> " + oldProduct.getName() +
			" | product after replace() -> " + products.get(1).getName()
		);

		System.out.println("--------------------------------------------------------------------");

		// replaceAll()
		System.out.println("products' weight before replaceAll() -> ");
		products.forEach((id, product) -> System.out.println(product.getWeight()));

		products.replaceAll((id, product) ->
			new Product(
				id,
				product.getName(),
				product.getWeight() + 10
			)
		);

		System.out.println("products' weight after replaceAll() -> ");
		products.forEach((id, product) -> System.out.println(product.getWeight()));

		System.out.println("--------------------------------------------------------------------");

		// computeIfAbsent()
		System.out.println("product #4 before computeIfAbsent() -> " + products.get(4));

		Product product4 = products.computeIfAbsent(
			4,
			id -> new Product(4, "door handle", 5)
		);

		System.out.println("product #4 after computeIfAbsent() -> " + product4);
	}
}
