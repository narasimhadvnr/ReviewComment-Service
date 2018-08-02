package com.dbs.askleader.service;

import java.util.List;

import com.dbs.askleader.model.Leader;

public interface LeaderService {
	
	boolean addLeader(Leader leader);

	boolean updateLeader(Leader leader, long id);

	boolean removeLeader(long id);
	
	List<Leader> getAll();
}
