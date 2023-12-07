package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Actor;

@Repository
public class ActorRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Actor> getActors(){
		List<Actor> actors = new ArrayList<Actor>();
		
		return actors;
	}
	
	public int postActor(Actor actor){		
		return 0;
	}
	
	public int updateActor(Actor actor){		
		return 0;
	}
	
	public int deleteActor(UUID actorId){		
		return 0;
	}
	
}
