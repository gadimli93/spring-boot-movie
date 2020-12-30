package com.jam2in.spring.boot.sample.service;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import com.jam2in.spring.boot.sample.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public MovieDto create(MovieDto movieDto) {
    movieRepository.insert(movieDto);
    return movieDto;
  }

  public MovieDto update(long id, MovieDto movieDto) {
    movieRepository.update(id, movieDto);
    movieDto.setId(id);
    return movieDto;
  }

  public void delete(long id) {
    movieRepository.delete(id);
  }

  public MovieDto get(long id) {
    return movieRepository.select(id);
  }

  public List<MovieDto> getAll(String movName, Integer movYear, String movLang) {
    return movieRepository.selectAll(movName, movYear, movLang);
  }

}
