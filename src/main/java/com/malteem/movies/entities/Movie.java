package com.malteem.movies.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class Movie implements Serializable{

	String title;
	String director;
	 @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern =  "dd/MM/yyyy", timezone="UTC")

	Date releaseDate;
	String type;
	
	
	 public Movie() {
		super();
	}


	public Movie(String title, String director, Date releaseDate, String type) {
		super();
		this.title = title;
		this.director = director;
		this.releaseDate = releaseDate;
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	    public String toString() {
		String pattern = "dd/MM/YYYY";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(releaseDate);
	        return '{' +
	                "\n title='" + title + "\',"+ System.lineSeparator() +
	                " director='" + director + "\',"+ System.lineSeparator() +
	                " releaseDate='" + date +"\',"+ System.lineSeparator() +
	                " type='" + type +"\',"+ System.lineSeparator() +
	                '}';
	    }

	   
}
