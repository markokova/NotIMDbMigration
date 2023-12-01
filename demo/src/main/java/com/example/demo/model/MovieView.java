package com.example.demo.model;

public class MovieView {
    public Movie Movie;
    public String Actors;
    public String Genres;
    public double AverageScore;
    
	public Movie getMovie() {
		return Movie;
	}
	public void setMovie(Movie movie) {
		Movie = movie;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getGenres() {
		return Genres;
	}
	public void setGenres(String genres) {
		Genres = genres;
	}
	public double getAverageScore() {
		return AverageScore;
	}
	public void setAverageScore(double averageScore) {
		AverageScore = averageScore;
	}
}
