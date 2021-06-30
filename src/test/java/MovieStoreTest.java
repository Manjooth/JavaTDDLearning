import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

// first thing: Does Nothing Test
// what about null checks? Depends on info given - shouldn't really by passing nulls around (data coming in is accurate and ok)
public class MovieStoreTest {
    private final MovieStore movieStore = new MovieStore();

    private final Movie harryPotter = new Movie("Harry Potter", "Howard", 2000);
    private final Movie lordOfTheRings = new Movie("Lord Of The Rings", "Nolan", 1997);
    private final Movie lordOfTheFlies = new Movie("lord of the flies", "Dave", 2002);
    private final Movie greece = new Movie("greece", "Howard", 1999);

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Before
    public void setUp() throws Exception {
        movieStore.add(harryPotter);
        movieStore.add(lordOfTheRings);
        movieStore.add(lordOfTheFlies);
        movieStore.add(greece);
    }

    @Test
    public void findsMoviesWhenTitlesArePartiallyMatchedCaseInsensitive() throws Exception {
        // should ask if this case sensitive - deciding its case insensitive
        // do we care about the order?
        List<Movie> results = movieStore.findByPartialTitle("lord");

        assertThat(results.size(), is(2));
        assertThat(results, hasItems(lordOfTheFlies, lordOfTheRings));
    }

    @Test
    public void findMovieWhenDirectorExactlyMatchesCaseSensitive() throws Exception {
        List<Movie> results = movieStore.findDirector("Nolan");

        assertThat(results.size(), is(1));
        assertThat(results, hasItems(lordOfTheRings));
    }

    @Test
    public void findMovieWhenReleaseYearIsBetweenTwoValues() throws Exception {
        // should the years be inclusive?
        // try and think about edge cases
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);

        assertThat(results.size(), is(3));
        assertThat(results, hasItems(lordOfTheFlies, harryPotter, greece));
    }
}