package com.example.exercises;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise5 {
	private static final WorldDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		var countries = countryDao.findAllCountries();
		countries.stream()
		         //.map(country -> country.getContinent())
		         .map(Country::getContinent)
		         .distinct()
		         .sorted()
		         .forEach(System.err::println); // terminal

		countries.stream()
		         .collect(Collectors.groupingBy(Country::getContinent,Collectors.counting())) // terminal
		         .forEach((continent,count) -> System.err.println(continent+": "+count));
		countries.stream()
		         .collect(Collectors.groupingBy(Country::getContinent,Collectors.summingLong(Country::getPopulation)))
		         .forEach((continent,count) -> System.err.println(continent+": "+count));
		
		countries.stream()
		         .max(Comparator.comparing(Country::getPopulation)) // terminal
		         .ifPresent(System.err::println);
		
		countries.stream() // intermediary methods, terminal methods
				 // .mapToInt(country -> country.getCapital())
				 .mapToInt(Country::getCapital)
				 //.map( capitalId -> countryDao.findCityById(capitalId))
				 .mapToObj( countryDao::findCityById)
				 //.filter(city -> city!= null)
				 .filter(Objects::nonNull)
				 .max(Comparator.comparing(City::getPopulation)) // terminal -> pipeline // python, javascript: generator function
				 .ifPresent(System.err::println); // Lazy Evaluation
				 
	}

}