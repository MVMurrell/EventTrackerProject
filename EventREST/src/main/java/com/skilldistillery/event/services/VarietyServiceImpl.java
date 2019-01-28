package com.skilldistillery.event.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.entities.Variety;
import com.skilldistillery.event.repositories.VarietyRepository;

@Transactional
@Service
public class VarietyServiceImpl implements VarietyService {

	@Autowired
	private VarietyRepository repo;

	@Override
	public List<Variety> index() {
		return repo.findAll();
	}

	@Override
	public Variety show(Integer id) {
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
	public Variety create(Variety variety) {
		return repo.saveAndFlush(variety);
	}

	@Override
	public Variety update(Variety variety) {
		Variety managed = repo.findById(variety.getId()).get();
		if(variety.getVariety() != null) {managed.setVariety(variety.getVariety());}
		if(variety.getTeaDetail() != null) {managed.setTeaDetail(variety.getTeaDetail());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Variety replace(Variety variety) {
		Variety managed = repo.findById(variety.getId()).get();
		managed.setVariety(variety.getVariety());
		managed.setTeaDetail(variety.getTeaDetail());
		repo.saveAndFlush(managed);
		return managed;
	}
}
