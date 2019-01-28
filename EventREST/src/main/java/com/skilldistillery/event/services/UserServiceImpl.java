package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Event;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.entities.Water;
import com.skilldistillery.event.repositories.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> index() {
		return repo.findAll();
	}

	@Override
	public User show(Integer id) {
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
	public User create(User user) {
		return repo.saveAndFlush(user);
	}

	@Override
	public User update(User user) {
		User managed = repo.findById(user.getId()).get();
		if(user.getFirstName() != null) {managed.setFirstName(user.getFirstName());}
		if(user.getLastName() != null) {managed.setLastName(user.getLastName());}
		if(user.getPassword()!= null) {managed.setPassword(user.getPassword());}
		if(user.getUsername() != null) {managed.setUsername(user.getUsername());}
		if(user.getEvents() != null) {managed.setEvents(user.getEvents());}
		repo.saveAndFlush(managed);
		return managed;
	}
	
	

	@Override
	public User replace(User user) {
		User managed = repo.findById(user.getId()).get();
		managed.setFirstName(user.getFirstName());
		managed.setLastName(user.getLastName());
		managed.setPassword(user.getPassword());
		managed.setUsername(user.getUsername());
		managed.setEvents(user.getEvents());
		repo.saveAndFlush(managed);
		return managed;
	}
	
}
