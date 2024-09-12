package com.blogproject.web.mapper;

import java.util.stream.Collectors;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;

public class BlogMapper {
	
	
	public static Blog mapToBlog(BlogDto blog) {
		// TODO Auto-generated method stub
		Blog blogDto = Blog.builder()
				.id(blog.getId())
				.title(blog.getTitle())
				.photoUrl(blog.getPhotoUrl())
				.content(blog.getContent())
				.createdOn(blog.getCreatedOn())
				.updatedOn(blog.getUpdatedOn())
				.build();
		return blogDto;
	}
	
	public static BlogDto mapToBlogDto(Blog blog) {
		// TODO Auto-generated method stub
		BlogDto blogDto = BlogDto.builder()
				
				.id(blog.getId())
				.title(blog.getTitle())
				.photoUrl(blog.getPhotoUrl())
				.content(blog.getContent())
				.createdOn(blog.getCreatedOn())
				.updatedOn(blog.getUpdatedOn())
				.events(blog.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
				.build();
			
					
			return blogDto;
		
	}
	
	

}
