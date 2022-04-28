package pluralsight.richard_warburton.java_11_collections_2020.sec6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableVsImmutable {
	public static void main(String[] args) {
		Map<String, Integer> mutablePopulation1 = new HashMap<>();

		mutablePopulation1.put("UK", 67);
		mutablePopulation1.put("USA", 328);

		System.out.println("mutablePopulation1 -> " + mutablePopulation1);

		System.out.println("--------------------------------------------------------------------");

		Map<String, Integer> immutablePopulation = Collections.unmodifiableMap(mutablePopulation1);

		// UnsupportedOperationException
		// immutablePopulation.put("South Korea", 23);

		System.out.println("immutablePopulation -> " + immutablePopulation);

		System.out.println("--------------------------------------------------------------------");

		Map<String, Integer> copiedPopulation = Map.copyOf(mutablePopulation1);

		System.out.println(
			"copiedPopulation -> " + copiedPopulation +
			" | immutablePopulation -> " + immutablePopulation
		);

		mutablePopulation1.put("Germany", 88);

		System.out.println(
			"copiedPopulation -> " + copiedPopulation +
			" | immutablePopulation -> " + immutablePopulation
		);

		// UnsupportedOperationException
		// copiedPopulation.put("Canada", 51);

		System.out.println("--------------------------------------------------------------------");

		Map<String, Integer> mutablePopulation2 = Map.of(
			"Norway", 47,
			"Sweden", 23
		);

		System.out.println("mutablePopulation2 -> " + mutablePopulation2);

		// UnsupportedOperationException
		// mutablePopulation2.put("Denmark", 17);
	}
}
