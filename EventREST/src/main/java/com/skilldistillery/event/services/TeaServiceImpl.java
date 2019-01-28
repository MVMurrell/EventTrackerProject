package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Tea;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.TeaRepository;

@Transactional
@Service
public class TeaServiceImpl implements TeaService {

	@Autowired
	private TeaRepository repo;
	
	
	@Override
	public List<Tea> index() {
		return repo.findAll();
	}

	@Override
	public Tea show(Integer id) {
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
	public Tea create(Tea tea) {
		return repo.saveAndFlush(tea);
	}

	@Override
	public Tea update(Tea tea) {
		Tea managed = repo.findById(tea.getId()).get();
		if(tea.getEvent() != null) {managed.setEvent(tea.getEvent());}
		if(tea.getAmount() != 0) {managed.setAmount(tea.getAmount());}
		if(tea.getTeaDetail()!= null) {managed.setTeaDetail(tea.getTeaDetail());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Tea replace(Tea tea) {
		Tea managed = repo.findById(tea.getId()).get();
		managed.setEvent(tea.getEvent());
		managed.setAmount(tea.getAmount());
		managed.setTeaDetail(tea.getTeaDetail());
		repo.saveAndFlush(managed);
		return managed;
	}

}
