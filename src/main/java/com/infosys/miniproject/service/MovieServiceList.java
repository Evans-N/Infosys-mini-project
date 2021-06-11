package com.infosys.miniproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infosys.miniproject.domain.Movie;

@Service
public class MovieServiceList {

	private List<Movie> movies;

	public MovieServiceList(List<Movie> movies) {
		this.movies = movies;
	}

	public Movie createMovie(Movie movie) {
		this.movies.add(movie);
		Movie added = this.movies.get(this.movies.size() - 1);
		return added;
	}

	public List<Movie> getAllMovies() {
		return this.movies;
	}

	public Movie getMovie(int index) {
		return this.movies.get(index);
	}

	public boolean removeMovie(int index) {
		this.movies.remove(index);
		return true;
	}

	public Movie updateMovie(int index, Movie newMovie) {
		this.movies.set(index, newMovie);
		return newMovie;
	}
}
