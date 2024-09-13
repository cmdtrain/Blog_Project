package com.blogproject.web.mapper;

import com.blogproject.web.dto.EventDto;
import com.blogproject.web.models.Event;

public class EventMapper {

	public static Event mapToEvent(EventDto eventDto) {
		return Event.builder()
				.id(eventDto.getId())
				.name(eventDto.getName())
				.startTime(eventDto.getStartTime())
				.endTime(eventDto.getEndTime())
				.type(eventDto.getType())
				.photoUrl(eventDto.getPhotoUrl())
				.createdOn(eventDto.getCreatedOn())
				.updatedOn(eventDto.getUpdatedOn())
				.blog(eventDto.getBlog())
				.build();
		
	}
	
	public static EventDto mapToEventDto(Event event) {
		return EventDto.builder()
				.id(event.getId())
				.name(event.getName())
				.startTime(event.getStartTime())
				.endTime(event.getEndTime())
				.type(event.getType())
				.photoUrl(event.getPhotoUrl())
				.createdOn(event.getCreatedOn())
				.updatedOn(event.getUpdatedOn())
				.blog(event.getBlog())
				.build();
		
	}
}
