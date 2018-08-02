package com.dbs.askleader.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.askleader.model.Leader;
import com.dbs.askleader.repository.LeaderRepository;
import com.dbs.askleader.service.LeaderService;

@Service
public class LeaderServiceImpl implements LeaderService{

	@Autowired
	LeaderRepository repository;
	
	@Override
	public boolean addLeader(Leader leader) {
		// TODO Auto-generated method stub
		
		repository.save(leader);
		
		return true;
	}

	@Override
	public boolean updateLeader(Leader leader, long id) {
		// TODO Auto-generated method stub
		Optional<Leader> leaders = repository.findById(id);
		if(leaders.isPresent()) {
			repository.save(leader);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeLeader(long id) {
		// TODO Auto-generated method stub
		
		Optional<Leader> leaders = repository.findById(id);
		if(leaders.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Leader> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
}
