package com.jam2in.spring.boot.sample.repository;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import org.apache.ibatis.annotations.Param;
import org.junit.*;
import org.junit.matchers.JUnitMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    /*
    // <-- JUNIT TEST OF PREVIOUS MOVIE_REPOSITORY-->>

    @Test
    public void insert() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("NewMovie");
        movieDto.setMovYear(2020);
        movieDto.setMovLang("Korean");

        // when
        movieRepository.insert(movieDto);

        // then
        MovieDto insertedMovieDto = movieRepository.select(movieDto.getId());
        Assert.assertEquals(movieDto.getMovName(), insertedMovieDto.getMovName());
        Assert.assertEquals(movieDto.getMovYear(), insertedMovieDto.getMovYear());
        Assert.assertEquals(movieDto.getMovLang(), insertedMovieDto.getMovLang());
    }

    @Test
    public void update() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Brave");
        movieDto.setMovYear(2012);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        // when
        movieRepository.update(movieDto.getId(), movieDto);

        // then
        MovieDto updatedMovieDTO = movieRepository.select(movieDto.getId());
        Assert.assertEquals(movieDto.getMovName(), updatedMovieDTO.getMovName());
        Assert.assertEquals(movieDto.getMovYear(), updatedMovieDTO.getMovYear());
        Assert.assertEquals(movieDto.getMovLang(), updatedMovieDTO.getMovLang());
    }

    @Test
    public void delete() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Vertigo");
        movieDto.setMovYear(1958);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        // when
        movieRepository.delete(movieDto.getId());

        // then
        MovieDto deletedMovieDTO = movieRepository.select(movieDto.getId());
        Assert.assertNull(deletedMovieDTO);
    }

    @Test
    public void select() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Parasite");
        movieDto.setMovYear(2019);
        movieDto.setMovLang("Korean");
        movieRepository.insert(movieDto);

        // when
        movieRepository.select(movieDto.getId());

        // then
        MovieDto selectedMovieDTO = movieRepository.select(movieDto.getId());
        Assert.assertNotNull(selectedMovieDTO);
    }

    @Test
    public void selectByIdAndName() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Amadeus");
        movieDto.setMovYear(1984);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        // when
        MovieDto selectedByIdAndNameMovieDTO =
                movieRepository.selectByIdAndName(movieDto.getId(), movieDto.getMovName());

        // then
        Assert.assertEquals(movieDto.getMovName(), selectedByIdAndNameMovieDTO.getMovName());
    }

    @Test
    public void selectAll() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Amadeus");
        movieDto.setMovYear(1984);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        MovieDto movieDto2 = new MovieDto();
        movieDto2.setMovName("Brave");
        movieDto2.setMovYear(2012);
        movieDto2.setMovLang("English");
        movieRepository.insert(movieDto2);

        MovieDto movieDto3 = new MovieDto();
        movieDto3.setMovName("Movie3");
        movieDto3.setMovYear(2020);
        movieDto3.setMovLang("English");
        movieRepository.insert(movieDto3);

        // when
        List<MovieDto> selectedAllMovieDTO = movieRepository.selectAll();

        // then

        int size = selectedAllMovieDTO.size();
        Assert.assertEquals(3, size);
        for (int i = 0; i < size; i++) {
            MovieDto selectedMovie = selectedAllMovieDTO.get(i);


            if (i == 0) {
                // compare movieDto with first selectedMovie
                Assert.assertEquals(movieDto.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto.getMovLang(), selectedMovie.getMovLang());
            } else if (i == 1) {
                // compare movieDto2 with second selectedMovie
                Assert.assertEquals(movieDto2.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto2.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto2.getMovLang(), selectedMovie.getMovLang());
            } else if (i == 2) {
                // compare movieDto3 with third selectedMovie
                Assert.assertEquals(movieDto3.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto3.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto3.getMovLang(), selectedMovie.getMovLang());
            }
        }
    }

    @Test
    public void selectAllByLang() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Amadeus");
        movieDto.setMovYear(1984);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        MovieDto movieDto2 = new MovieDto();
        movieDto2.setMovName("Brave");
        movieDto2.setMovYear(2012);
        movieDto2.setMovLang("English");
        movieRepository.insert(movieDto2);

        MovieDto movieDto3 = new MovieDto();
        movieDto3.setMovName("Movie3");
        movieDto3.setMovYear(2020);
        movieDto3.setMovLang("Korean");
        movieRepository.insert(movieDto3);

        // when
        List<MovieDto> selectedAllByLangMovieDTO =
                movieRepository.selectAllByLang("English");

        // then
        int size = selectedAllByLangMovieDTO.size();
        Assert.assertEquals(2,size);
        for (int i = 0; i < size; i++) {
            MovieDto selectedMovie = selectedAllByLangMovieDTO.get(i);

            if (i == 0) {
                // compare movieDto with first selectedMovie
                Assert.assertEquals(movieDto.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto.getMovLang(), selectedMovie.getMovLang());
            } else if (i == 1) {
                // compare movieDto2 with second selectedMovie
                Assert.assertEquals(movieDto2.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto2.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto2.getMovLang(), selectedMovie.getMovLang());
            }
        }
    }

    @Test
    public void selectAllByYear() {
        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Amadeus");
        movieDto.setMovYear(1984);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        MovieDto movieDto2 = new MovieDto();
        movieDto2.setMovName("Brave");
        movieDto2.setMovYear(2012);
        movieDto2.setMovLang("English");
        movieRepository.insert(movieDto2);

        MovieDto movieDto3 = new MovieDto();
        movieDto3.setMovName("Movie3");
        movieDto3.setMovYear(2012);
        movieDto3.setMovLang("Korean");
        movieRepository.insert(movieDto3);

        // when
        List<MovieDto> selectedAllByYearMovieDTO =
                movieRepository.selectAllByYear(2012);

        // then
        int size = selectedAllByYearMovieDTO.size();
        Assert.assertEquals(2,size);
        for (int i = 0; i < size; i++) {
            MovieDto selectedMovie = selectedAllByYearMovieDTO.get(i);

            if (i == 0) {
                // compare movieDto with first selectedMovie
                Assert.assertEquals(movieDto2.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto2.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto2.getMovLang(), selectedMovie.getMovLang());
            } else if (i == 1) {
                // compare movieDto2 with second selectedMovie
                Assert.assertEquals(movieDto3.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto3.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto3.getMovLang(), selectedMovie.getMovLang());
            }
        }
    }

    @Test
    public void selectAllByName() {

        // given
        MovieDto movieDto = new MovieDto();
        movieDto.setMovName("Amadeus");
        movieDto.setMovYear(1984);
        movieDto.setMovLang("English");
        movieRepository.insert(movieDto);

        MovieDto movieDto2 = new MovieDto();
        movieDto2.setMovName("Brave");
        movieDto2.setMovYear(2012);
        movieDto2.setMovLang("English");
        movieRepository.insert(movieDto2);

        MovieDto movieDto3 = new MovieDto();
        movieDto3.setMovName("Movie3");
        movieDto3.setMovYear(2012);
        movieDto3.setMovLang("Korean");
        movieRepository.insert(movieDto3);

        // when
        List<MovieDto> selectedAllByNameMovieDTO =
                movieRepository.selectAllByName("Amadeus");

        // then
        int size = selectedAllByNameMovieDTO.size();
        Assert.assertEquals(1, size);
        for (int i = 0; i < size; i++) {
            MovieDto selectedMovie = selectedAllByNameMovieDTO.get(i);
            if (i == 0) {
                // compare movieDto with first selectedMovie
                Assert.assertEquals(movieDto.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto.getMovLang(), selectedMovie.getMovLang());
            } else if (i == 1) {
                // compare movieDto2 with second selectedMovie
                Assert.assertEquals(movieDto2.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto2.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto2.getMovLang(), selectedMovie.getMovLang());
            } else if (i == 2) {
                // compare movieDto3 with third selectedMovie
                Assert.assertEquals(movieDto3.getMovName(), selectedMovie.getMovName());
                Assert.assertEquals(movieDto3.getMovYear(), selectedMovie.getMovYear());
                Assert.assertEquals(movieDto3.getMovLang(), selectedMovie.getMovLang());
            }
        }
    }
     */
}