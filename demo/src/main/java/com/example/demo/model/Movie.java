package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class Movie {
	public UUID Id;
    public String Title; 
    public int Runtime; 
    public String Image; 
    public List<UUID> ActorIds; 
    public List<UUID> GenreIds; 
    public boolean IsActive  = true;
    public double AverageScore; 
    public Date YearOfRelease; 
    public UUID CreatedByUserId; 
    public UUID UpdatedByUserId;
    public DateTime DateCreated; 
    public Date DateUpdated;
    
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
	public List<UUID> getActorIds() {
		return ActorIds;
	}
	public void setActorIds(List<UUID> actorIds) {
		ActorIds = actorIds;
	}
	public List<UUID> getGenreIds() {
		return GenreIds;
	}
	public void setGenreIds(List<UUID> genreIds) {
		GenreIds = genreIds;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public double getAverageScore() {
		return AverageScore;
	}
	public void setAverageScore(double averageScore) {
		AverageScore = averageScore;
	}
	public Date getYearOfRelease() {
		return YearOfRelease;
	}
	public void setYearOfRelease(Date date) {
		YearOfRelease = date;
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
	public Date getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(Date date) {
		DateUpdated = date;
	}
}

//shift + alt + s => Generate getters and setters