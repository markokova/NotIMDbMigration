package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.config.ScheduledTasksBeanDefinitionParser;
import org.springframework.stereotype.Repository;

import com.example.demo.common.filter.ReviewFilter;
import com.example.demo.common.mapper.ReviewMapper;
import com.example.demo.model.Review;

@Repository
public class ReviewRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Review> getReviews(ReviewFilter filter){
		List<Review> reviews = new ArrayList<Review>();
		
		StringBuilder queryBuilder = new StringBuilder(
				"""
				SELECT r.\"Id\", r.\"Title\", r.\"Content\", r.\"DateCreated\", r.\"DateUpdated\", r.\"Score\", r.\"MovieId\", u.\"Id\" AS \"UserId\", u.\"FirstName\", u.\"LastName\" 
				FROM \"Review\" r
                INNER JOIN \"User\" u ON r.\"CreatedByUserId\" = u.\"Id\"
				""");
		
		queryBuilder = filter(filter, queryBuilder);
		
		reviews = jdbcTemplate.query(queryBuilder.toString(), new ReviewMapper(), getParams(filter));
		
		return reviews;
	}
	
	private Object[] getParams(ReviewFilter filter) {

		if(filter.Score == null && filter.MovieId == null) {
			return new Object[] {};
		}
		//TODO
//		if(filter.Score != 0) {
//			params
//		}
	
		return new Object[] {filter.MovieId};
	}
	
	private StringBuilder filter(ReviewFilter filter, StringBuilder stringBuilder) {
		if(filter != null) {
			stringBuilder.append(" WHERE 1 = 1 ");
			if(filter.Score != null) {
				stringBuilder.append("AND r.\"Score\" = ? ");
			}
			if(filter.MovieId != null) {
				stringBuilder.append("AND r.\"MovieId\" = ? ");
			}
			if(filter.FilterString != null) {
				//TODO
				stringBuilder.append("");
			}
		}
		return stringBuilder;
	}
	
}
