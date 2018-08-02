package com.dbs.askleader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.askleader.dto.ReviewCommentDTO;
import com.dbs.askleader.model.Leader;
import com.dbs.askleader.model.Location;
import com.dbs.askleader.model.ReviewComment;
import com.dbs.askleader.repository.LeaderRepository;
import com.dbs.askleader.repository.LocationRepository;
import com.dbs.askleader.repository.ReviewCommentRepository;
import com.dbs.askleader.utils.ReviewCommentUtils;

@RestController
@RequestMapping("/reviewComment")
public class ReviewCommentController {

	
	@Autowired
	public ReviewCommentRepository repository;
	
	
	@Autowired
	public LocationRepository locationRepository;
	
	@Autowired
	public LeaderRepository leaderRepository;
	
	@GetMapping("/location/{location}")
	public Page<ReviewComment> getAllComments( @PathVariable("location") String location,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize) {
		
		
		if(location!= null) {
			
			List<Location> locations = locationRepository.findByLocation(location);
			
			
			if(locations.size() ==1) {
			
				Page<ReviewComment> result= repository.findByLocation(locations.get(0), new PageRequest(pageNumber, pageSize));
				
				System.out.println("result size: "+result.getContent().size());
				return result;
			}
		}
		
		return 	null;	
		
	}
	
	@GetMapping
	public Iterable<ReviewCommentDTO> getAllComments() {
	
			
		Iterable<ReviewComment> result= repository.findAll();
		return ReviewCommentUtils.convertToDtos(result);
				
	}
	
	@PostMapping
	public boolean saveComment( @RequestBody ReviewCommentDTO  commentDto) {
		
		
		if(commentDto!= null) {
			
			List<Location> locations = locationRepository.findByLocation(commentDto.getLocation());
			
			List<Leader> leaders = leaderRepository.findByName(commentDto.getLeaderName());

			if(locations.size() == 1 && leaders.size() == 1) {
				
				ReviewComment comment= ReviewCommentUtils.convertToDomain(commentDto);
				comment.setLeaderId(leaders.get(0));
				comment.setLocation(locations.get(0));
				
				 repository.save(comment);
				 return true;
			}
		}
		
		return false;	
		
	}
	
	
	
}
