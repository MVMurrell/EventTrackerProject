package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Roast;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.RoastRepository;

@Transactional
@Service
public class RoastServiceImpl implements RoastService {

	@Autowired
	private RoastRepository repo;
	
	
	@Override
	public List<Roast> index() {
		return repo.findAll();
		 
	}

	@Override
	public Roast show(Integer id) {
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
	public Roast create(Roast roast) {
		return repo.saveAndFlush(roast);
	}

	@Override
	public Roast update(Roast roast) {
		Roast managed = repo.findById(roast.getId()).get();
		if(roast.getCoffeeType() != null) {managed.setCoffeeType(roast.getCoffeeType());}
		if(roast.getCoffeeDetail() != null) {managed.setCoffeeDetail(roast.getCoffeeDetail());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Roast replace(Roast roast) {
		Roast managed = repo.findById(roast.getId()).get();
		managed.setCoffeeType(roast.getCoffeeType());
		managed.setCoffeeDetail(roast.getCoffeeDetail());
		repo.saveAndFlush(managed);
		return managed;
	}

}
