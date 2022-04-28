package pluralsight.richard_warburton.java_11_collections_2020.common;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
	private final String name;
	private final List<Product> products = new ArrayList<>();

	public Supplier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "name: " + name + " & products: " + products;
	}
}
