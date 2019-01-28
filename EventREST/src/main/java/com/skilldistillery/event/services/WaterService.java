package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Water;

public interface WaterService {

	public List <Water> index();
	public Water show(Integer id);
	public void delete(Integer id);
	public Water create(Water water);
	public Water update(Water water);
	public Water replace(Water water);
}
