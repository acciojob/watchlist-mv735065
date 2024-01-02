package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.*;

@Repository

public class MovieRepository {

    Map<String,List<String>> map=new HashMap<>();

    List<Movie> movies= new ArrayList<>();
    List<Director> directors=new ArrayList<>();

    public String addMovie(Movie movie) {

           movies.add(movie);
        //   map.put();
           return "movies is added";
    }

    public String addDirector(Director director) {
      //  map.put(null,director);
        directors.add(director);
        return "success";


    }

    public String addMovieDirectorPair(String director, String movie) {
        List<String> list;
        if(map.containsKey(director)){
            list=map.get(director);
            list.add(movie);
        }
        else{
            list=new ArrayList<>();
        list.add(movie);
        }

        map.put(director,list);

        return "success";
    }


    public Movie getMovieByName(String name) {
        for(Movie movie : movies){
            if(movie.getName().equals(name)){
                return movie;
            }
        }
        return null;
    }


    public Director getDirectorByName(String name) {

        for(Director director : directors){
            if(director.getName().equals(name)){
                return director;
            }
        }
        return null;
    }


    public List<String> getMoviesByDirectorName(String name) {

        return map.get(name);
    }

    public List<String> findAllMovies() {
        List<String> list=new ArrayList<>();
        for(Movie movie : movies) list.add(movie.getName());
        return list;
    }

    public String deleteDirectorByName(String director) {

        if(!map.containsKey(director))  return "success";

        List<String> list=map.get(director);

        for(String movie : list){
          for(int i=0;i<movies.size();i++){
              if(movie.equals(movies.get(i).getName())) movies.remove(i);
          }

        }
        for(int i=0;i<directors.size();i++) if(director.equals(directors.get(i).getName())) directors.remove(i);

        map.remove(director);

        return "success";

    }


    public String deleteAllDirectors() {

        for(Director director : directors){
          deleteDirectorByName(director.getName());
        }

        directors.clear();
        return "success";


    }
}
