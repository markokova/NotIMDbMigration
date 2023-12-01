package com.example.demo.model;

import java.util.UUID;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class User {
	public UUID Id;
	public String FirstName;
	public String LastName;
	public String Email;
	public DateTime DateOfBirth;
	public String Password;
	public boolean IsActive;
	public UUID UpdatedByUserId;
	public DateTime DateCreated;
	public DateTime DateUpdated;
	public UUID RoleId;
	
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public DateTime getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(DateTime dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
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
	public UUID getRoleId() {
		return RoleId;
	}
	public void setRoleId(UUID roleId) {
		RoleId = roleId;
	}
}
