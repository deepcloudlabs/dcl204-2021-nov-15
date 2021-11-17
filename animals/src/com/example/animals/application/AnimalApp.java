package com.example.animals.application;

import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

public class AnimalApp {

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
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) {
				((Pet)animal).play();
			}
		}
	}

}
