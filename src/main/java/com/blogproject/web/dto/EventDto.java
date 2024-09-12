package com.blogproject.web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
	private Long id;
	private String name;
	private String type;
	private String photoUrl;
	@DateTimeFormat(pattern = "yyy-MM-dd'T'HH:mm")
	private LocalDateTime startTime;
	@DateTimeFormat(pattern = "yyy-MM-dd'T'HH:mm")
	private LocalDateTime endTime;
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPhotoUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCreatedOn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUpdatedOn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
