package com.jam2in.spring.boot.sample.repository;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import net.bytebuddy.matcher.StringMatcher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {

  int insert(MovieDto movie);

  void update(@Param("id") long id, @Param("movie") MovieDto movieDto);

  void delete(long id);

  MovieDto select(long id);

  MovieDto selectByIdAndName(@Param("id") long id, @Param("movName") String movName,
                             @Param("movYear") Integer movYear, @Param("movLang") String movLang);
  List<MovieDto> selectAll();

  List<MovieDto> selectAllByLang(String movLang);

  List<MovieDto> selectAllByYear(Integer movYear);

}
