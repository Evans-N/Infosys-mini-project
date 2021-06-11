package com.infosys.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.miniproject.domain.Movie;

@RestController
public class MovieController {
	
	
	private List<Movie> movies = new ArrayList<>();
	
	@PostMapping("/create")	
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		this.movies.add(movie);
		Movie added = this.movies.get(this.movies.size() -1);
		return new ResponseEntity<Movie>(added, HttpStatus.CREATED);
	}

	@GetMapping("/getOne/{index}")
	public ResponseEntity<Movie> getMovie(@PathVariable int index) {
		return ResponseEntity.ok(this.movies.get(index));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(this.movies);
	}
	
	
	@DeleteMapping("/remove/{index}")
	public Movie removeMovie(@PathVariable int index) {
		return this.movies.get(index);
	}
	
	@PutMapping("/update/{index}")
	public ResponseEntity<Movie> updateMovie(@PathVariable int index, @RequestBody Movie newMovie) {
		this.movies.set(index,  newMovie);
		return new ResponseEntity<Movie>(newMovie, HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("update/{index}")
	public ResponseEntity<Movie> updateAttribute(@PathParam("title") String title, @PathParam("genre") String genre, @PathParam("yearReleased") int yearReleased, @PathParam("rating") int rating, @PathVariable int index){
		
		Movie updatedMovie = this.movies.get(index);
		updatedMovie.setTitle(title);
		updatedMovie.setGenre(genre);
		updatedMovie.setYearReleased(yearReleased);
		updatedMovie.setRating(rating);
		
		return new ResponseEntity<Movie>(updatedMovie, HttpStatus.ACCEPTED);
	}
	
	
}
