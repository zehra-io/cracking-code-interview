package io.kaluh.java8.basic.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class TestStreamSample1 {
	static List<StreamSample1> persons = Arrays.asList(new StreamSample1("Bob", 1), new StreamSample1(2),
			new StreamSample1("Jane", 3));
	static int x;

	public static void main(String[] args) {
		Logger b;
		persons.stream().reduce((e1, e2) -> {
			x = e1.id;
			if (e1.id > e2.id)
				return e1;
			x = e2.id;
			return e2;
		}).flatMap(e -> Optional.ofNullable(e.name)).map(y -> new StreamSample1(y, x)).ifPresent(System.out::println);
	}
}
