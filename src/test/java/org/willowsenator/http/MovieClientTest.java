package org.willowsenator.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieClientTest {
    private final MovieClient client = new MovieClient();

    @Test
    void getMovieById(){
        var movie = client.getMovieById();

        Assertions.assertNotNull(movie);
        Assertions.assertEquals("Ashoka", movie.name());
        Assertions.assertEquals(2023, movie.year());
        Assertions.assertEquals("Rosario Dawson, David Tennant, Natasha Liu Bordizzo", movie.cast());
        Assertions.assertEquals("2023-10-05", movie.release_date().toString());
    }

    @Test
    void getMovieByIdAsync(){
        var movie = client.getMovieByIdAsync().join();

        Assertions.assertNotNull(movie);
        Assertions.assertEquals("Ashoka", movie.name());
        Assertions.assertEquals(2023, movie.year());
        Assertions.assertEquals("Rosario Dawson, David Tennant, Natasha Liu Bordizzo", movie.cast());
        Assertions.assertEquals("2023-10-05", movie.release_date().toString());
    }

    @Test
    void getAllMovies(){
        var moviesList = client.getAllMovies();

        Assertions.assertNotNull(moviesList);
        assert moviesList.size() == 2;
    }

    @Test
    void getAllMoviesAsync(){
        var moviesList = client.getAllMoviesAsync().join();

        Assertions.assertNotNull(moviesList);
        assert moviesList.size() == 2;
    }
}