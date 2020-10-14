package com.jam2in.spring.boot.sample.controller;

import com.jam2in.spring.boot.sample.dto.ProductDto;
import com.jam2in.spring.boot.sample.service.ProductService;
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
public class ProductController {

  @Autowired
  private ProductService productService;

  // POST http://localhost:8080/movies
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  @ResponseBody
  public ProductDto create(@RequestBody ProductDto productDto) {
    return productService.create(productDto);
  }

  // PUT http://localhost:8080/movies/{id}
  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public ProductDto update(@PathVariable long id,
                           @RequestBody ProductDto productDto) {
    return productService.update(id, productDto);
  }

  // DELETE http://localhost:8080/movies/{id}
  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void delete(@PathVariable long id) {
    productService.delete(id);
  }

  // GET http://localhost:8080/movies/{id}
  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public ProductDto get(@PathVariable long id) {
    return productService.get(id);
  }

  // GET http://localhost:8080/movies/{movName}/{movYear}/{movLang}/{id}
  @GetMapping("/{movName}/{movYear}/{movLang}/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public ProductDto getByIdAndName(@PathVariable long id, @PathVariable String movName, @PathVariable Integer movYear, @PathVariable String movLang) {
    ProductDto productDto = new ProductDto();
    productDto.setId(id);
    productDto.setMovName(movName);
    productDto.setMovYear(movYear);
    productDto.setMovLang(movLang);
    return productService.getByDto(productDto);
  }

  // GET http://localhost:8080/movies
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  public List<ProductDto> getAll() {
    return productService.getAll();
  }

}
