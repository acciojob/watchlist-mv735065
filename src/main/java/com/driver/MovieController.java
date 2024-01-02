package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.*;


@RestController

@Slf4j

@RequestMapping("/movies")

public class MovieController {


   // @Autowired MovieService serviceObj;
   MovieService serviceObj =new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String res=serviceObj.addMovie(movie);

        return new ResponseEntity(res, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String res=serviceObj.addDirector(director);

        return new ResponseEntity(res, HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String director,@RequestParam String movie){

        String res=serviceObj.addMovieDirectorPair(director,movie);
        return new ResponseEntity(res, HttpStatus.CREATED);

    }




    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie res=serviceObj.getMovieByName(name);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director res=serviceObj.getDirectorByName(name);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{name}")

public ResponseEntity getMoviesByDirectorName(@PathVariable String name){
        List<String> list=serviceObj.getMoviesByDirectorName(name);

        return new ResponseEntity(list,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")

    public ResponseEntity findAllMovies(){
        List<String> list=serviceObj.findAllMovies();

        return new ResponseEntity(list,HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director){

        String res=serviceObj.deleteDirectorByName(director);

        return new ResponseEntity(res,HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String res=serviceObj.deleteAllDirectors();
        return new ResponseEntity(res,HttpStatus.OK);
    }


}
