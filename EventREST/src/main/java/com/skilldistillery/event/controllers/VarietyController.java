package com.skilldistillery.event.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.event.services.VarietyService;

@RestController
@RequestMapping("api")
public class VarietyController {

	@Autowired
	private VarietyService vServ;
}
