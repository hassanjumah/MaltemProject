package com.malteem.movies.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.malteem.movies.entities.Movie;

	
public interface IFileJacksonUtil {


	ArrayList<Movie> ReadFile();
	void WriteFile(List<Movie> m);
}
