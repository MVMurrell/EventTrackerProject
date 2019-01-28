package com.skilldistillery.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
