//package com.jam2in.spring.boot.sample.service;
//
//import com.jam2in.spring.boot.sample.dto.MovieDto;
//import com.jam2in.spring.boot.sample.repository.MovieRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestConfiguration
//public class MovieServiceTest {
//
//    @Bean
//    public MovieService movieService() {
//
//        return new MovieService();
//    }
//
//    @Autowired
//    private MovieService movieService;
//
//    @MockBean
//    private MovieRepository movieRepository;
//
//    // TODO: must test all of apis in MovieService.
//    @Test
//    public void create() {
//      // given
//        MovieDto movieDto = new MovieDto();
//        movieDto.setMovName("NewMovie");
//        movieDto.setMovYear(2020);
//        movieDto.setMovLang("Korean");
////        Mockito.when(movieRepository.insert(movieDto));
//
//        // when
//        movieService.create(movieDto);
//
//        // then
//        MovieDto createdMovieDto = movieService.create();
//        Assert.assertEquals(movieDto.getMovName(), createdMovieDto.getMovName());
//        Assert.assertEquals(movieDto.getMovYear(), createdMovieDto.getMovYear());
//        Assert.assertEquals(movieDto.getMovLang(), createdMovieDto.getMovLang());
//
//    }
//    @Test
//    public void update() {
//        // given
//        MovieDto movieDto = new MovieDto();
//        movieDto.setMovName("NewMovie");
//        movieDto.setMovYear(2020);
//        movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getId()))
//                .thenReturn(movieDto);
//
//        // when
//
//        // then
//
//    }
//    @Test
//    public void delete() {
//        // given
//        MovieDto movieDto = new MovieDto();
//        movieDto.setMovName("NewMovie");
//        movieDto.setMovYear(2020);
//        movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getId()))
//                .thenReturn(movieDto);
//
//        // when
//
//
//        // then
//
//    }
//    @Test
//    public void get() {
//        // given
//        MovieDto movieDto = new MovieDto();
//        movieDto.setMovName("NewMovie");
//        movieDto.setMovYear(2020);
//        movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getId()))
//                .thenReturn(movieDto);
//
//        // when
//
//
//        // then
//
//    }
//
//    @Test
//    public void getAll() {
//        // given
//        MovieDto movieDto = new MovieDto();
//        movieDto.setMovName("NewMovie");
//        movieDto.setMovYear(2020);
//        movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getId()))
//                .thenReturn(movieDto);
//
//        // when
//
//
//        // then
//
//    }
//
//    @Test
//    public void getAllByLang() {
//        // given
//        MovieDto movieDto = new MovieDto();
////        movieDto.setMovName("NewMovie");
////        movieDto.setMovYear(2020);
//        movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getMovLang()))
//                .thenReturn(movieDto);
//
//        // when
//
//
//        // then
//
//    }
//    @Test
//    public void getAllByYear() {
//        // given
//        MovieDto movieDto = new MovieDto();
////        movieDto.setMovName("NewMovie");
//        movieDto.setMovYear(2020);
////        movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getMovYear()))
//                .thenReturn(movieDto);
//
//        // when
//
//
//        // then
//
//    }
//
//    @Test
//    public void getAllByName() {
//        // given
//        MovieDto movieDto = new MovieDto();
//        movieDto.setMovName("NewMovie");
////       movieDto.setMovYear(2020);
////       movieDto.setMovLang("Korean");
//        Mockito.when(movieRepository.insert(movieDto.getMovName()))
//                .thenReturn(movieDto);
//
//        // when
//
//
//        // then
//
//    }
//}