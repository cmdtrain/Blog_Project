package com.blogproject.web.repository;

import com.blogproject.web.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("hiding")
public interface BlogRepository<Blog> extends JpaRepository<Blog, Long>{
	Optional<Blog> findByTitle(String url);
	@Query("SELECT c from Blog c WHERE c.title LIKE CONCAT('%', :query, '%')")
	List<Blog> searchBlogs(String query);
	


}


