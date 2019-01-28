package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Event;

public interface EventService {
	public List <Event> index();
	public Event show(Integer id);
	public void delete(Integer id);
	public Event create(Event event);
	public Event update(Event event);
	public Event replace(Event event);
	

}
