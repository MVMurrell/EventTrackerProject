package com.skilldistillery.event.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.event.entities.TeaDistributer;
import com.skilldistillery.event.repositories.TeaDistributerRepository;

@Transactional
@Service
public class TeaDistributerServiceImpl implements TeaDistributerSevice {

	@Autowired
	private TeaDistributerRepository repo;

	@Override
	public List<TeaDistributer> index() {
		return repo.findAll();
	}

	@Override
	public TeaDistributer show(Integer id) {
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
	public TeaDistributer create(TeaDistributer teaDistributer) {
		return repo.saveAndFlush(teaDistributer);
	}

	@Override
	public TeaDistributer update(TeaDistributer teaDistributer) {
		TeaDistributer managed = repo.findById(teaDistributer.getId()).get();
		if (teaDistributer.getName() != null) {
			managed.setName(teaDistributer.getName());
		}
		if (teaDistributer.getSellers() != null) {
			managed.setSellers(teaDistributer.getSellers());
		}
		if (teaDistributer.getWebsiteURL() != null) {
			managed.setWebsiteURL(teaDistributer.getWebsiteURL());
		}
		if (teaDistributer.getTeaDetail() != null) {
			managed.setTeaDetail(teaDistributer.getTeaDetail());
		}
		repo.saveAndFlush(managed);
		return managed;
	}

	
	@Override
	public TeaDistributer replace(TeaDistributer teaDistributer) {
		TeaDistributer managed = repo.findById(teaDistributer.getId()).get();
		managed.setName(teaDistributer.getName());
		managed.setSellers(teaDistributer.getSellers());
		managed.setWebsiteURL(teaDistributer.getWebsiteURL());
		managed.setTeaDetail(teaDistributer.getTeaDetail());
		repo.saveAndFlush(managed);
		return managed;

	}

}
