package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Water;
import com.skilldistillery.event.repositories.WaterRepository;

@Transactional
@Service
public class WaterServiceImpl implements WaterService {

	@Autowired
	private WaterRepository repo;

	@Override
	public List<Water> index() {
		return repo.findAll();
	}

	@Override
	public Water show(Integer id) {
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
	public Water create(Water water) {
		return repo.saveAndFlush(water);
	}

	@Override
	public Water update(Water water) {
		Water managed = repo.findById(water.getId()).get();
		if(water.getAmount() != 0) {managed.setAmount(water.getAmount());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Water replace(Water water) {
		Water managed = repo.findById(water.getId()).get();
		managed.setAmount(water.getAmount());
		repo.saveAndFlush(managed);
		return managed;
	}

}
