package com.example.demo.model;

import java.util.UUID;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class Actor {
    public UUID Id;
    public String FirstName;
    public String LastName;
    public String Bio;
    public String Image;
    public boolean IsActive;
    public UUID CreatedByUserId;
    public UUID UpdatedByUserId;
    public DateTime DateCreated;
    public DateTime DateUpdated;
    
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getBio() {
		return Bio;
	}
	public void setBio(String bio) {
		Bio = bio;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
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
}
