package com.example.demo.common.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Movie;

public class MovieMapper implements RowMapper<Movie>{

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movie movie = new Movie();
		movie.setId(UUID.fromString(rs.getString(1)));
		movie.setTitle(rs.getString(2));
		movie.setRuntime(rs.getInt(3));
		movie.setYearOfRelease(rs.getDate(4));
		movie.setImage(rs.getString(5));
		
		return movie;
	}
	
}
