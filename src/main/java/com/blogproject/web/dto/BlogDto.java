package com.blogproject.web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;

	
	
	
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

}
