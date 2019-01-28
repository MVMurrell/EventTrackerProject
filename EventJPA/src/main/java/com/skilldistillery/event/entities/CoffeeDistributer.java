package com.skilldistillery.event.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CoffeeDistributer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String sellers;
	private String websiteURL;
	@OneToMany(mappedBy="distributer")
	private List<CoffeeDetail> coffeeDetail;
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
	public String getSellers() {
		return sellers;
	}
	public void setSellers(String sellers) {
		this.sellers = sellers;
	}
	public String getWebsiteURL() {
		return websiteURL;
	}
	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
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
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sellers == null) ? 0 : sellers.hashCode());
		result = prime * result + ((websiteURL == null) ? 0 : websiteURL.hashCode());
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
		CoffeeDistributer other = (CoffeeDistributer) obj;
		if (coffeeDetail == null) {
			if (other.coffeeDetail != null)
				return false;
		} else if (!coffeeDetail.equals(other.coffeeDetail))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sellers == null) {
			if (other.sellers != null)
				return false;
		} else if (!sellers.equals(other.sellers))
			return false;
		if (websiteURL == null) {
			if (other.websiteURL != null)
				return false;
		} else if (!websiteURL.equals(other.websiteURL))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CoffeeDistributer [id=" + id + ", name=" + name + ", sellers=" + sellers + ", websiteURL=" + websiteURL
				+ "]";
	}
	public CoffeeDistributer(int id, String name, String sellers, String websiteURL, List<CoffeeDetail> coffeeDetail) {
		super();
		this.id = id;
		this.name = name;
		this.sellers = sellers;
		this.websiteURL = websiteURL;
		this.coffeeDetail = coffeeDetail;
	}
	public CoffeeDistributer() {
		super();
	}
	
	
	
	
}
