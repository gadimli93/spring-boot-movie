package com.jam2in.spring.boot.sample.controller;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import com.jam2in.spring.boot.sample.service.MovieService;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

  @Autowired
  private MovieService movieService;

 //localhost:8080/movies/getall
  @RequestMapping("/movies/getall")
  public String index(Model model) {
  model.addAttribute("movies", movieService.getAll());
  return "index";
 }

 /* //localhost:8080/movies/?movLang=
  @RequestMapping ("/movies/?movLang=English")
  public String index (Model model, @RequestParam String movLang) {
    model.addAttribute("movies", movieService.getAllByLang(movLang));
    return "index";
  }*/

}
