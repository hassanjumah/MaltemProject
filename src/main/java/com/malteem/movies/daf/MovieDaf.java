package com.malteem.movies.daf;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malteem.movies.entities.Movie;
import com.malteem.movies.util.IFileJacksonUtil;

@Repository
@RepositoryRestResource
public class MovieDaf implements IDafMovie{
	public ArrayList<Movie> movies;
	public List<Movie> listmovies ;
	@Autowired
	IFileJacksonUtil util;

	@Override
	public ArrayList<Movie> getMovies() {
		return util.ReadFile();
	}
	@Override
	public List<Movie> getMovieByTitle(String title){
		movies = getMovies();
		listmovies = new ArrayList<Movie>();
		for(Movie m : movies) {
			if(m.getTitle().equalsIgnoreCase(title)) listmovies.add(m);
		}
		return listmovies;
	}
	@Override
	public List<Movie> getMovieByDirector(String director){
		movies = getMovies();
		listmovies = new ArrayList<Movie>();
		for(Movie m : movies) {
			if(m.getDirector().equalsIgnoreCase(director)) listmovies.add(m);
		}
		return listmovies;
	}
	@Override
	public List<Movie> getMovieByType(String type){
		movies = getMovies();
		listmovies = new ArrayList<Movie>();
		for(Movie m : movies) {
			if(m.getType().equalsIgnoreCase(type)) listmovies.add(m);
		}
		return listmovies;
	}
	@Override
	public List<Movie> getMovieByReleaseDate(String date){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		movies = getMovies();
		listmovies = new ArrayList<Movie>();
		for(Movie m : movies) {
			String d2 = df.format(m.getReleaseDate());
			if(date.equalsIgnoreCase(d2)) listmovies.add(m);
		}
		return listmovies;
	}
	@Override
	public void addMovie(Movie m) {
		ArrayList<Movie> movies = getMovies();
		movies.add(m);
		util.WriteFile(movies);
	}

	@Override
	public Movie updateMovie(Movie m) {
		removeMovie(m.getTitle());
		addMovie(m);
		return m;
	}

	@Override
	public void removeMovie(Movie m) {
		ArrayList<Movie> movies = getMovies();
		movies.remove(m);
		util.WriteFile( movies);
	}

	@Override
	public void removeMovie(String title) {	
		ArrayList<Movie> movies = getMovies();
		int idRemove;
		for(int i=0;i<movies.size();i++) {
			if(movies.get(i).getTitle().equals(title)) {
				movies.remove(i);
			}
		}
		util.WriteFile( movies);
	}
}
