package com.blogproject.web.repository;

import com.blogproject.web.models.Blog;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("hiding")
public interface BlogRepository<Blog> extends JpaRepository<Blog, Long>{
	Optional<Blog> findByTitle(String url);


}


