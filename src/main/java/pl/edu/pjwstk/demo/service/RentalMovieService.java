package pl.edu.pjwstk.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.demo.exception.GatewayTimeoutException;
import pl.edu.pjwstk.demo.exception.RestTemplateErrorHandler;
import pl.edu.pjwstk.demo.model.Movie;


@Service
public class RentalMovieService {

    private final RestTemplate restTemplate;
    private static final  String MOVIE_URL = "http://localhost:8081/api/movies/";

    public RentalMovieService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public Movie getMovieById(Long id) {
        try {
            restTemplate.setErrorHandler(new RestTemplateErrorHandler());
            return this.restTemplate.getForObject(MOVIE_URL + id, Movie.class);
        } catch (ResourceAccessException ex) {
            throw new GatewayTimeoutException();
        }
    }


    public void returnMovie(Long id) {
        try {
            restTemplate.setErrorHandler(new RestTemplateErrorHandler());
            restTemplate.put(MOVIE_URL + "/isAvailable/" + id, Movie.class);
        } catch (ResourceAccessException ex) {
            throw new GatewayTimeoutException();
        }

    }
    }


