package com.dbs.askleader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.askleader.model.Leader;

public interface LeaderRepository extends JpaRepository<Leader,Long>{

	List<Leader> findByName(String name);
}
