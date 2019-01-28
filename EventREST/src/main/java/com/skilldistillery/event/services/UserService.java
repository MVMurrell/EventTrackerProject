package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Event;
import com.skilldistillery.event.entities.User;

public interface UserService {

	public List <User> index();
	public User show(Integer id);
	public void delete(Integer id);
	public User create(User user);
	public User update(User user);
	public User replace(User user);
	

}
