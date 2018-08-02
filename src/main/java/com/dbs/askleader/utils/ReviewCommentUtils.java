package com.dbs.askleader.utils;

import java.util.ArrayList;
import java.util.List;

import com.dbs.askleader.dto.ReviewCommentDTO;
import com.dbs.askleader.model.ReviewComment;

public class ReviewCommentUtils {

	public static ReviewComment convertToDomain(ReviewCommentDTO commentdto) {
		
		ReviewComment comment = new ReviewComment();
		
		comment.setBrowserId(commentdto.getBrowserId());
		comment.setComment(commentdto.getComment());
		
		return comment;
	}
	
	public static ReviewCommentDTO convertToDto(ReviewComment comment) {
		
		ReviewCommentDTO dto=new ReviewCommentDTO();
		dto.setComment(comment.getComment());
		dto.setLeaderName(comment.getLeaderId().getname());
		dto.setLocation(comment.getLocation().getLocation());
		dto.setTimestamp(comment.getTimestamp());
		return dto;
		
	}
	
	
	public static Iterable<ReviewCommentDTO> convertToDtos(Iterable<ReviewComment> comment) {
		List<ReviewCommentDTO> result= new ArrayList<ReviewCommentDTO>();
		
		comment.forEach(item -> {
			
			result.add(convertToDto(item));
		});
		return result;

		}
	}
