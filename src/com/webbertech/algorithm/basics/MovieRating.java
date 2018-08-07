package com.webbertech.algorithm.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieRating {

	static class Movie {
		String name ;
		float rating;
		
		Movie(String name, float rating) {
			this.name = name;
			this.rating = rating;
		}
	}
	
	// Using Java 8 method, the primitive types does not have compareTo
	static void  sortMovieByRating(List<Movie> movies) {
		 Collections.sort(movies, (a, b) -> new Float(a.rating) < new Float(b.rating) ? -1 : a.rating == b.rating ? 0 : 1);
	}
	
	
	// older solution using comparator interface
	static void sortMovieByRating2(List<Movie> movies) {
		Collections.sort(movies, new Comparator<Movie>() {
			@Override
			public int compare(Movie m1, Movie m2) {
				if (m1.rating < m2.rating) {
					return -1;
				} else if (m1.rating == m2.rating) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		 List<Movie> movies = Arrays.asList(
				 new Movie("m1", 7.0f),
				 new Movie("m2", 1.0f),
				 new Movie("m3", 3.0f),
				 new Movie("m3", 3.1f),
				 new Movie("m3", 5.6f),
				 new Movie("m3", 2.3f)
			);
		 
		 //sortMovieByRating(movies);
		 
		 sortMovieByRating2(movies);
		 for (Movie movie: movies) {
			 System.out.println(movie.rating);
		 }
	}
}
