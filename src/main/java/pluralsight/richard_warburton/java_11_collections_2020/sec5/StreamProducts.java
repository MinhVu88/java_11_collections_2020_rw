package pluralsight.richard_warburton.java_11_collections_2020.sec5;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class StreamProducts {
	public static void main(String[] args) {
		Product door = new Product(1,"wooden door", 35);
		Product floorPanel = new Product(2,"floor panel", 25);
		Product window = new Product(3,"glass window", 10);

		List<Product> products = new ArrayList<>();

		products.add(door);
		products.add(floorPanel);
		products.add(window);
		products.add(floorPanel);
		products.add(window);

		System.out.println("Loop -> ");
		sortLightWeightProductsByLoop(products);

		System.out.println("--------------------------------------------------------------------");

		System.out.println("Stream -> ");
		sortLightWeightProductsByStream(products);
	}

	private static void sortLightWeightProductsByStream(List<Product> products) {
		products.stream()
						.filter(product -> product.getWeight() < 30)
						.sorted(comparingInt(Product::getWeight))
						.map(Product::getName)
						.forEach(System.out::println);
	}

	private static void sortLightWeightProductsByLoop(List<Product> products) {
		List<Product> lightProducts = new ArrayList<>();

		for(Product product : products) {
			if(product.getWeight() < 30) {
				lightProducts.add(product);
			}
		}

		lightProducts.sort(comparingInt(Product::getWeight));

		for(Product product : lightProducts) {
			System.out.println(product.getName());
		}
	}
}
