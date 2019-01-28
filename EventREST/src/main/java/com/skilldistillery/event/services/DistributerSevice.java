package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Distributer;

public interface DistributerSevice {
	public List <Distributer> index();
	public Distributer show(Integer id);
	public void delete(Integer id);
	public Distributer create(Distributer distributer);
	public Distributer update(Distributer distributer);
	public Distributer replace(Distributer distributer);
	

}
