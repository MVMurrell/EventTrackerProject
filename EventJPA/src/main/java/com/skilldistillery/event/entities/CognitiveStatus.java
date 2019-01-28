package com.skilldistillery.event.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cognitive_status")
public class CognitiveStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cognitive_status")
	private String cognitiveStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy="cs")
	private List<Event> events;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCognitiveStatus() {
		return cognitiveStatus;
	}
	public void setCognitiveStatus(String cognitiveStatus) {
		this.cognitiveStatus = cognitiveStatus;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognitiveStatus == null) ? 0 : cognitiveStatus.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
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
		CognitiveStatus other = (CognitiveStatus) obj;
		if (cognitiveStatus == null) {
			if (other.cognitiveStatus != null)
				return false;
		} else if (!cognitiveStatus.equals(other.cognitiveStatus))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CognitiveStatus [id=" + id + ", cognitiveStatus=" + cognitiveStatus + "]";
	}
	public CognitiveStatus(int id, String cognitiveStatus, List<Event> events) {
		super();
		this.id = id;
		this.cognitiveStatus = cognitiveStatus;
		this.events = events;
	}
	public CognitiveStatus() {
		super();
	}
	
}
