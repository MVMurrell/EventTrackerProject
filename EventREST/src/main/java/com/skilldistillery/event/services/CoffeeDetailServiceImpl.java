package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Coffee;
import com.skilldistillery.event.entities.CoffeeDetail;
import com.skilldistillery.event.entities.Tea;
import com.skilldistillery.event.repositories.CoffeeDetailRepository;

@Transactional
@Service
public class CoffeeDetailServiceImpl implements CoffeeDetailService {
	
	@Autowired
	private CoffeeDetailRepository repo;

	@Override
	public List<CoffeeDetail> index() {
		return repo.findAll();
	}

	@Override
	public CoffeeDetail show(Integer id) {
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
	public CoffeeDetail create(CoffeeDetail detail) {
		return repo.saveAndFlush(detail);
	}

	@Override
	public CoffeeDetail update(CoffeeDetail detail) {
		CoffeeDetail managed = repo.findById(detail.getId()).get();
		if(detail.getName() != null) {managed.setName(detail.getName());}
		if(detail.getCoffee() != null) {managed.setCoffee(detail.getCoffee());}
		if(detail.getDistributer()!= null) {managed.setDistributer(detail.getDistributer());}
		if(detail.getRoast()!= null) {managed.setRoast(detail.getRoast());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public CoffeeDetail replace(CoffeeDetail detail) {
		CoffeeDetail managed = repo.findById(detail.getId()).get();
		managed.setName(detail.getName());
		managed.setCoffee(detail.getCoffee());
		managed.setDistributer(detail.getDistributer());
		managed.setDistributer(detail.getDistributer());
		managed.setRoast(detail.getRoast());
		repo.saveAndFlush(managed);
		return managed;
	}
	
	
	

}
