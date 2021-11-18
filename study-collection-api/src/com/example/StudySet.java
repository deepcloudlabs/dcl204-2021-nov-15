package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<>((x, y) -> y - x); // HashSet, LinkedHashSet, TreeSet, EnumSet
		// i) Unique ✔
		// ii) Un-ordered ✔
		numbers.add(16);
		numbers.add(8);
		numbers.add(42);
		numbers.add(15);
		numbers.add(4);
		numbers.add(23);
		numbers.add(8);
		numbers.add(16);
		numbers.add(4);
		System.err.println(numbers.contains(23)); // O(1)
		for (var number : numbers) {
			System.err.println(number);
		}
		Set<Employee> employees = new HashSet<>();
		employees.add(new Employee("1", "jack shephard", "tr1", 100_000));
		employees.add(new Employee("2", "kate austen", "tr2", 200_000));
		var result = employees.contains(new Employee("1", "jack shephard", "tr1", 100_000));
		System.err.println(result);
	}

}
