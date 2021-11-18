package com.example;

import java.util.HashMap;
import java.util.Map;

public class StudyMap {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Map<String,Integer> areaCodes = new HashMap<>(); // LinkedHashMap, TreeMap
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("istanbul-anadolu", 216);
		Map<String,Integer> licencePlateCodes = Map.of( // Immutable
			"istanbul" , 34, 
			"ankara"   ,  6
		);
		// Outer Loop on keys
		for (var city : areaCodes.keySet()) {
			System.err.println(String.format("%16s: %3d", city,areaCodes.get(city)));
		}
		// Outer Loop on values
		for (var areaCode : areaCodes.values()) {
			System.err.println(String.format("%3d", areaCode));
		}
		// Outer Loop on entries
		for (var entry : areaCodes.entrySet()) {
			System.err.println(String.format("%16s: %3d", entry.getKey(),entry.getValue()));
		}
		// Stream API -> Inner Loop
		areaCodes.entrySet()
		         .stream()
		         .map(entry -> String.format("%16s: %3d", entry.getKey(),entry.getValue()))
		         .forEach(System.err::println);
		var areaCode = areaCodes.get("ankara"); // O(1)
	}

}
