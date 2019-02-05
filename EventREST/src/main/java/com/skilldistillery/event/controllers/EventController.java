package com.skilldistillery.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.event.entities.Event;
import com.skilldistillery.event.services.EventService;

@RestController
@RequestMapping("api")
public class EventController {

	@Autowired
	private EventService eServ;
	
	@GetMapping("events")
	public List<Event> listEvents() {
		return eServ.index();
	}
	
	@GetMapping("event/{id}")
	public Event getEventById(@PathVariable Integer id) {
		return eServ.show(id);
	}
	
	@PostMapping("event")
	public Event createEvent(@RequestBody Event event) {
		return eServ.create(event);
	}
	
	@DeleteMapping("event/{id}")
	public String deleteEventById(@PathVariable Integer id) {
		eServ.delete(id);
		return "Event Deleted";
	}
}
