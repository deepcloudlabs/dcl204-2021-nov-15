package com.example;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class StudyArray {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int number = 42; // scalar
		int[] numbers = new int[] { 4, 8, 15, 16, 23, 42 }; // array
		// 12 + 4 + 6 x 4 = 40B
		// Header (12B) (VT, Lock, Flags, Counter) , length (4B) , 4 , 8 , 15 , 16 , 23
		// , 42
		int dizi[]; // array
		// Stack: dizi -> reference variable (4B)
		dizi = new int[6]; // Heap: Header (12B) , length: 6 (4B) , 0,0,0,0,0,0
		// loop #1
		for (int i = 0; i < dizi.length; ++i)
			System.err.println(dizi[i]);
		dizi[0] = 4;
		dizi[1] = 8;
		dizi[2] = 15;
		dizi[3] = 16;
		dizi[4] = 23;
		dizi[5] = 42;
		for (int i = 0; i < dizi.length; ++i)
			System.err.println(dizi[i]);
		System.err.println("length: " + numbers.length);
		// loop #1 -> external loop
		for (int i = 0; i < numbers.length; ++i)
			System.err.println(numbers[i]);

		// loop #2 : Java SE 6+ -> external loop
		for (int num : numbers) { // sequential + read-only
			num = num * num;
		}
		for (int num : numbers) { // sequential + read-only
			System.err.println(num);
		}

		// loop #3: Java SE 8+ -> functional programming -> internal loop
		Arrays.stream(numbers).forEach(System.err::println);

		int sum = 0;
		for (int num : numbers) { // for-each
			if (num % 2 == 0) {
				int squared = num * num;
				sum += squared;
			}
		}
		System.err.println("sum: " + sum);
		IntPredicate even = n -> n % 2 == 0; // Functional Interface
		IntUnaryOperator squared = q -> q * q;
		// numbers.filter(n => n%2 == 0).map( p => p*p ).reduce((s,r) => s+r, 0)
		sum = Arrays.stream(numbers).parallel() // multi-core, J9 -> GPU
				.filter(n -> n % 2 == 0) // higher order function
				.map(squared) // higher order function
				.boxed()
				.reduce(Integer::sum) // higher order function, Method Reference
				.get();
		Arrays.parallelSort(numbers); // CPU -> GPU
		System.err.println("sum: " + sum);
	}

}
