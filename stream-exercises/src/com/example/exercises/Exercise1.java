package com.example.exercises;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map.Entry;

import com.example.domain.Director;
import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        movies.stream()
              .map( Movie::getDirectors )
              .flatMap( Collection::stream ) // flattening
              .collect(groupingBy(Director::getName,counting()))
              .forEach( (directorName,count) -> System.err.println(directorName+": "+count));
        Comparator<Entry<String,Long>> compareByCount = (entry1,entry2) -> (int)(entry2.getValue()- entry1.getValue());
        Comparator<Entry<String,Long>> compareByGenreName = (entry1,entry2) -> entry1.getKey().compareToIgnoreCase(entry2.getKey());
        
        movies.stream()
        	  .map( Movie::getGenres )
        	  .flatMap( Collection::stream )
        	  .collect(groupingBy(Genre::getName,counting()))
        	  .entrySet() // Entry: İkili (Key-Value)
        	  .stream()
        	  .sorted(compareByCount.thenComparing(compareByGenreName))
        	  .forEach( entry -> System.err.println(entry.getKey()+": "+entry.getValue()));
        
        String name1= "ali";
        String name2= "ayşe";
        System.out.println(name1.compareTo(name2));
        var numbers = new ArrayList<>(Arrays.asList(4,8,23,42,16,15));
        numbers.sort( (x,y) -> y-x );
        System.out.println(numbers);
	}

}
