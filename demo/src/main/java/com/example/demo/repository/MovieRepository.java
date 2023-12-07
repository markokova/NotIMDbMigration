package com.example.demo.repository;

//import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;

import com.example.demo.common.ConnectionHelper;
import com.example.demo.common.filter.MovieFilter;
import com.example.demo.common.mapper.MovieViewMapper;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieView;
import com.example.demo.repository.common.IMovieRepository;

import ch.qos.logback.core.joran.conditional.IfAction;
import net.sf.jsqlparser.statement.select.Limit;

import java.awt.print.*;

@Repository
public class MovieRepository implements IMovieRepository{
	
	
	@Autowired
	JdbcTemplate jdbc;
		
	public List<MovieView> getMovies(MovieFilter filter, Pageable pageable) throws SQLException {
		
		StringBuilder queryBuilder = new StringBuilder("""
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
				""");
		
		queryBuilder = filterResults(filter, queryBuilder);
		queryBuilder = pageResults(pageable, queryBuilder);
		
		List<MovieView> moviesView = null;
		
		if(filter.GenreId != null) {
			moviesView = jdbc.query(
					queryBuilder.toString(),
					new MovieViewMapper(),
					new Object[] { 
							filter.GenreId,
							pageable.getPageNumber() <= 1 ? 0 : pageable.getPageNumber() * pageable.getPageSize(),
							pageable.getPageSize()});	
		}else {
			moviesView = jdbc.query(
					queryBuilder.toString(), 
					new MovieViewMapper(), 
					new Object[] {
							pageable.getPageNumber() <= 1 ? 0 : pageable.getPageNumber() * pageable.getPageSize(),
							pageable.getPageSize()});
				}
	
		return moviesView;
	}
	
	private StringBuilder filterResults(MovieFilter filter, StringBuilder builder) {
		if(filter != null) {
			builder.append(" WHERE 1 = 1 ");
			if(filter.GenreId != null) {
				builder.append("AND mg.\"GenreId\" = ?");
			}
		}
				
		builder.append(" GROUP BY m.\"Id\"");
		
		return builder;
	}
	
	private StringBuilder pageResults(Pageable pageable, StringBuilder builder) {
		if(pageable != null) {
			builder.append(" OFFSET ?");
			builder.append(" LIMIT ?");
		}
		return builder;
	}

	@Override
	public Iterable<MovieView> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MovieView> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createMovie(Movie movie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMovie(UUID movieId) {
		// TODO Auto-generated method stub
		return 0;
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
