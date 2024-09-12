package com.blogproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogproject.web.dto.EventDto;
import com.blogproject.web.models.Event;
import com.blogproject.web.service.EventService;

@Controller

public class EventController {
	
	private EventService eventService;
	private String attributeName;
	private String attributeValue;
	
	@Autowired
	public EventController(EventService eventService) {
		this.eventService = eventService;
		
	}

	
	@GetMapping("/events/{blogId}/new")
	public String createEventForm(@PathVariable("blogId") Long blogId, Model model) {
		Event event = new Event();
		model.addAttribute(attributeValue: "blogId", blogId);
		model.addAttribute(attributeName: "event", event);
		return "events-create";
		
	}
	
	@PostMapping("/events/{blogId}")
	public String createEvent(@PathVariable("blogId") Long blogId, @ModelAttribute("event") EventDto eventDto, Model model) {
		eventService.createService(blogId, eventDto);
		return "redirect;/blogs" + blogId;
		
	}
	
	
}
