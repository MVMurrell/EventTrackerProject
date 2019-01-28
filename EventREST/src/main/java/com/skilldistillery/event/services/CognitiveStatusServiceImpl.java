package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.CognitiveStatus;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.CognitiveStatusRepository;

@Transactional
@Service
public class CognitiveStatusServiceImpl implements CognitiveStatusService {

	@Autowired
	private CognitiveStatusRepository repo;
	
	@Override
	public List<CognitiveStatus> index() {
		return repo.findAll();
	}

	@Override
	public CognitiveStatus show(Integer id) {
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
	public CognitiveStatus create(CognitiveStatus status) {
		return repo.saveAndFlush(status);
	}

	@Override
	public CognitiveStatus update(CognitiveStatus status) {
		CognitiveStatus managed = repo.findById(status.getId()).get();
		if(status.getCognitiveStatus() != null) {managed.setCognitiveStatus(status.getCognitiveStatus());}
		if(status.getEvents() != null) {managed.setEvents(status.getEvents());}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public CognitiveStatus replace(CognitiveStatus status) {
		CognitiveStatus managed = repo.findById(status.getId()).get();
		managed.setCognitiveStatus(status.getCognitiveStatus());
		managed.setEvents(status.getEvents());
		repo.saveAndFlush(managed);
		return managed;
	}

	

}
