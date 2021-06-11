package pl.edu.pjwstk.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.demo.model.Movie;
import pl.edu.pjwstk.demo.service.SecondMovieService;


@RestController
@RequestMapping("/api")
public class SecondMovieController {

    private final SecondMovieService secondMovieService;

    public SecondMovieController(SecondMovieService secondMovieService) {
        this.secondMovieService = secondMovieService;
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return new ResponseEntity<>(secondMovieService.getMovieById(id), HttpStatus.OK);
    }

    @PutMapping("/returnMovie/{id}")
    public void changeAvailable(@PathVariable Long id) {
        secondMovieService.returnMovie(id);
    }

}
