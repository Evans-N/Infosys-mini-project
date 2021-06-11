package com.infosys.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.infosys.miniproject.domain.Movie;
import com.infosys.miniproject.repo.MovieRepo;

@Service
public class MovieService {
	
	private MovieRepo repo;
	
	public MovieService(MovieRepo repo) {
		this.repo = repo;
	}
	
	public Movie createMovie(Movie m) {
		return this.repo.save(m);
	}
	
	public List<Movie> getAllMovies(){
		return this.repo.findAll();
	}
	
	public Movie getMovie(Long id) {
		Optional<Movie> m = this.repo.findById(id);
		return m.get();
	}
	
	public boolean removeMovie(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	public Movie updateMovie(Long id, Movie newMovie) {
		Movie exists = this.getMovie(id);
		exists.setTitle(newMovie.getTitle());
		exists.setGenre(newMovie.getGenre());
		exists.setYearReleased(newMovie.getYearReleased());
		exists.setRating(newMovie.getRating());
		
		Movie updated = this.repo.save(exists);
		return updated;
	}
}
