package pluralsight.richard_warburton.java_11_collections_2020.sec4;

public interface ProductLookupTable {
	Product lookupById(int id);

	void addProduct(Product addedProduct);

	void clear();
}
