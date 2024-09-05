package com.blogproject.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.repository.BlogRepository;
import com.blogproject.web.service.BlogService;

public class BlogServiceImpl implements BlogService{

	
	private BlogRepository blogRepository;
	

	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	@Override
	public List<BlogDto> findAllBlogs() {
		// TODO Auto-generated method stub
		List<Blog> blogs = blogRepository.findAll();
		return blogs.stream().map((blog) -> mapToBlogDto(blog)).collect(Collectors.toList());
		
	}
	private BlogDto mapToBlogDto(Blog blog) {
		// TODO Auto-generated method stub
		BlogDto blogDto = BlogDto.builder()
				
				.id(blog.getId())
				.title(blog.getTitle())
				.photoUrl(blog.getPhotoUrl())
				.content(blog.getContent())
				.createdOn(blog.getCreatedOn())
				.updatedOn(blog.getUpdatedOn())
				
				.build();
			
					
			return blogDto;
		
	}
	
	

}
