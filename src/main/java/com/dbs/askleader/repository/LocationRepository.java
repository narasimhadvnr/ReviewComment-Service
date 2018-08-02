package com.dbs.askleader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.askleader.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
	
	List<Location> findByLocation(String location);
}
