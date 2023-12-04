package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Genre;

@Repository
public class GenreRepository {
	@Autowired
	JdbcTemplate jdbc;
	
	public List<Genre> getGenres(){
		
		List<Genre> genres = null;
		
		String query = "SELECT * FROM \"Genre\"";
		
		genres = jdbc.query(query, new RowMapper<Genre>() {

			@Override
			public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
				Genre genre = new Genre();
				genre.setId(UUID.fromString(rs.getString(1)));
				genre.setTitle(rs.getString(2));
				return genre;
			}			
		});
		
		return genres;
	}
}
