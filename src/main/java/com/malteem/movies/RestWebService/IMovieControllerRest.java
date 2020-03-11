package com.malteem.movies.RestWebService;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.malteem.movies.entities.Movie;

public interface IMovieControllerRest {
	public void addMovie( Movie m);
	List<Movie> getMovies();
	public List<Movie> SearchByTitle(String title);
	public List<Movie> SearchByDirector(String director);
	public List<Movie> SearchByType(String type);
	public List<Movie> SearchByDate(String date);
	Movie updateMovie(Movie m);
	void removeMovie(String title);
}
