package com.jam2in.spring.boot.sample.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    // TODO: must test all of apis in MovieService.

}