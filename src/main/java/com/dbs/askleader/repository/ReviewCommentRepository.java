package com.dbs.askleader.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dbs.askleader.model.Location;
import com.dbs.askleader.model.ReviewComment;

public interface ReviewCommentRepository extends PagingAndSortingRepository<ReviewComment,Long>{
	
	public Page<ReviewComment> findByLocation(Location l, Pageable pageRequest);
	
	public Page <ReviewComment> findByLeaderId(long leaderId, Pageable pageRequest);

}
