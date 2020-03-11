package com.malteem.movies;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.malteem.movies.RestWebService.IMovieControllerRest;
import com.malteem.movies.entities.Movie;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesApplicationTests {


	@Autowired
	IMovieControllerRest controller;
	
	List<Movie> movies, movies_before,movies_after;
	@Test
	public void getMoviesList() throws Exception {
	
		 movies=controller.getMovies();
		assertTrue(movies.size()>0);
		
	}
	
	@Test
	public void addMovie()  throws Exception {
		
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 df.setTimeZone(TimeZone.getTimeZone("UTC"));
		 Date date = df.parse("31/03/2020");
		 Movie m=new Movie("Impossible", "USA",date, "Drama");
		 movies_before=controller.getMovies();
		 int size_before=movies_before.size();
		 controller.addMovie( m);
		 movies_after=controller.getMovies();
		 int size_after=movies_after.size();
		 assertEquals(size_before+1,size_after);
		 
	}
	
	@Test
	public void updateMovie()  throws Exception {
		
		 movies_before=controller.getMovies();
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 df.setTimeZone(TimeZone.getTimeZone("UTC"));
		 Date date = df.parse("05/04/2020");
		 Movie m_n=new Movie("Lion", "America", date, "Adventure");
		 
		 controller.updateMovie(m_n);
	}
	
	@Test
	public void RemoveMovie()  throws Exception {
		
		 movies_before=controller.getMovies();
		 int size_before=movies_before.size();
         controller.removeMovie("Lion");
		 movies_after=controller.getMovies();
		 int size_after=movies_after.size();
		 assertEquals(size_before-1,size_after);
 
	}
	@Test
	public void TestfindByTitle() throws Exception {
		 movies =controller.getMovies();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= controller.SearchByTitle("Bandia");
		System.out.println("I find movie "+ foundMovie);

	}
	@Test
	public void TestfindByType() throws Exception {
	 movies=controller.getMovies();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= controller.SearchByType("Drama");
		System.out.println("I find movie by type"+ foundMovie);

	}
	@Test
	public void TestfindByDirector() throws Exception {
		 movies=controller.getMovies();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= controller.SearchByDirector("Said Naciri");
		System.out.println("I find movie by director"+ foundMovie);
	}
	@Test
	public void TestfindByReleaseDate() throws Exception {
		movies=controller.getMovies();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= controller.SearchByDate("01/06/1994");
		System.out.println("I find movie by ReleaseDate"+ foundMovie);
	}
}
