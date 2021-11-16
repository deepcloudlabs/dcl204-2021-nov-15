package com.example;

import java.util.Locale;

public class StudyString {
	public static void main(String[] args) {
		String name1 = "jack"; // Constant Pool
		String name2 = new String("jack"); // HEAP
		String name3 = "jack"; // Constant Pool -> Object Cache
		// name2 = name2.intern();
		System.err.println("name1==name2: " + (name1 == name2));
		System.err.println("name1==name3: " + (name1 == name3));
		System.err.println("name1.equals(name2): " + (name1.equals(name2)));
		System.err.println("name1.equals(name3): " + (name1.equals(name3)));
		String city = "izmir";
		Locale tr_TR = new Locale("tr", "TR");
		String upper_city = city.toUpperCase(tr_TR);
		System.err.println(city);
		System.err.println(upper_city);
	}
}
