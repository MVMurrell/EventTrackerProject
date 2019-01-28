package com.skilldistillery.event.services;

import java.util.List;

import com.skilldistillery.event.entities.Coffee;
import com.skilldistillery.event.entities.CognitiveStatus;

public interface CognitiveStatusService {

	public List <CognitiveStatus> index();
	public CognitiveStatus show(Integer id);
	public void delete(Integer id);
	public CognitiveStatus create(CognitiveStatus status);
	public CognitiveStatus update(CognitiveStatus status);
	public CognitiveStatus replace(CognitiveStatus status);
	
}
