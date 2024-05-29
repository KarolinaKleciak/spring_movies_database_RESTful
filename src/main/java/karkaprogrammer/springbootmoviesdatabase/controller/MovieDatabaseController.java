package karkaprogrammer.springbootmoviesdatabase.controller;

import karkaprogrammer.springbootmoviesdatabase.model.Movie;
import karkaprogrammer.springbootmoviesdatabase.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieDatabaseController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")//sprawdzone
    public ResponseEntity<List<Movie>> showAllMovies() {
        List<Movie> allMovies = movieService.showAllMovies();
        if (!allMovies.isEmpty()) {
            return new ResponseEntity<>(allMovies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")//sprawdzone
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/update/{id}")//sprawdzone
    public void updateMoviesById(@PathVariable int id, @RequestBody HashMap<String, Object> propertiesToUpdate) {
        movieService.updateMoviesById(id, propertiesToUpdate);
    }

    @DeleteMapping("/delete")//sprawdzone
    public void deleteMoviesWithTitle(@RequestParam String title) {
        movieService.deleteMoviesWithTitle(title);
    }

    @GetMapping("/search")//sprawdzone
    public List<Movie> searchMoviesByPhrase(@RequestParam String phrase) {
        return movieService.searchMoviesByPhrase(phrase);
    }

    @PutMapping("/rate")//sprawdzone
    public void rateMoviesWithTitle(@RequestParam String title, @RequestParam double newRating) {
        movieService.rateMoviesWithTitle(title, newRating);
    }

    @GetMapping("/filter")//sprawdzone
    public List<Movie> filteringByMovieCategory(@RequestParam String category) {
        return movieService.filteringByMovieCategory(category);
    }
}
