package com.example.demo.repository;

//import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.common.ConnectionHelper;
import com.example.demo.common.filter.MovieFilter;
import com.example.demo.common.mapper.MovieViewMapper;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieView;

@Repository
public class MovieRepository {
	
	
	@Autowired
	JdbcTemplate jdbc;
	
	public List<MovieView> getMovies(MovieFilter filter) {
		
		String query = """
				SELECT DISTINCT m.\"Id\" AS \"MovieId\", m.\"Title\" AS \"MovieTitle\", m.\"Runtime\", m.\"YearOfRelease\", m.\"Image\",
				AVG(r.\"Score\") AS \"AverageScore\",
				COALESCE((SELECT STRING_AGG(g1.\"Title\", ',') FROM \"Genre\" g1 INNER JOIN \"MovieGenre\" mg1 ON mg1.\"GenreId\" = g1.\"Id\"
				WHERE mg1.\"MovieId\" = m.\"Id\"), '') AS \"GenreTitle\",
				COALESCE(STRING_AGG(DISTINCT CONCAT(a.\"FirstName\", ' ', a.\"LastName\"), ', '), '') AS \"ActorNames\"
				FROM \"Movie\" m
				LEFT JOIN \"MovieGenre\" mg ON mg.\"MovieId\" = m.\"Id\" 
				LEFT JOIN \"Genre\" g ON g.\"Id\" = mg.\"GenreId\"
				LEFT JOIN \"ActorMovie\" am ON am.\"MovieId\" = m.\"Id\"
				LEFT JOIN \"Actor\" a ON a.\"Id\" = am.\"ActorId\"
				LEFT JOIN \"Review\" r ON r.\"MovieId\" = m.\"Id\"
				LEFT JOIN \"WatchList\" wl ON wl.\"MovieId\" = m.\"Id\"
				GROUP BY m."Id"
				""";
		
		List<MovieView> moviesView = null;
		
		try {
			moviesView = jdbc.query(query, new MovieViewMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moviesView;
	}
	
}





//String query = """
//Inesert into Filmovi (id, naziv)
//values (?,?)
//returning filmovi.id;
//""";
//KeyHolder keyHolder = new GeneratedKeyHolder();
//try {
//jdbc.update(new PreparedStatementCreator() {
//
//@Override
//public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//	PreparedStatement ps = con.prepareStatement(query);
//	return ps;
//}
//}, keyHolder);
//
//keyHolder.getKey().longValue();
//}catch(Exception e){
//
//}
