package com.example.demo.common.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Movie;
import com.example.demo.model.Review;
import com.example.demo.model.User;

public class ReviewMapper implements RowMapper<Review>{

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		Review review = new Review(); User user = new User(); Movie movie = new Movie();
		review.setId(UUID.fromString(rs.getString(1)));
		review.setTitle(rs.getString(2));
		review.setContent(rs.getString(3));
		review.setDateCreated(rs.getDate(4));
		review.setDateUpdated(rs.getDate(5));
		review.setScore(rs.getInt(6));
		review.setMovieId(UUID.fromString(rs.getString(7)));
		user.setUpdatedByUserId(UUID.fromString(rs.getString(8)));
		user.setFirstName(rs.getString(9));
		user.setLastName(rs.getString(10));
		review.setUser(user);
		
		return review;
	}

}
