import model.Movie;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {
    // ask how many movies are we expecting to store
    List<Movie> movies = new LinkedList<Movie>();

    // do the minimum amount to make the test pass
    public List<Movie> findByPartialTitle(String partialTitle) {
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(movie.title().toLowerCase().contains(partialTitle.toLowerCase())){
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findDirector(String director) {
        List<Movie> movieList = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if(movie.director().equals(director)){
                movieList.add(movie);
            }
        }
        return movieList;
    }
}
