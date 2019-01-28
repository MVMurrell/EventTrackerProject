package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.CoffeeDistributer;
import com.skilldistillery.event.entities.Roast;
import com.skilldistillery.event.entities.TeaDetail;
import com.skilldistillery.event.repositories.CoffeeDistributerRepository;

@Transactional
@Service
public class CoffeeDistributerServiceImpl implements CoffeeDistributerService {

	@Autowired
	private CoffeeDistributerRepository repo;

	@Override
	public List<CoffeeDistributer> index() {
		return repo.findAll();
	}

	@Override
	public CoffeeDistributer show(Integer id) {
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
	public CoffeeDistributer create(CoffeeDistributer cd) {
		return repo.saveAndFlush(cd);
	}

	@Override
	public CoffeeDistributer update(CoffeeDistributer cd) {
		CoffeeDistributer managed = repo.findById(cd.getId()).get();
		if (cd.getName() != null) {
			managed.setName(cd.getName());
		}
		if (cd.getSellers() != null) {
			managed.setSellers(cd.getSellers());
		}
		if (cd.getWebsiteURL() != null) {
			managed.setWebsiteURL(cd.getWebsiteURL());
		}
		if (cd.getCoffeeDetail() != null) {
			managed.setCoffeeDetail(cd.getCoffeeDetail());
		}
		return repo.saveAndFlush(managed);
	}

	@Override
	public CoffeeDistributer replace(CoffeeDistributer cd) {
			CoffeeDistributer managed = repo.findById(cd.getId()).get();
			managed.setName(cd.getName());
			managed.setSellers(cd.getSellers());
			managed.setWebsiteURL(cd.getWebsiteURL());
			managed.setCoffeeDetail(cd.getCoffeeDetail());
			repo.saveAndFlush(managed);
			return managed;
		}


}
