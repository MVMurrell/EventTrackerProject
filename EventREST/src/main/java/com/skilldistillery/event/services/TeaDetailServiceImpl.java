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

import com.skilldistillery.event.entities.Tea;
import com.skilldistillery.event.entities.TeaDetail;
import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.repositories.TeaDetailRepository;

@Transactional
@Service
public class TeaDetailServiceImpl implements TeaDetailService {

	@Autowired
	private TeaDetailRepository repo;

	@Override
	public List<TeaDetail> index() {
		return repo.findAll();
	}

	@Override
	public TeaDetail show(Integer id) {
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
	public TeaDetail create(TeaDetail teaDetail) {
		return repo.saveAndFlush(teaDetail);	
	}

	@Override
	public TeaDetail update(TeaDetail teaDetail) {
		TeaDetail managed = repo.findById(teaDetail.getId()).get();
		if(teaDetail.getName() != null) {managed.setName(teaDetail.getName());}
		if(teaDetail.getTeas() != null) {managed.setTeas(teaDetail.getTeas());}
		if(teaDetail.getVariety() != null) {managed.setVariety(teaDetail.getVariety());}
		if(teaDetail.getDistributer() != null) {managed.setDistributer(teaDetail.getDistributer());}
		
		return repo.saveAndFlush(managed);
	}

	@Override
	public TeaDetail replace(TeaDetail teaDetail) {
		TeaDetail managed = repo.findById(teaDetail.getId()).get();
		managed.setName(teaDetail.getName());
		managed.setTeas(teaDetail.getTeas());
		managed.setVariety(teaDetail.getVariety());
		managed.setDistributer(teaDetail.getDistributer());
		repo.saveAndFlush(managed);
		return managed;
	}

}
