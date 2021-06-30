import model.Movie;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

// first thing: Does Nothing Test
// what about null checks? Depends on info given - shouldn't really by passing nulls around (data coming in is accurate and ok)
public class MovieStoreTest {
    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findsMoviesWhenTitlesArePartiallyMatched() throws Exception {
        // should ask if this case sensitive - deciding its case insensitive
        // do we care about the order?
        MovieStore movieStore = new MovieStore();
        Movie harryPotter = new Movie("Harry Potter");
        movieStore.add(harryPotter);
        movieStore.add(new Movie("Shawshank Redemption"));
        movieStore.add(new Movie("Fight Club"));
        movieStore.add(new Movie("Pacific Rim"));
        Movie lordOfTheRings = new Movie("Lord Of The Rings");
        movieStore.add(lordOfTheRings);
        Movie lordOfTheFlies = new Movie("lord of the flies");
        movieStore.add(lordOfTheFlies);

        List<Movie> results = movieStore.findByPartialTitle("lord");

        assertThat(results.size(), is(2));
        assertThat(results, hasItems(lordOfTheFlies, lordOfTheRings));
    }
}