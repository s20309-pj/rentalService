package pl.edu.pjwstk.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.demo.model.Movie;


@Service
public class SecondMovieService {

    private final RestTemplate restTemplate;

    public SecondMovieService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public Movie getMovieById(Long id) {
        return this.restTemplate.getForObject("http://localhost:8081/api/movies/" + id, Movie.class);
    }


    public void returnMovie(Long id) {
        String movieResourceUrl = String.format("http://localhost:8081/api/movies/isAvailable/" + id, Void.class);
        restTemplate.put(movieResourceUrl, null);
    }

}
