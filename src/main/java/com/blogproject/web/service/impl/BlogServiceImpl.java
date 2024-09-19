package com.blogproject.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

//add this if impl doesnt work
//@Service 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.models.UserEntity;
import com.blogproject.web.repository.BlogRepository;
import com.blogproject.web.repository.UserRepository;
import com.blogproject.web.security.SecurityUtil;
import com.blogproject.web.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	
	private BlogRepository blogRepository;
	private UserRepository userRepository;
	
	

	@Autowired
	public BlogServiceImpl(BlogRepository blogRepositor, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.blogRepository = blogRepository;
	}
	@Override
	public List<BlogDto> findAllBlogs() {
		// TODO Auto-generated method stub
		List<Blog> blogs = blogRepository.findAll();
		return blogs.stream().map((blog) -> mapToBlogDto(blog)).collect(Collectors.toList());
		
	}
	
	@Override
	public Blog saveBlog(BlogDto blogDto) {
		String username = SecurityUtil.getSessionUser();
		UserEntity user = userRepository.findByUsername(username);
		Blog blog = mapToBlog(blogDto);
		blog.setCreatedBy(user);
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
	private BlogDto mapToBlogDto(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BlogDto findBlogById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateBlog(BlogDto blogDto) {
		String username = SecurityUtil.getSessionUser();
		UserEntity user = userRepository.findByUsername(username);
		// TODO Auto-generated method stub
		Blog blog = mapToBlog(blogDto);
		blog.setCreatedBy(user);
		blogRepository.save(blog);
		
	}
	
	private Blog mapToBlog(BlogDto blogDto) {
		// TODO Auto-generated method stub
		return null;
	}
	// ADDED WHATS BELOW  CAUSE PUBLIC CLASS  BLOGSERVICEIMPL DIDNT WORK
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
	@Override
	public List<BlogDto> searchBlogs(String query) {
		// TODO Auto-generated method stub
		List<Blog> blogs = blogRepository.searchBlogs(query);
		return blogs.stream().map(blog -> mapToBlogDto(blog)).collect(Collectors.toList());
	}
	
	
	
	

}
