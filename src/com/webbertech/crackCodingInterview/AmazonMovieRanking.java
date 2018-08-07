package com.webbertech.crackCodingInterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class AmazonMovieRanking {

	 public static class Movie {
	        private final int movieId;
	        private final float rating;
	        private List<Movie> similarMovies; // Similarity is bidirectional

	        public Movie(int movieId, float rating) {
	            this.movieId = movieId;
	            this.rating = rating;
	            similarMovies = new ArrayList<Movie>();
	        }

	        public int getId() {
	            return movieId;
	        }

	        public float getRating() {
	            return rating;
	        }

	        public void addSimilarMovie(Movie movie) {
	            similarMovies.add(movie);
	            movie.similarMovies.add(this);
	        }

	        public List<Movie> getSimilarMovies() {
	            return similarMovies;
	        }
	        
	        
	     public static class MovieComparator implements Comparator<Movie> {
	            @Override
	            public int compare(Movie o1, Movie o2) {
	                return (int)(o2.getRating() - o1.getRating());
	            }
	    }
	        
    public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
    	
    	if (movie == null || numTopRatedSimilarMovies < 0) {
    		throw new IllegalArgumentException();
    	} else if (numTopRatedSimilarMovies == 0)
    	{
    		return null;
    	} else if (numTopRatedSimilarMovies > movie.getSimilarMovies().size()) {
    		numTopRatedSimilarMovies = movie.getSimilarMovies().size();
    	}
    	
    	List<Movie> similarMovieList= movie.getSimilarMovies();
    	Collections.sort(similarMovieList, new MovieComparator());
    	
    	List<Movie> topNMovieList = new ArrayList<>();
    	int i = 0;
    	while (i<numTopRatedSimilarMovies) {
    		topNMovieList.add(similarMovieList.get(i));
    		i++;
    	}
    	
        return topNMovieList;
    }
    
    
    public static void main(String[] args) {
    	AmazonMovieRanking s = new AmazonMovieRanking();
    	Movie root = new Movie(0,10);
    	List<Movie> movies = new ArrayList<>();
    	root.addSimilarMovie(new Movie(1, 3.6f));
    	root.addSimilarMovie(new Movie(2, 2.4f));
    	root.addSimilarMovie(new Movie(3, 4.8f));
    	
    	List<Movie> list = getMovieRecommendations(root,3);
    	for(int i=0;i<list.size();i++) {
    		System.out.println(list.get(i).getRating());
    	}
    }
    
    /*
    public static void main(String[] args) throws IOException {       
        final Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
        Movie rootMovie = null;
        int numTopRatedSimilarMovies = 0;
        
        final Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("en", "US"));
        
        while (in.hasNextLine()) {
            final String type = in.next();
            
            if (type.equals("movie")) {
                final int id = in.nextInt();
                final float rating = in.nextFloat();
                movieMap.put(id, new Movie(id, rating));
            } else if (type.equals("similar")) {
                final Movie movie1 = movieMap.get(in.nextInt());
                final Movie movie2 = movieMap.get(in.nextInt());
                movie1.addSimilarMovie(movie2);
            } else if (type.equals("params")) {
                rootMovie = movieMap.get(in.nextInt());
                numTopRatedSimilarMovies = in.nextInt();
            } else {
                // ignore comments and whitespace
            }
        }
        
        List<Movie> result = Sort.Movie.getMovieRecommendations(rootMovie, numTopRatedSimilarMovies);
        
        String output = "result";
        
        if (result == null) {
            output += " <null>";
        } else {
            Collections.sort(result, new Comparator() {
                @Override
                public int compare(Object m1, Object m2) {
                    return ((Movie)m1).getId() - ((Movie)m2).getId();
                }
            });
            
            for (Movie m: result) {
                output += " ";
                output += m.getId();
            }            
        }
        
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(output);
        bw.newLine();
        bw.close();
    }
	*/
}
	 
}
