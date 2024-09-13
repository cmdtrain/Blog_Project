package com.blogproject.web.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String type;
	private String photoUrl;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	@ManyToOne
	@JoinColumn(name="blog_id", nullable = false)
	private Blog blog;

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBlog(Blog blog2) {
		// TODO Auto-generated method stub
		
	}

	public Object getUpdatedOn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCreatedOn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPhotoUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBlog() {
		// TODO Auto-generated method stub
		return null;
	}
}
