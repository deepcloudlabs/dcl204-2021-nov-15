package com.example.animals.application;

import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

public class Exercise1 {

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
		var legs = 0;
		for (var animal : animals) {
			legs += animal.getLegs();
		}
		System.err.println("legs: "+legs);
		animals.forEach(null);
		legs = animals.stream() // Stream API + Filter/Map/Reduce
		            //.map(animal -> animal.getLegs())
				      .parallel()
		              .mapToInt(Animal::getLegs)
		              .sum(); // reduce
		//  i) Data Parallelism -> Stream API -> Shared Memory + Thread
		//                                         Collection -----/\
		//                                       Partitioning ? -> Fork/Join Framework -> ForkJoin Thread Pool -> Job/Work Stealing Algorithm
		//                                       Message Passing -> Distributed
		// ii) Task Parallelism
	}

}
