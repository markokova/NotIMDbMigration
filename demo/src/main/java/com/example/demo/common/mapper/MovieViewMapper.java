package com.example.demo.common.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.MovieView;

public class MovieViewMapper implements RowMapper<MovieView>{

	@Autowired
	MovieMapper movieMapper;
	@Override
	public MovieView mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieView movieView = new MovieView();
		MovieMapper movieMapper = new MovieMapper();
		movieView.Movie = movieMapper.mapRow(rs, rowNum);
		movieView.setActors(rs.getString(8));
		movieView.setGenres(rs.getString(7));
		movieView.setAverageScore(rs.getDouble(6));
		return movieView;
	}

}
