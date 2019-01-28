package com.skilldistillery.event.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Coffee;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.CoffeeRepository;

@Transactional
@Service
public class CoffeeServiceImpl implements CoffeeService {
	
	@Autowired
	private CoffeeRepository repo;

	@Override
	public List<Coffee> index() {
		return repo.findAll();
	}

	@Override
	public Coffee show(Integer id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Coffee create(Coffee coffee) {
		return repo.saveAndFlush(coffee);
	}

	@Override
	public Coffee update(Coffee coffee) {
		Coffee managed = repo.findById(coffee.getId()).get();
		if(coffee.getAmount() != 0) {managed.setAmount(coffee.getAmount());}
		if(coffee.getEvent() != null) {managed.setEvent(coffee.getEvent());}
		if(coffee.getCoffeeDetail()!= null) {managed.setCoffeeDetail(coffee.getCoffeeDetail());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Coffee replace(Coffee coffee) {
		Coffee managed = repo.findById(coffee.getId()).get();
		managed.setAmount(coffee.getAmount());
		managed.setEvent(coffee.getEvent());
		managed.setCoffeeDetail(coffee.getCoffeeDetail());
		repo.saveAndFlush(managed);
		return managed;
	}


}
