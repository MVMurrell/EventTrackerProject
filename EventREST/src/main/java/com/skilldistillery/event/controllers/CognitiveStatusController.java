package com.skilldistillery.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.event.entities.CognitiveStatus;
import com.skilldistillery.event.services.CognitiveStatusService;

@RestController
@RequestMapping("api")
public class CognitiveStatusController {

	
	@Autowired
	private CognitiveStatusService cServ;
	
	@GetMapping("status")
	public List<CognitiveStatus> listStatus() {
		return cServ.index();
	}
}
