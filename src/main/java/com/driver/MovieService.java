package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieService {

    @Autowired MovieRepository respObj;

    public String addMovie(Movie movie) {

        String res=respObj.addMovie(movie);
        return res;


    }

    public String addDirector(Director director) {

        return respObj.addDirector(director);

    }

    public String addMovieDirectorPair(String  director, String movie) {

        return respObj.addMovieDirectorPair(director,movie);
    }

    public Movie getMovieByName(String name) {

        return respObj.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {

        return respObj.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        return respObj.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return respObj.findAllMovies();
    }

    public String deleteDirectorByName(String director) {
        return respObj.deleteDirectorByName(director);
    }

    public String deleteAllDirectors() {
        return respObj.deleteAllDirectors();
    }
}
