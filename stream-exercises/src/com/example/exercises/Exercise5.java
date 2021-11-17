package com.example.exercises;

import java.util.Comparator;
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
		         .forEach(System.err::println);

		countries.stream()
		         .collect(Collectors.groupingBy(Country::getContinent,Collectors.counting()))
		         .forEach((continent,count) -> System.err.println(continent+": "+count));
		countries.stream()
		         .collect(Collectors.groupingBy(Country::getContinent,Collectors.summingLong(Country::getPopulation)))
		         .forEach((continent,count) -> System.err.println(continent+": "+count));
		
		countries.stream()
		         .max(Comparator.comparing(Country::getPopulation))
		         .ifPresent(System.err::println);
		
		countries.stream()
				 .mapToInt(country -> country.getCapital())
				 //.map( capitalId -> countryDao.findCityById(capitalId))
				 .mapToObj( countryDao::findCityById)
				 .filter(city -> city!= null)
				 .max(Comparator.comparing(City::getPopulation))
				 .ifPresent(System.err::println);
				 
	}

}