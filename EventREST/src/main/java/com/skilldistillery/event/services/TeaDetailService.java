package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.TeaDetail;

public interface TeaDetailService {

	public List <TeaDetail> index();
	public TeaDetail show(Integer id);
	public void delete(Integer id);
	public TeaDetail create(TeaDetail teaDetail);
	public TeaDetail update(TeaDetail teaDetail);
	public TeaDetail replace(TeaDetail teaDetail);
}
