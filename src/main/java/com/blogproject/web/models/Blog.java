package com.blogproject.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blogs")

public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String title;
	private String photoUrl;
	private String content;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	//авт додано - зміни в файл blogserviceimpl.java (4відео - час 6.28)
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

	public Object getCreatedOn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUpdatedOn() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
	private List<Event> event = new ArrayList<>();

	public Object getEvents() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
