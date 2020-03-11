package com.malteem.movies.daf;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.malteem.movies.entities.Movie;


public interface IDafMovie {

	public void addMovie(Movie m);
	List<Movie> getMovies();
	Movie updateMovie( Movie m);
	void removeMovie(Movie m);
	void removeMovie(String title);
	public List<Movie> getMovieByTitle(String title);
	public List<Movie> getMovieByDirector(String director);
	public List<Movie> getMovieByReleaseDate(String date);
	public List<Movie> getMovieByType(String Type);
}
