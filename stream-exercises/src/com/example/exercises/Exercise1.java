package com.example.exercises;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Collection;

import com.example.domain.Director;
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
        
	}

}
