package com.infosys.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.miniproject.domain.Movie;

@RestController
public class MovieController {
	
	
	private List<Movie> movies = new ArrayList<>();
	
	@PostMapping("/create")
	public String createMovie(@RequestBody Movie movie) {
		this.movies.add(movie);
		return "Successfully Added Movie!";
	}

	@GetMapping("/getOne/{index}")
	public Movie getMovie(@PathVariable int index) {
		return this.movies.get(index);
	}
	
	@GetMapping("/getAll")
	public List<Movie> getAllMovies(){
		return this.movies;
	}
	
	@DeleteMapping("/remove/{index}")
	public Movie removeMovie(@PathVariable int index) {
		return this.movies.get(index);
	}
	
	
}
