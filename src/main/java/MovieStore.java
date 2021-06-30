import model.Movie;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {
    // ask how many movies are we expecting to store
    List<Movie> movies = new LinkedList<Movie>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    // do the minimum amount to make the test pass
    public List<Movie> findByPartialTitle(String partialTitle) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.title().toLowerCase().contains(partialTitle.toLowerCase());
            }
        };
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(predicate.matches(movie)){
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Movie> findDirector(String director) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.director().equals(director);
            }
        };
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(predicate.matches(movie)){
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.year() <= to && movie.year() >= from;
            }
        };
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(predicate.matches(movie)){
                movieList.add(movie);
            }
        }

        return movieList;
    }

    interface Predicate {
        boolean matches(Movie movie);
    }
}
