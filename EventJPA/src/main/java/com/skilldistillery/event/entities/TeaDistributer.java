package com.skilldistillery.event.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tea_distributer")
public class TeaDistributer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String sellers;
	private String websiteURL;
	@JsonIgnore
	@OneToMany(mappedBy="teaDistributer")
	private List<TeaDetail> teaDetail;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sellers == null) ? 0 : sellers.hashCode());
		result = prime * result + ((teaDetail == null) ? 0 : teaDetail.hashCode());
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
		TeaDistributer other = (TeaDistributer) obj;
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
		if (teaDetail == null) {
			if (other.teaDetail != null)
				return false;
		} else if (!teaDetail.equals(other.teaDetail))
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
		return "Distributer [id=" + id + ", name=" + name + ", sellers=" + sellers + ", websiteURL=" + websiteURL + "]";
	}
	public TeaDistributer(int id, String name, String sellers, String websiteURL, List<TeaDetail> teaDetail) {
		super();
		this.id = id;
		this.name = name;
		this.sellers = sellers;
		this.websiteURL = websiteURL;
		this.teaDetail = teaDetail;
	}
	public TeaDistributer() {
		super();
	}
	
	
}
