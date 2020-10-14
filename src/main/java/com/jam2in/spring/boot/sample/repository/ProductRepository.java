package com.jam2in.spring.boot.sample.repository;

import com.jam2in.spring.boot.sample.dto.ProductDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

  int insert(ProductDto movie);

  void update(@Param("id") long id, @Param("movie") ProductDto productDto);

  void delete(long id);

  ProductDto select(long id);

  ProductDto selectByIdAndName(@Param("id") long id, @Param("movName") String movName, @Param("movYear") Integer movYear, @Param("movLang") String movLang);

  List<ProductDto> selectAll();

}
