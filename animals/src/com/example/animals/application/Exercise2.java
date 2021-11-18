package com.example.animals.application;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

public class Exercise2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Animal> animals = List.of(
				new Spider(),
				new Cat(),
				new Fish("Free Willy"),
				new Spider(),
				new Cat("Garfield"),
				new Fish("Nemo"),
				new Spider()
			);
		Map<Class<? extends Animal>, Long> mapping = Map.of(
			Spider.class, 2L, // Spider -> 2 , Key -> Value
			Cat.class, 1L, // Cat -> 1
			Fish.class, 3L // Fish -> 3
		);
		mapping.get(Cat.class);
		Predicate<Animal> isCat = animal -> animal instanceof Cat; 
		long numberOfCats = animals.stream()
				                   //.filter(isCat)
				                   .map(Object::getClass)
				                   //.mapToLong(clazz -> mapping.get(clazz))
				                   .mapToLong(mapping::get)
				                   .sum();
				                   //.reduce(0L, (s,l) -> s+l); // min, max, sum, count
		// (0,1) -> 1 -> (1,1) -> 2
		System.err.println("numberOfCats: "+numberOfCats);
	}

}
