package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(100); // LinkedList<>
		// i) Allows duplicates ✔
		// ii) Ordered ✔ -> i) can sort list ii) nth element
		numbers.add(16);
		numbers.add(8);
		numbers.add(42);
		numbers.add(15);
		numbers.add(4);
		numbers.add(23);
		numbers.add(8);
		numbers.add(16);
		numbers.add(4);
		System.err.println(numbers);
		System.err.println(numbers.get(3));
		System.err.println(numbers.get(0));
		System.err.println(numbers.get(5));
		numbers.add(4, 108);
		Collections.sort(numbers, (x, y) -> x - y); // utility class
		numbers.sort((x, y) -> x - y); // since java 8
		System.err.println(numbers.contains(23));
		for (var number : numbers) {
			System.err.println(number);
		}	
	}

}
