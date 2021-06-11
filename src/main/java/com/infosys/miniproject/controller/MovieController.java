package com.infosys.miniproject.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.miniproject.domain.Movie;
import com.infosys.miniproject.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	
	private MovieService service;
	
	//call in service package
	@Autowired
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	//CREATE METHOD
	@PostMapping("/create")	
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		return new ResponseEntity<Movie>(this.service.createMovie(movie), HttpStatus.CREATED);
	}
	
	//GET SINGLE METHOD
	@GetMapping("/getOne/{index}")
	public ResponseEntity<Movie> getMovie(@PathVariable int index) {
		return ResponseEntity.ok(this.service.getMovie(index));
	}
	
	//GET ALL METHOD
	@GetMapping("/getAll")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(this.service.getAllMovies());
	}
	
	//DELETE METHOD
	@DeleteMapping("/remove/{index}")
	public ResponseEntity<Movie> removeMovie(@PathVariable int index) {
		return this.service.removeMovie(index) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//UPDATE METHOD
	@PutMapping("/replace/{index}")
	public ResponseEntity<Movie> updateVehicle(@PathVariable int index, @RequestBody Movie newMovie){
		this.service.updateMovie(index, newMovie);
		return new ResponseEntity<Movie>(newMovie, HttpStatus.ACCEPTED);
	}
	
	//PATCH UPDATE METHOD
	@PatchMapping("update/{index}")
	public ResponseEntity<Movie> updateAttribute(@PathParam("title") String title, @PathParam("genre") String genre, @PathParam("yearReleased") int yearReleased, @PathParam("rating") int rating, @PathVariable int index){
		
//		Movie updatedMovie = this.service.getMovie(index);
//		updatedMovie.setTitle(title);
//		updatedMovie.setGenre(genre);
//		updatedMovie.setYearReleased(yearReleased);
//		updatedMovie.setRating(rating);
//		
//		return new ResponseEntity<Movie>(updatedMovie, HttpStatus.ACCEPTED);
		return null;
	}
	
	
}
