package com.dbs.askleader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.askleader.model.Location;
import com.dbs.askleader.repository.LocationRepository;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationRepository repository;
	
	
	@GetMapping
	public List<Location> getAllDomains(){
		
		return repository.findAll();
	}
	
	@PostMapping
	public boolean addLocation(@RequestBody Location location) {
		repository.save(location);
		return true;
	}
	
	
	@DeleteMapping("/{id}")
	public boolean deleteLocation(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return true;
	}
	
	
}
