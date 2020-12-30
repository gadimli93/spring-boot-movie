package com.jam2in.spring.boot.sample.controller;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import com.jam2in.spring.boot.sample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

  @Autowired
  private MovieService movieService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getMovies(@RequestParam(required = false) String movLang,
                          @RequestParam(required = false) String movName,
                          @RequestParam(required = false) Integer movYear, Model model) {
    
    List<MovieDto> movies = movieService.getAll(movName, movYear, movLang);
    model.addAttribute("movies", movies);
    return "index";       // response with the index.html page
  }

  @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
  public String getMovie(@PathVariable long id, Model model) {
    MovieDto movie = movieService.get(id);

    model.addAttribute("movie", movie);
    return "update";     // response with the update.html page
  }

  @RequestMapping(value = "/movies/create", method = RequestMethod.GET)
  public String createMovie() {
    return "create";     // response with the create.html page
  }

  @RequestMapping(value = "/movies/create.do", method = RequestMethod.POST)
  public String doCreateMovie(@ModelAttribute MovieDto movie) {
    movieService.create(movie);

    return "redirect:/"; // redirect to the root('/') url.
  }

  @RequestMapping(value = "/movies/update.do", method = RequestMethod.POST)
  public String doUpdateMovie(@ModelAttribute MovieDto movie) {
    movieService.update(movie.getId(), movie);

    return "redirect:/"; // redirect to the root('/') url.
  }

  @RequestMapping(value = "/movies/delete.do", method = RequestMethod.POST)
  public String doDeleteMovie(@ModelAttribute MovieDto movie) {
    movieService.delete(movie.getId());

    return "redirect:/"; // redirect to the root('/') url.
  }
}
