package com.jam2in.spring.boot.sample.service;

import com.jam2in.spring.boot.sample.dto.ProductDto;
import com.jam2in.spring.boot.sample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public ProductDto create(ProductDto productDto) {
    productRepository.insert(productDto);
    return productDto;
  }

  public ProductDto update(long id, ProductDto productDto) {
    productRepository.update(id, productDto);
    productDto.setId(id);
    return productDto;
  }

  public void delete(long id) {
    productRepository.delete(id);
  }

  public ProductDto get(long id) {
    return productRepository.select(id);
  }

  public ProductDto get(long id, String movName, Integer movYear, String movLang) {
    return productRepository.selectByIdAndName(id, movName, movYear,movLang);
  }

  public ProductDto getByDto(ProductDto productDto) {
    return productRepository.selectByIdAndName(productDto.getId(), productDto.getMovName(), productDto.getMovYear(), productDto.getMovLang());
  }

  public List<ProductDto> getAll() {
    return productRepository.selectAll();
  }

}
