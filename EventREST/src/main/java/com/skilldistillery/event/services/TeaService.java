package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Tea;

public interface TeaService {
	public List <Tea> index();
	public Tea show(Integer id);
	public void delete(Integer id);
	public Tea create(Tea tea);
	public Tea update(Tea tea);
	public Tea replace(Tea tea);

}
