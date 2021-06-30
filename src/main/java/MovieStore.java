import model.Movie;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {
    // ask how many movies are we expecting to store
    List<Movie> movies = new LinkedList<Movie>();

    // do the minimum amount to make the test pass
    public List<Movie> findByPartialTitle(String partialTitle) {
        for (Movie movie : movies) {
            if(movie.title().contains(partialTitle)){
                return asList(movie);
            }
        }
        return new LinkedList<Movie>();
    }

    public void add(Movie movie) {
        movies.add(movie);
    }
}
