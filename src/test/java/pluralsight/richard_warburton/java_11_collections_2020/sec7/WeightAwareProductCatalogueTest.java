package pluralsight.richard_warburton.java_11_collections_2020.sec7;

import org.junit.jupiter.api.Test;
import pluralsight.richard_warburton.java_11_collections_2020.common.Product;
import pluralsight.richard_warburton.java_11_collections_2020.common.Supplier;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class WeightAwareProductCatalogueTest {
	public static Product door = new Product("Wooden Door", 35);
	public static Product floorPanel = new Product("Floor Panel", 25);
	public static Product window = new Product("Glass Window", 10);

	@Test
	public void shouldFindLighterProducts() {
		Supplier supplier1 = new Supplier("John's Glazing");
		supplier1.getProducts().add(window);

		Supplier supplier2 = new Supplier("All Purpose Supplies Ltd.");

		Collections.addAll(supplier2.getProducts(), door, floorPanel, window);

		WeightAwareProductCatalogue catalogue = new WeightAwareProductCatalogue();
		catalogue.addSupplier(supplier1);
		catalogue.addSupplier(supplier2);

		Set<Product> lighterProducts = catalogue.findLighterProducts(door);

		assertThat(lighterProducts, contains(window, floorPanel));
	}
}
