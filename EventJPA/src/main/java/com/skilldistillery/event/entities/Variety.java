package com.skilldistillery.event.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tea_variety")
public class Variety {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  String variety;
	@OneToMany(mappedBy="variety")
	private List<TeaDetail> teaDetail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public List<TeaDetail> getTeaDetail() {
		return teaDetail;
	}
	public void setTeaDetail(List<TeaDetail> teaDetail) {
		this.teaDetail = teaDetail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((teaDetail == null) ? 0 : teaDetail.hashCode());
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
		Variety other = (Variety) obj;
		if (id != other.id)
			return false;
		if (teaDetail == null) {
			if (other.teaDetail != null)
				return false;
		} else if (!teaDetail.equals(other.teaDetail))
			return false;
		if (variety == null) {
			if (other.variety != null)
				return false;
		} else if (!variety.equals(other.variety))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Variety [id=" + id + ", variety=" + variety + "]";
	}
	public Variety(int id, String variety, List<TeaDetail> teaDetail) {
		super();
		this.id = id;
		this.variety = variety;
		this.teaDetail = teaDetail;
	}
	public Variety() {
		super();
	}
	

}
