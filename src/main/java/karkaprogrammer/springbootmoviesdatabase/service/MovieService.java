package karkaprogrammer.springbootmoviesdatabase.service;


import karkaprogrammer.springbootmoviesdatabase.model.Movie;

import java.util.HashMap;
import java.util.List;

public interface MovieService {

    List<Movie> showAllMovies();
    Movie addMovie(Movie movie);

    public void updateMoviesById(int id, HashMap<String, Object> propertiesToUpdate);
    public void deleteMoviesWithTitle(String title);

    public List<Movie> searchMoviesByPhrase(String phrase);

    public void rateMoviesWithTitle(String title, double newRating);

    public List<Movie> filteringByMovieCategory (String category);
}
