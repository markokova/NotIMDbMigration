package com.example.demo.repository.common;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.common.filter.MovieFilter;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieView;

import org.springframework.data.domain.Pageable;

public interface IMovieRepository extends PagingAndSortingRepository<MovieView, UUID>{
	
	List<MovieView> getMovies(MovieFilter filter, Pageable pageable) throws SQLException;
	
//	int createMovie(Movie movie);
//	
//	int updateMovie(Movie movie);
//	
//	int deleteMovie(UUID movieId);
}
