package com.skilldistillery.event.services;
import java.util.List;

import com.skilldistillery.event.entities.Coffee;

public interface CoffeeService {
	public List <Coffee> index();
	public Coffee show(Integer id);
	public void delete(Integer id);
	public Coffee create(Coffee coffee);
	public Coffee update(Coffee coffee);
	public Coffee replace(Coffee coffee);
	

}
