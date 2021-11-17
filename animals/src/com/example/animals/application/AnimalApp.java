package com.example.animals.application;

import java.util.List;
import java.util.function.Consumer;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

public class AnimalApp {

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
//		for (Animal animal : animals) { // External Loop: animals
//			animal.walk();
//			animal.eat();
//			if (animal instanceof Pet) {
//				((Pet)animal).play();
//			}
//		}
		// Functional Programming -> One-Liner
		Consumer<Animal> walk = Animal::walk;
		ABC armut = new ABC();
		Consumer<Animal> eat = Animal::eat; //ABC::haveGun; // armut::haveSun; // Gun::haveGun; // Animal::eat;
		int p=0; // Stack
		Consumer<Animal> playIfAnimal = animal -> {
			// Error: not allowed, only read-only operations allowed! p++;
			if (animal instanceof Pet) ((Pet)animal).play();
		};
		// Internal Loop
		animals.parallelStream().forEach(walk.andThen(eat).andThen(playIfAnimal)); 
		int x = 42; // effectively final
		//x++;
		String y = new String("Jack"); // object reference
		// FP's Function -> Functional Interface: SAM
		Fun z = u -> u * u + x; // Lambda Expression
		// FP's Functions -> 
		//  i) Higher Order Function (e.g., forEach) 
		// ii) Pure Function -> i) Lambda Expression ii) Method Reference
		//     walk, eat, playIfAnimal: pure functions 
		//     No Side effect -> Immutable Class -> Thread-safe
	}

}
@FunctionalInterface
interface Fun { // Functional Interface: SAM
	int elma(int x); // signature
}
interface Gun {
	static void haveGun(Animal animal) {
		System.err.println("I have gun!");
	}
}
class ABC {
	void haveSun(Animal animal) {
		System.err.println("I have sun!");
	}	
	static void haveGun(Animal animal) {
		System.err.println("I have gun!");
	}
}