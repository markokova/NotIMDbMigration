package com.example.demo.common.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieView;

public class MovieViewMapper implements RowMapper<MovieView>{

	@Autowired
	MovieMapper movieMapper;
	@Override
	public MovieView mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieView movieView = new MovieView();
		Movie movie = new Movie();
		movie.setId(UUID.fromString(rs.getString(1)));
		movie.setTitle(rs.getString(2));
		movie.setRuntime(rs.getInt(3));
		movie.setYearOfRelease(rs.getDate(4));
		movie.setImage(rs.getString(5));
		movieView.Movie = movie;
		movieView.setAverageScore(rs.getDouble(6));
		movieView.setGenres(rs.getString(7));
		movieView.setActors(rs.getString(8));
		return movieView;
	}

}
