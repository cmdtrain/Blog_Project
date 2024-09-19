package com.blogproject.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.blogproject.web.models.UserEntity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class BlogDto {
	
	
	private Long id;
	@NotEmpty(message = "Blog title should not be empty")
	private String title;
	@NotEmpty(message = "Photo link should not be empty")
	private String photoUrl;
	@NotEmpty(message = "Content should not be empty")
	private String content;
	private UserEntity createdBy;
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;
	
	private List<EventDto> events;
	

	
	
	
	//додано автоматично після зміни в blogserviceimpl.java (відео 4 - час 6.10)
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}




	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}




	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}




	public Object getPhotoUrl() {
		// TODO Auto-generated method stub
		return null;
	}




	public Object getContent() {
		// TODO Auto-generated method stub
		return null;
	}




	public Object getUpdatedOn() {
		// TODO Auto-generated method stub
		return null;
	}




	public Object getCreatedOn() {
		// TODO Auto-generated method stub
		return null;
	}




	public void setId(Long blogId) {
		// TODO Auto-generated method stub
		
	}

}
