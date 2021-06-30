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
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(new Predicate() {
                @Override
                public boolean matches(Movie movie) {
                    return movie.title().toLowerCase().contains(partialTitle.toLowerCase());
                }
            }.matches(movie)){
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Movie> findDirector(String director) {
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(new Predicate() {
                @Override
                public boolean matches(Movie movie) {
                    return movie.director().equals(director);
                }
            }.matches(movie)){
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(new Predicate() {
                @Override
                public boolean matches(Movie movie) {
                    return movie.year() <= to && movie.year() >= from;
                }
            }.matches(movie)){
                movieList.add(movie);
            }
        }

        return movieList;
    }

    interface Predicate {
        boolean matches(Movie movie);
    }
}
