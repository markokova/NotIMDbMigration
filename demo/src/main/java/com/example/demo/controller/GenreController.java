package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Genre;
import com.example.demo.repository.GenreRepository;

@RestController
public class GenreController {
	
	@Autowired
	GenreRepository genreRepository;
	
	@CrossOrigin(origins = "https://localhost:3000")
	@GetMapping("/api/Genre")
	public List<Genre> getGenres() {
		
		List<Genre> result =  genreRepository.getGenres();
		
		return result;
	}
}
