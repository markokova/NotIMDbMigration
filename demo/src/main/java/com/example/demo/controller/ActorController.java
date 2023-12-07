package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ActorRepository;

@RestController
public class ActorController {
	
	@Autowired
	ActorRepository actorRepository;
	
	@GetMapping("/api/Actor")
	public String getActors() {
		return "";
	}
}
