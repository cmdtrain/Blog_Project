package com.blogproject.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogproject.web.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	

}
