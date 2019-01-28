package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Roast;

public interface RoastService {
	public List <Roast> index();
	public Roast show(Integer id);
	public void delete(Integer id);
	public Roast create(Roast roast);
	public Roast update(Roast roast);
	public Roast replace(Roast roast);

}
