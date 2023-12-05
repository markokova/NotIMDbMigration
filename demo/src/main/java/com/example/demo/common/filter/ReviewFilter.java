package com.example.demo.common.filter;

import java.util.UUID;

import com.fasterxml.jackson.databind.util.ClassUtil.Ctor;

public class ReviewFilter {
	
	public Integer Score;
	public String FilterString;
	public UUID MovieId;
	
	public ReviewFilter(Integer score, String filterString, UUID movieId)
    {
        Score = score;
        FilterString = filterString;
        MovieId = movieId;
    }
    public int getScore() { 
    	return Score;
    }
    
    public void setScore(int score) {
    	Score = score;
    }
	public String getFilterString() {
		return FilterString;
	}
	public void setFilterString(String filterString) {
		FilterString = filterString;
	}
	public UUID getMovieId() {
		return MovieId;
	}
	public void setMovieId(UUID movieId) {
		MovieId = movieId;
	}
    


}
