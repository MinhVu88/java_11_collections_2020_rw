package pluralsight.richard_warburton.java_11_collections_2020.common;

import java.util.Comparator;

public class Product {
	private final String name;
	private final int weight;

	public Product(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "name: " + name + " & weight: " + weight;
	}

	public static final Comparator<Product> BY_WEIGHT = Comparator.comparingInt(Product::getWeight);
}
