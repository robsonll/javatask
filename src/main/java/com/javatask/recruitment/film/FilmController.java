package com.javatask.recruitment.film;

import com.javatask.recruitment.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getAllFilms(@RequestParam(required = false) String title){
        try {
            List<Film> films = new ArrayList<Film>();

            filmRepository.findAll().forEach(films::add);

            if (films.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/films")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {

        try {
            Film _film = filmRepository.save(new Film(  film.getId(),
                    film.getActors(),
                    film.getCategory(),
                    film.getDescription(),
                    film.getLength(),
                    film.getRating(),
                    film.getRentalDuration(),
                    film.getReplacementCost(),
                    film.getSpecialFeatures(),
                    film.getTitle()));

            return new ResponseEntity<>(_film, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/films/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable("id") String id, @RequestBody Film film) {

        Optional<Film> filmData = filmRepository.findById(id);

        if (filmData.isPresent()) {
            Film _film = filmData.get();
            _film.setActors(film.getActors());
            _film.setCategory(film.getCategory());
            _film.setDescription(film.getDescription());
            _film.setLength(film.getLength());
            _film.setRating(film.getRating());
            _film.setRentalDuration(film.getRentalDuration());
            _film.setReplacementCost(film.getReplacementCost());
            _film.setSpecialFeatures(film.getSpecialFeatures());
            _film.setTitle(film.getTitle());

            return new ResponseEntity<>(filmRepository.save(_film), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<HttpStatus> deleteFilm(@PathVariable("id") String id) {

        try {
            filmRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
