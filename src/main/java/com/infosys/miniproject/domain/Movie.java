package com.infosys.miniproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String genre;
	private int yearReleased;
	private int rating;
	
	public Movie() {
	}
	
	public Movie(String title, String genre, int yearReleased, int rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.yearReleased = yearReleased;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getYearReleased() {
		return yearReleased;
	}
	
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
}
