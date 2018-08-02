package com.dbs.askleader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.askleader.model.Leader;
import com.dbs.askleader.service.LeaderService;

@RestController
@RequestMapping("/leader")
public class LeaderController {
	
	
	@Autowired
	LeaderService leaderService;
	public LeaderController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public List<Leader> getAll(){
		return leaderService.getAll();
	}
	
	@PostMapping
	public boolean addLeader(@RequestBody Leader leader) {
		leaderService.addLeader(leader);
		return true;
	}
	
	@PostMapping("/{id}")
	public boolean updateLeader( @RequestBody Leader leader, @PathVariable long id) {
		return leaderService.updateLeader(leader, id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteLeader(@PathVariable long id) {
		return leaderService.removeLeader(id);
	}
}
