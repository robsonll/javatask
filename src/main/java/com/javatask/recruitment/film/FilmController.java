package com.javatask.recruitment.film;

import com.javatask.recruitment.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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



}
