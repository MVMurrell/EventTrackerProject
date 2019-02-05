package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Event;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.EventRepository;

@Transactional
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository repo;
	
	
	@Override
	public List<Event> index() {
		return repo.findAll();
	}

	@Override
	public Event show(Integer id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Event create(Event event) {
		return repo.saveAndFlush(event);
	}

	@Override
	public Event update(Event event) {
		Event managed = repo.findById(event.getId()).get();
		if(event.getAmount() != null) {managed.setAmount(event.getAmount());}
		if(event.getDate() != null) {managed.setDate(event.getDate());}
		if(event.getTime() != null) {managed.setTime(event.getTime());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Event replace(Event event) {
		Event managed = repo.findById(event.getId()).get();
		managed.setAmount(event.getAmount());
		managed.setDate(event.getDate());
		managed.setTime(event.getTime());
		repo.saveAndFlush(managed);
		return managed;
	}

}
