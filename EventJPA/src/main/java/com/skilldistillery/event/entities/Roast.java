package com.skilldistillery.event.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roast {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="coffee_type")
	private String coffeeType;
	
	@JsonIgnore
	@OneToMany(mappedBy="roast")
	private List<CoffeeDetail> coffeeDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public List<CoffeeDetail> getCoffeeDetail() {
		return coffeeDetail;
	}

	public void setCoffeeDetail(List<CoffeeDetail> coffeeDetail) {
		this.coffeeDetail = coffeeDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeDetail == null) ? 0 : coffeeDetail.hashCode());
		result = prime * result + ((coffeeType == null) ? 0 : coffeeType.hashCode());
		result = prime * result + id;
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
		Roast other = (Roast) obj;
		if (coffeeDetail == null) {
			if (other.coffeeDetail != null)
				return false;
		} else if (!coffeeDetail.equals(other.coffeeDetail))
			return false;
		if (coffeeType == null) {
			if (other.coffeeType != null)
				return false;
		} else if (!coffeeType.equals(other.coffeeType))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roast [id=" + id + ", coffeeType=" + coffeeType + "]";
	}

	public Roast(int id, String coffeeType, List<CoffeeDetail> coffeeDetail) {
		super();
		this.id = id;
		this.coffeeType = coffeeType;
		this.coffeeDetail = coffeeDetail;
	}

	public Roast() {
		super();
	}

	
	
	
}
