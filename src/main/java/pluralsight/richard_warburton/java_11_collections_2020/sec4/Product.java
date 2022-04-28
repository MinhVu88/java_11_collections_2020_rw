package pluralsight.richard_warburton.java_11_collections_2020.sec4;

import java.util.Objects;

public class Product {
	private final int id;
	private final String name;
	private final int weight;

	public Product(int id, String name, int weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Product id: " + id + " | name: " + name + " | weight: " + weight;
	}

	public boolean equals(final Object object) {
		if(!(object instanceof Product)) {
			return false;
		}

		final Product product = (Product) object;

		return Objects.equals(id, product.id)
					 && Objects.equals(weight, product.weight)
					 && Objects.equals(name, product.name);
	}

	public int hashCode() {
		return Objects.hash(id, name, weight);
	}
}
