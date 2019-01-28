package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.TeaDistributer;

public interface TeaDistributerSevice {
	public List <TeaDistributer> index();
	public TeaDistributer show(Integer id);
	public void delete(Integer id);
	public TeaDistributer create(TeaDistributer distributer);
	public TeaDistributer update(TeaDistributer distributer);
	public TeaDistributer replace(TeaDistributer distributer);
	

}
