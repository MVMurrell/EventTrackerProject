package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.CoffeeDetail;

public interface CoffeeDetailService {

	public List <CoffeeDetail> index();
	public CoffeeDetail show(Integer id);
	public void delete(Integer id);
	public CoffeeDetail create(CoffeeDetail detail);
	public CoffeeDetail update(CoffeeDetail detail);
	public CoffeeDetail replace(CoffeeDetail detail);
}
