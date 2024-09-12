package com.blogproject.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogproject.web.dto.EventDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.models.Event;
import com.blogproject.web.repository.BlogRepository;
import com.blogproject.web.repository.EventRepository;
import com.blogproject.web.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	private EventRepository eventRepository;
	private BlogRepository blogRepository;
	
	@Autowired
	public EventServiceImpl(EventRepository eventRepository, BlogRepository blogRepository) {
		this.eventRepository = eventRepository;
		this.blogRepository = blogRepository;
	}
	
	@Override
	public void createEvent(Long blogId, EventDto eventDto) {
		Blog blog = blogRepository.findById(blogId).get();
		Event event = mapToEvent(eventDto);
		event.setBlog(blog);
		eventRepository.save(event);
		
	}

	private Event mapToEvent(EventDto eventDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<EventDto> findAllEvents() {
		List<Event> events = eventRepository.findAll();
		return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
		
	}
	
	@Override
	public EventDto findByEventId(Long eventId) {
		Event event = eventRepository.findById(eventId).get();
		return mapToEventDto(event);
		
	}

}
