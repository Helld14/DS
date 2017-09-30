package ejercicio1;

import org.junit.*;
import static org.junit.Assert.*;

public class MovieRatingTest {
    private static MovieRating mr = new MovieRating(); //para que la cobertura sea del 100%
    
    @Test(expected = Exception.class)
    public void testMovieRating1() throws Exception {
        assertEquals(3.2, MovieRating.movieRating("Cars"), 0.0);
    }
    
    @Test
    public void testMovieRating2() throws Exception {
        assertEquals(3.2, MovieRating.movieRating("Cars 3"), 0.0);
        assertEquals(3.2, MovieRating.movieRating("Emoji"), 0.0);
        assertEquals(3.0, MovieRating.movieRating("Spiderman"), 0.0);
        assertEquals(4.2, MovieRating.movieRating("Dunkerque"), 0.0);
        assertEquals(3.2, MovieRating.movieRating("It"), 0.0);
        assertEquals(2.6, MovieRating.movieRating("Torrente 6"), 0.0);
    }
}
