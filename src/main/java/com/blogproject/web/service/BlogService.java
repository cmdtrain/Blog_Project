package com.blogproject.web.service;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;

import java.util.List;

public interface BlogService {

	List<BlogDto> findAllBlogs();
	
	Blog saveBlog(BlogDto blogDto);

	void save();

	BlogDto findBlogById();

	BlogDto findBlogById(long blogId);

	void updateBlog(BlogDto blog);

	Blog saveBlog(Blog blog);

	void delete(Long blogId); 
}
