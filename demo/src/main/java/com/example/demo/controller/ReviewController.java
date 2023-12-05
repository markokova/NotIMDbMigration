package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.filter.ReviewFilter;
import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@RestController
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;
	
	@CrossOrigin(origins = "https://localhost:3000")
	@GetMapping("/api/Review")
	public List<Review> getReviews(@RequestParam(required = false) String filterString, @RequestParam(required = false) String movieId, @RequestParam(required = false) Integer score) {
	
	ReviewFilter filter = new ReviewFilter(score, filterString, movieId != null ? UUID.fromString(movieId) : null);
		
	List<Review> result = new ArrayList<Review>();
	
	result = reviewRepository.getReviews(filter);
		
	return result;	
	}
	
	
	@PostMapping()
	public String postReview() {
		return "";
	}
}
