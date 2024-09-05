package com.blogproject.web.service;

import com.blogproject.web.dto.BlogDto;

import java.util.List;

public interface BlogService {

	List<BlogDto> findAllBlogs();
	
}
