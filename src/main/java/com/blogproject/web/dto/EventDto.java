package com.blogproject.web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;

}
