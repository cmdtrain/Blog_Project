package com.blogproject.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.dto.EventDto;
import com.blogproject.web.models.Event;
import com.blogproject.web.models.UserEntity;
import com.blogproject.web.security.SecurityUtil;
import com.blogproject.web.service.EventService;
import com.blogproject.web.service.UserService;

@Controller

public class EventController {
	
	private EventService eventService;
	private String attributeName;
	private String attributeValue;
	private UserService userService;
	
	@Autowired
	public EventController(EventService eventService, UserService userService) {
		this.userService = userService;
		this.eventService = eventService;
		
	}

	@GetMapping("/events")
	public String eventList(Model model) {
		UserEntity user = new UserEntity();
		List<EventDto> events = eventService.findAllEvents();
		String username = SecurityUtil.getSessionUser();
		if(username != null) {
			user = userService.findByUsername(username);
			model.addAttribute(attributeName: "user", user);
		}
		model.addAttribute(attributeName: "user", user);
		model.addAttribute(attributeValue: "events", events);
		return "events-list";
		
	}
	
	@GetMapping("/events/{eventId}")
	public String viewEvent(@PathVariable("eventId") Long eventId, Model model) {
		UserEntity user = new UserEntity();

		EventDto eventDto = eventService.findByEventId(eventId);
		String username = SecurityUtil.getSessionUser();
		if(username != null) {
			user = userService.findByUsername(username);
			model.addAttribute(attributeName: "user", user);
		}
		model.addAttribute(attributeName: "blog", eventDto);
		model.addAttribute(attributeName: "user", user);
		model.addAttribute(attributeName: "event", eventDto);
		return "events-detail";
		
	}
	
	@GetMapping("/events/{blogId}/new")
	public String createEventForm(@PathVariable("blogId") Long blogId, Model model) {
		Event event = new Event();
		model.addAttribute(attributeValue: "blogId", blogId);
		model.addAttribute(attributeName: "event", event);
		return "events-create";
		
	}
	
	@GetMapping("/events/{eventId}/edit")
	public String editEventForm(@PathVariable("eventId") long eventId, Model model) {
		EventDto event = eventService.findEventById(eventId);
		model.addAttribute(attributeValue: "event", event);
		return "events-edit";
				
	}
	
	
	@PostMapping("/events/{blogId}")
	public String createEvent(@PathVariable("blogId") Long blogId, @ModelAttribute("event") EventDto eventDto, 
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute(attributeName: "event", eventDto);
			return "blogs-create";
			}
		eventService.createService(blogId, eventDto);
		return "redirect;/blogs" + blogId;
		
	}
	
	@PostMapping("/events/{eventId}/edit")
	public String updateEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute("event") EventDto event,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute(attributeName: "event", event);
			return "events-edit";
			}
		EventDto eventDto = eventService.findByEventId(eventId);
		event.setId(eventId);
		event.setBlog(eventDto.getBlog());
		eventService.updateEvent(event);
		return "redirect:/events";
		
	}
	
	@GetMapping("/events/{eventId/delete")
	public String deleteEvent(@PathVariable("eventId") long eventId) {
		eventService.deleteEvent(eventId);
		return "redirect:/events";
		
	}
}
