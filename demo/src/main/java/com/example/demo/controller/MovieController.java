package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.filter.MovieFilter;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieView;
import com.example.demo.repository.MovieRepository;

@RestController
public class MovieController {
	
	@Autowired
	private MovieRepository _movieRepository;
	
	@CrossOrigin(origins = "https://localhost:3000")
	@GetMapping("/api/Movie")
	public List<MovieView> getMovies(@RequestParam(required = false) String genreId) throws Exception{
		MovieFilter filter = new MovieFilter();
		if(genreId != null) {
			filter.GenreId = UUID.fromString(genreId);
		}
		
		List<MovieView> result = _movieRepository.getMovies(filter);
		
		//List<MovieView> result = new ArrayList<MovieView>();
		return result;
	}
}
