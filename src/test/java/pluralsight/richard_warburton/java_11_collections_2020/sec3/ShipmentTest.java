package pluralsight.richard_warburton.java_11_collections_2020.sec3;

import org.junit.jupiter.api.Test;
import pluralsight.richard_warburton.java_11_collections_2020.common.Product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;

public class ShipmentTest {
	public static Product door = new Product("wooden door", 35);
	public static Product floorPanel = new Product("floor panel", 25);
	public static Product window = new Product("glass window", 10);

	private Shipment shipment = new Shipment();

	@Test
	public void shouldAddItems() {
		shipment.add(door);
		shipment.add(window);

		assertThat(shipment, contains(door, window));
	}

	@Test
	public void shouldReplaceItems() {
		shipment.add(door);
		shipment.add(window);

		assertTrue(shipment.replace(door, floorPanel));

		assertThat(shipment, contains(floorPanel, window));
	}

	@Test
	public void shouldNotReplaceMissingItems() {
		shipment.add(window);

		assertFalse(shipment.replace(door, floorPanel));

		assertThat(shipment, contains(window));
	}

	@Test
	public void shouldIdentifyVanRequirements() {
		shipment.add(door);
		shipment.add(window);
		shipment.add(floorPanel);

		shipment.prepare();

		assertThat(shipment.getLightVanProducts(), contains(window));
		assertThat(shipment.getHeavyVanProducts(), contains(floorPanel, door));
	}
}
