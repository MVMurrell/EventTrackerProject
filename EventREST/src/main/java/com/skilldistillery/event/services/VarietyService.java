package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Variety;

public interface VarietyService {

	public List <Variety> index();
	public Variety show(Integer id);
	public void delete(Integer id);
	public Variety create(Variety variety);
	public Variety update(Variety variety);
	public Variety replace(Variety variety);

}
