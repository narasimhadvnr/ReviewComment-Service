package com.dbs.askleader.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ReviewCommentDTO {
	
		private String location;
		
		private String leaderName;
		
		private String comment;
		
		private long timestamp;
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private String browserId;

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getLeaderName() {
			return leaderName;
		}

		public void setLeaderName(String leaderName) {
			this.leaderName = leaderName;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public String getBrowserId() {
			return browserId;
		}

		public void setBrowserId(String browserId) {
			this.browserId = browserId;
		}
		

}
