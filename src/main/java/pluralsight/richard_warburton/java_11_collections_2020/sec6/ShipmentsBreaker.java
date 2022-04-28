package pluralsight.richard_warburton.java_11_collections_2020.sec6;

import pluralsight.richard_warburton.java_11_collections_2020.common.Product;

import java.util.List;

public class ShipmentsBreaker {
	public static Product door = new Product("wooden door", 35);
	public static Product floorPanel = new Product("floor panel", 25);
	public static Product window = new Product("glass window", 10);

	public static void main(String[] args) {
		Shipment shipment = new Shipment();

		shipment.add(door);
		shipment.add(window);
		shipment.add(door);
		shipment.add(window);
		shipment.add(floorPanel);

		shipment.prepare();

		List<Product> lightVanProducts = shipment.getLightVanProducts();

		System.out.println("lightVanProducts -> " + lightVanProducts);

		// UnsupportedOperationException
		// lightVanProducts.remove(window);
	}
}
