package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.CoffeeDistributer;



public interface CoffeeDistributerService {

	public List <CoffeeDistributer> index();
	public CoffeeDistributer show(Integer id);
	public void delete(Integer id);
	public CoffeeDistributer create(CoffeeDistributer cd);
	public CoffeeDistributer update(CoffeeDistributer cd);
	public CoffeeDistributer replace(CoffeeDistributer cd);

}
