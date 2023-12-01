package com.example.demo.rest_model.movie_rest;

import java.util.UUID;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class MovieRestGet {
    public UUID Id;
    public String Title;
    public int Runtime;
    public String Image;
    public DateTime YearOfRelease;
    public String Actors;
    public String Genres;
    public double AverageScore;
    
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getRuntime() {
		return Runtime;
	}
	public void setRuntime(int runtime) {
		Runtime = runtime;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public DateTime getYearOfRelease() {
		return YearOfRelease;
	}
	public void setYearOfRelease(DateTime yearOfRelease) {
		YearOfRelease = yearOfRelease;
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
