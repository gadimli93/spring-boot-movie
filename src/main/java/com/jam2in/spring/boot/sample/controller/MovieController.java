package com.jam2in.spring.boot.sample.controller;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import com.jam2in.spring.boot.sample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

// @Bean, @Controller, @Service, @Repository, @Configuration, @Component
@Controller
@RequestMapping("/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  // POST http://localhost:8080/movies
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  @ResponseBody
  public MovieDto create(@RequestBody MovieDto movieDto) {
    return movieService.create(movieDto);
  }

  // PUT http://localhost:8080/movies/{id}
  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public MovieDto update(@PathVariable long id,
                           @RequestBody MovieDto movieDto) {
    return movieService.update(id, movieDto);
  }

  // DELETE http://localhost:8080/movies/{id}
  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void delete(@PathVariable long id) {
    movieService.delete(id);
  }

  // GET http://localhost:8080/movies/{id}
  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public MovieDto get(@PathVariable long id) {
    return movieService.get(id);
  }

  // GET http://localhost:8080/movies/{movName}/{movYear}/{movLang}/{id}
  @GetMapping("/{movName}/{movYear}/{movLang}/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public MovieDto getByIdAndName(@PathVariable long id, @PathVariable String movName,
                                 @PathVariable Integer movYear, @PathVariable String movLang) {
    MovieDto movieDto = new MovieDto();
    movieDto.setId(id);
    movieDto.setMovName(movName);
    movieDto.setMovYear(movYear);
    movieDto.setMovLang(movLang);
    return movieService.getByDto(movieDto);
  }

  /* // GET http://localhost:8080/movies
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public List<MovieDto> getAll() {
    return movieService.getAll();
  } */

  //GET http://localhost:8080/movies/?movLang=
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public List<MovieDto> getAllByLang() {
    return movieService.getAllByLang("Korean");
  }
  }
