package com.jam2in.spring.boot.sample.repository;

import com.jam2in.spring.boot.sample.dto.MovieDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    //public static int add(int a, int b) {
       // return a + b;
    //}

    // @Before => @Test => @After
    @Before
    public void before() {
    }

    // @Before => @Test => @After
    @After
    public void after() {
    }

    // TODO: must test all of apis in MovieRepository.

    //@Test
     //public void addTest() {
                /*
        MovieDto movieDto = new MovieDto();
        movieDto.setMovLang("English");
        movieDto.setMovName("ABC");
        movieDto.setMovYear(1998);
        movieRepository.insert(movieDto);
         */

     /*   int a = add(3, 4);

        Assert.assertEquals(a, 7);
    } */

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void select() {
    }

    @Test
    public void selectByIdAndName() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void selectAllByLang() {
    }

    @Test
    public void selectAllByYear() {
    }

}