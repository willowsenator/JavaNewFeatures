package org.willowsenator.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class MovieClient {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(2)).build();
    public final static String ALL_MOVIES_URL = "http://127.0.0.1:8000/src/main/resources/movies.json";
    public final static String MOVIE_BY_ID_URL = "http://127.0.0.1:8000/src/main/resources/movies_by_id.json";

    public Movie getMovieById(){
        var request = requestBuilder(MOVIE_BY_ID_URL);
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code : " + response.statusCode());
            return objectMapper.readValue(response.body(), Movie.class);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Movie> getMovieByIdAsync(){
        var request = requestBuilder(MOVIE_BY_ID_URL);
        try {
            var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            return response.thenApply(httpResponse -> {
                System.out.println("Status code : " + httpResponse.statusCode());
                try {
                    return objectMapper.readValue(httpResponse.body(), Movie.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });



        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static HttpRequest requestBuilder(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
