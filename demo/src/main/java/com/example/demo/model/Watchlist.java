package com.example.demo.model;

import java.util.UUID;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class Watchlist {
	public UUID Id;
    public boolean IsWatched;
    public UUID MovieId;
    public boolean IsActive = true;
	public UUID CreatedByUserId;
    public UUID UpdatedByUserId;
    public DateTime DateCreated;
    public DateTime DateUpdated;
    public Movie Movie;
    
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public boolean isIsWatched() {
		return IsWatched;
	}
	public void setIsWatched(boolean isWatched) {
		IsWatched = isWatched;
	}
	public UUID getMovieId() {
		return MovieId;
	}
	public void setMovieId(UUID movieId) {
		MovieId = movieId;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public UUID getCreatedByUserId() {
		return CreatedByUserId;
	}
	public void setCreatedByUserId(UUID createdByUserId) {
		CreatedByUserId = createdByUserId;
	}
	public UUID getUpdatedByUserId() {
		return UpdatedByUserId;
	}
	public void setUpdatedByUserId(UUID updatedByUserId) {
		UpdatedByUserId = updatedByUserId;
	}
	public DateTime getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(DateTime dateCreated) {
		DateCreated = dateCreated;
	}
	public DateTime getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(DateTime dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public Movie getMovie() {
		return Movie;
	}
	public void setMovie(Movie movie) {
		Movie = movie;
	}
}
