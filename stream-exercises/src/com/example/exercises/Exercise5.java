package com.example.exercises;

import java.util.Map;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise5 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

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
	}

}