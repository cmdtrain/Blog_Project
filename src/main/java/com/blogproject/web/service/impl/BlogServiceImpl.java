package com.blogproject.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

//add this if impl doesnt work
//@Service 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.repository.BlogRepository;
import com.blogproject.web.service.BlogService;

@Service
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
	@Override
	public Blog saveBlog(BlogDto blogDto) {
		Blog blog = mapToBlog(blogDto);
		// TODO Auto-generated method stub
		return (Blog) blogRepository.save(blog);
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BlogDto findBlogById(long blogId) {
		// TODO Auto-generated method stub
		
		Blog blog = (Blog) blogRepository.findById(blogId).get();
		return mapToBlogDto(blog);
		
	}
	@Override
	public BlogDto findBlogById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateBlog(BlogDto blogDto) {
		// TODO Auto-generated method stub
		Blog blog = mapToBlog(blogDto);
		blogRepository.save(blog);
		
	}
	private Blog mapToBlog(BlogDto blog) {
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
	}// ADDED WHATS BELOW  CAUSE PUBLIC CLASS  BLOGSERVICEIMPL DIDNT WORK
	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long blogId) {
		blogRepository.deleteById(blogId);
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
