package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.filter.MovieFilter;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieView;
import com.example.demo.repository.MovieRepository;

@RestController
public class MovieController {
	
	@Autowired
	private MovieRepository _movieRepository;
	
	
	@GetMapping("/movies")
	public List<MovieView> getMovies(){
		MovieFilter filter = new MovieFilter();
		
		List<MovieView> result = _movieRepository.getMovies(filter);

		return result;
	}
	
	
}
