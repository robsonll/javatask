package com.javatask.recruitment.film;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("filmView")
@ViewScoped
public class FilmBean implements Serializable {

    private List<Film> films;
    private Film selectedFilm;

    @Inject
    private FilmRepository service;

    @PostConstruct
    public void init() {
        films = service.findAll();
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setService(FilmRepository service) {
        this.service = service;
    }

    public Film getSelectedFilm() {
        return selectedFilm;
    }

    public void setSelectedFilm(Film selectedFilm) {
        this.selectedFilm = selectedFilm;
    }

}
