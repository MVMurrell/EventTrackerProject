package com.skilldistillery.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.event.entities.Coffee;
import com.skilldistillery.event.entities.CoffeeDetail;
import com.skilldistillery.event.entities.CoffeeDistributer;
import com.skilldistillery.event.entities.Roast;
import com.skilldistillery.event.services.CoffeeDetailService;
import com.skilldistillery.event.services.CoffeeDistributerService;
import com.skilldistillery.event.services.CoffeeService;
import com.skilldistillery.event.services.RoastService;

@RestController
@RequestMapping("api")
public class CoffeeController {

	@Autowired
	private CoffeeService cServ;
	@Autowired
	private RoastService rServ;
	@Autowired
	private CoffeeDetailService cdServ;

	@Autowired
	private CoffeeDistributerService dServ;

	@GetMapping("coffees")
	public List<Coffee> listCoffees() {
		return cServ.index();
	}
	
	@GetMapping("coffee/{id}")
	public Coffee findCoffeeById(@PathVariable int id) {
		return cServ.show(id);
	}

	@DeleteMapping("coffee/{id}")
	public void deleteCoffee(@PathVariable int id) {
		cServ.delete(id);
	}

	@PostMapping("coffee")
	public Coffee createCoffee(@RequestBody Coffee coffee) {
		if (coffee != null) {
			return cServ.create(coffee);

		}
		return null;
	}

	@PatchMapping("coffee")
	public Coffee updateCoffee(@RequestBody Coffee coffee) {
		return cServ.update(coffee);
	}

	@PutMapping("coffee")
	public Coffee replaceCoffee(@RequestBody Coffee coffee) {
		return cServ.replace(coffee);
	}

	@GetMapping("roasts")
	public List<Roast> listRoasts() {
		return rServ.index();
	}
	
	@GetMapping("roast/{id}")
	public Roast findRoastById(@PathVariable int id) {
		return rServ.show(id);
	}

	@DeleteMapping("roast/{id}")
	public void deleteRoast(@PathVariable int id) {
		rServ.delete(id);
	}

	@PostMapping("roast")
	public Roast createRoast(@RequestBody Roast roast) {
		if (roast != null) {
			return rServ.create(roast);

		}
		return null;
	}

	@PatchMapping("roast")
	public Roast updateRoast(@RequestBody Roast roast) {
		return rServ.update(roast);
	}

	@PutMapping("roast")
	public Roast replaceRoast(@RequestBody Roast roast) {
		return rServ.replace(roast);
	}

	@GetMapping("distributers")
	public List<CoffeeDistributer> listDistributers() {
		return dServ.index();
	}
	@GetMapping("distributer/{id}")
	public CoffeeDistributer findDistById(@PathVariable int id) {
		return dServ.show(id);
	}
	@DeleteMapping("distributer/{id}")
	public void deleteDistributer(@PathVariable int id) {
		dServ.delete(id);
	}

	@PostMapping("distributer")
	public CoffeeDistributer createDistributer(@RequestBody CoffeeDistributer distributer) {
		if (distributer != null) {
			return dServ.create(distributer);

		}
		return null;
	}

	@PatchMapping("distributer")
	public CoffeeDistributer updateDetail(@RequestBody CoffeeDistributer distributer) {
		return dServ.update(distributer);
	}

	@PutMapping("distributer")
	public CoffeeDistributer replaceDetail(@RequestBody CoffeeDistributer distributer) {
		return dServ.replace(distributer);
	}
	
	
	@GetMapping("details")
	public List<CoffeeDetail> listdetails() {
		return cdServ.index();
	}
	@GetMapping("detail/{id}")
	public CoffeeDetail findDetailById(@PathVariable int id) {
		return cdServ.show(id);
	}
	@DeleteMapping("detail/{id}")
	public void deleteDetail(@PathVariable int id) {
		cdServ.delete(id);
	}

	@PostMapping("detail")
	public CoffeeDetail createDetail(@RequestBody CoffeeDetail detail) {
		if (detail != null) {
			return cdServ.create(detail);

		}
		return null;
	}

	@PatchMapping("detail")
	public CoffeeDetail updateDetail(@RequestBody CoffeeDetail detail) {
		return cdServ.update(detail);
	}

	@PutMapping("detail")
	public CoffeeDetail replaceDetail(@RequestBody CoffeeDetail detail) {
		return cdServ.replace(detail);
	}
}
