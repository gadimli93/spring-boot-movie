package com.jam2in.spring.boot.sample.controller;

import com.jam2in.spring.boot.sample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @Autowired
  private ProductService productService;

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("movies", productService.getAll());
    return "index";
  }

}
