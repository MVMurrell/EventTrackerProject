package com.skilldistillery.event.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CoffeeDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="coffeeDetail")
	private List<Coffee> coffee;
	
	@ManyToOne
	@JoinColumn(name="coffee_distributer_id")
	private CoffeeDistributer distributer;
	@ManyToOne
	@JoinColumn(name="roast")
	private Roast roast;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Coffee> getCoffee() {
		return coffee;
	}
	public void setCoffee(List<Coffee> coffee) {
		this.coffee = coffee;
	}
	public CoffeeDistributer getDistributer() {
		return distributer;
	}
	public void setDistributer(CoffeeDistributer distributer) {
		this.distributer = distributer;
	}
	public Roast getRoast() {
		return roast;
	}
	public void setRoast(Roast roast) {
		this.roast = roast;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffee == null) ? 0 : coffee.hashCode());
		result = prime * result + ((distributer == null) ? 0 : distributer.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((roast == null) ? 0 : roast.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeDetail other = (CoffeeDetail) obj;
		if (coffee == null) {
			if (other.coffee != null)
				return false;
		} else if (!coffee.equals(other.coffee))
			return false;
		if (distributer == null) {
			if (other.distributer != null)
				return false;
		} else if (!distributer.equals(other.distributer))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roast == null) {
			if (other.roast != null)
				return false;
		} else if (!roast.equals(other.roast))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CoffeeDetail [id=" + id + ", name=" + name + ", distributer=" + distributer + ", roast=" + roast + "]";
	}
	public CoffeeDetail(int id, String name, List<Coffee> coffee, CoffeeDistributer distributer, Roast roast) {
		super();
		this.id = id;
		this.name = name;
		this.coffee = coffee;
		this.distributer = distributer;
		this.roast = roast;
	}
	public CoffeeDetail() {
		super();
	}
	
}
