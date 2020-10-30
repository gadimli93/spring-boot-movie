package com.jam2in.spring.boot.sample.controller;

import com.jam2in.spring.boot.sample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

  @Autowired
  private MovieService movieService;

  // localhost:8080/?movLang=English
  @RequestMapping("/")
  public String index(Model model, @RequestParam String movLang) {
    model.addAttribute("movies", movieService.getAllByLang(movLang));
    return "index";
  }

}
