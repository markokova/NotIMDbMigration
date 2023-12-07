package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<MovieView> getMovies(@RequestParam(required = false) String genreId, @RequestParam(required = true) int currentPage, @RequestParam(required = true) int pageSize) throws Exception{
		MovieFilter filter = new MovieFilter();
		if(genreId != null) {
			filter.GenreId = UUID.fromString(genreId);
		}
		Pageable pageable = (Pageable)PageRequest.of(currentPage, pageSize);
		
		List<MovieView> result = _movieRepository.getMovies(filter, pageable);
		
		return result;
	}
	
//	@PostMapping("/api/Movie/create")
//	public String createMovie() {
//		return "";
//	}
//	
//	@PutMapping("api/Movie/update")
//	public String updateMovie() {
//		return "";
//	}
//	
//	@DeleteMapping("api/Movie/delete")
//	public String deleteMovie() {
//		return "";
//	}
	
}
