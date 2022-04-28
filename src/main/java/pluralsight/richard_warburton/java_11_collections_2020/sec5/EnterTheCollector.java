package pluralsight.richard_warburton.java_11_collections_2020.sec5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class EnterTheCollector {
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
		products.add(floorPanel);

		System.out.println("a stream of products, without Collectors -> ");

		products.stream()
						.filter(product -> product.getWeight() < 30)
						.sorted(comparingInt(Product::getWeight))
						.forEach(System.out::println);

		System.out.println("--------------------------------------------------------------------");

		// using Collectors interface, passed to the collect() method,
		// to create a particular collection of products out of a stream
		System.out.println("use Collectors to make a products list out of a products stream -> ");

		List<Product> lightProductsList =
		products.stream()
						.filter(product -> product.getWeight() < 30)
						.sorted(comparingInt(Product::getWeight))
						.collect(Collectors.toList());

		System.out.println(lightProductsList);

		System.out.println("--------------------------------------------------------------------");

		System.out.println("use Collectors to make a map of the products' names -> ");

		Map<String, List<Product>> lightProductsNames =
		products.stream()
						.filter(product -> product.getWeight() < 30)
						.sorted(comparingInt(Product::getWeight))
						.collect(groupingBy(Product::getName));

		System.out.println(lightProductsNames);

		System.out.println("--------------------------------------------------------------------");

		System.out.println("use Collectors to make a map of the products quantity -> ");

		Map<String, Long> lightProductsCount =
		products.stream()
						.filter(product -> product.getWeight() < 30)
						.sorted(comparingInt(Product::getWeight))
						.collect(groupingBy(Product::getName, counting()));

		System.out.println(lightProductsCount);
	}
}
