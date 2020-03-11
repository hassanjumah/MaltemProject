package com.malteem.movies.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malteem.movies.entities.Movie;

@Service	
public class FileJacksonUtil implements IFileJacksonUtil{

	static File f=new File("data/movies.json");
	@Override
	public void WriteFile(List<Movie> m) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(f,m);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Movie>  ReadFile() {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Movie> moviesList=new ArrayList<Movie>();
		try {
			List<Movie> movies = Arrays.asList(mapper.readValue(f, Movie[].class));
			moviesList=new ArrayList<Movie>(movies);
			return moviesList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesList;
	}





}
