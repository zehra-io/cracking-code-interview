package io.kaluh.java8.basic.concurrent;

public class StreamSample1 {
	String name;
	Integer id;

	StreamSample1(String n, Integer i) {
		name = n;
		id = i;
	}

	StreamSample1(Integer i) {
		name = null;
		id = i;
	}

	@Override
	public String toString() {
		return name + " " + id;
	}

}
