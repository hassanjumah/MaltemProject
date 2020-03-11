package com.malteem.movies.RestWebService;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.malteem.movies.daf.IDafMovie;
import com.malteem.movies.entities.Movie;

@CrossOrigin(origins = "http://localhost:4200")
/*L'application du domaine http://localhost:4200 peut accéder a notre application rest
 * ou on peut mettre @CrossOrigin(origins = "*") si on veut autoriser tous les domaine fonctionnels
 * */
@RestController
public class MovieControllerRest implements IMovieControllerRest{

	@Autowired
	IDafMovie dafmovie;

	// Save
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
	public void addMovie(@RequestBody Movie m) {
		dafmovie.addMovie(m);
	}

	@GetMapping("/movies")
	@Override
	public List<Movie> getMovies() {
		return dafmovie.getMovies();
	}

	// Find by title
	@GetMapping("/movies/title/{title}")
	public List<Movie> SearchByTitle(@PathVariable String title){
		return dafmovie.getMovieByTitle(title);
	}

	// Find by type
	@GetMapping("/movies/type/{type}")
	public List<Movie> SearchByType(@PathVariable String type){
		return dafmovie.getMovieByType(type);
	}

	// Find by releasedate
	@GetMapping("/movies/date/{date}")
	public List<Movie> SearchByDate(@PathVariable String date){
		return dafmovie.getMovieByReleaseDate(date);
	}

	// Find by director
	@GetMapping("/movies/director/{director}")
	public List<Movie> SearchByDirector(@PathVariable String director){
		return dafmovie.getMovieByDirector(director);
	}


	@PutMapping("/movies")
	@Override
	public Movie updateMovie(@RequestBody Movie m) {
		return dafmovie.updateMovie(m);
	}

	@DeleteMapping("/movies/{title}")
	@Override
	public void removeMovie(@PathVariable String title) {
		dafmovie.removeMovie(title);
	}

}
