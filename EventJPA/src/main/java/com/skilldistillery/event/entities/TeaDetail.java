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
public class TeaDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="teaDetail")
	private List<Tea> teas;
	@ManyToOne
	@JoinColumn(name="variety_id")
	private Variety variety;
	@ManyToOne
	@JoinColumn(name="distributer_id")
	private Distributer distributer;
	public TeaDetail(int id, String name, List<Tea> teas, Variety variety, Distributer distributer) {
		super();
		this.id = id;
		this.name = name;
		this.teas = teas;
		this.variety = variety;
		this.distributer = distributer;
	}
	public TeaDetail() {
		super();
	}
	@Override
	public String toString() {
		return "TeaDetail [id=" + id + ", name=" + name + ", variety=" + variety + ", distributer=" + distributer + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distributer == null) ? 0 : distributer.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teas == null) ? 0 : teas.hashCode());
		result = prime * result + ((variety == null) ? 0 : variety.hashCode());
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
		TeaDetail other = (TeaDetail) obj;
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
		if (teas == null) {
			if (other.teas != null)
				return false;
		} else if (!teas.equals(other.teas))
			return false;
		if (variety == null) {
			if (other.variety != null)
				return false;
		} else if (!variety.equals(other.variety))
			return false;
		return true;
	}
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
	public List<Tea> getTeas() {
		return teas;
	}
	public void setTeas(List<Tea> teas) {
		this.teas = teas;
	}
	public Variety getVariety() {
		return variety;
	}
	public void setVariety(Variety variety) {
		this.variety = variety;
	}
	public Distributer getDistributer() {
		return distributer;
	}
	public void setDistributer(Distributer distributer) {
		this.distributer = distributer;
	}
	
}
