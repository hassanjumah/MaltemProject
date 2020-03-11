package com.malteem.movies;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.malteem.movies.daf.IDafMovie;
import com.malteem.movies.entities.Movie;

@SpringBootApplication
@ComponentScan(basePackages = {"com.malteem.movies"})
public class MoviesApplication  {

	@Autowired
	IDafMovie daf;

	static File file = new File("data/test.json");

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	
	
	
	}
