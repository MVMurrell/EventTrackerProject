package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.Distributer;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.DistributerRepository;

@Transactional
@Service
public class DistributerServiceImpl implements DistributerSevice {

	@Autowired
	private DistributerRepository repo;

	@Override
	public List<Distributer> index() {
		return repo.findAll();
	}

	@Override
	public Distributer show(Integer id) {
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
	public Distributer create(Distributer distributer) {
		return repo.saveAndFlush(distributer);
	}

	@Override
	public Distributer update(Distributer distributer) {
		Distributer managed = repo.findById(distributer.getId()).get();
		if (distributer.getName() != null) {
			managed.setName(distributer.getName());
		}
		if (distributer.getSellers() != null) {
			managed.setSellers(distributer.getSellers());
		}
		if (distributer.getWebsiteURL() != null) {
			managed.setWebsiteURL(distributer.getWebsiteURL());
		}
		if (distributer.getTeaDetail() != null) {
			managed.setTeaDetail(distributer.getTeaDetail());
		}
		repo.saveAndFlush(managed);
		return managed;
	}

	@Override
	public Distributer replace(Distributer distributer) {
		Distributer managed = repo.findById(distributer.getId()).get();
		managed.setName(distributer.getName());
		managed.setSellers(distributer.getSellers());
		managed.setWebsiteURL(distributer.getWebsiteURL());
		managed.setTeaDetail(distributer.getTeaDetail());
		repo.saveAndFlush(managed);
		return managed;

	}

}
