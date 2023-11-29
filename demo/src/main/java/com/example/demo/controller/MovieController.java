package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.MovieRepository;

@RestController
public class MovieController {
	
	private MovieRepository _movieRepository = new MovieRepository();

	
	@GetMapping("/movies")
	public String getMovies() throws Exception {
		String result = _movieRepository.getMovies();
		return result;
	}
}
