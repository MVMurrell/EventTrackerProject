package com.skilldistillery.event.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="event_time")
	private String time;
	@Column(name="event_date")
	private String date;
	private Integer amount;
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@ManyToOne
	@JoinColumn(name="cognitive_status_id")
	private CognitiveStatus cs;
	
	@OneToOne
	@JoinColumn(name="coffee_id")
	private Coffee coffee;
	
	@OneToOne
	@JoinColumn(name="tea_id")
	private Tea tea;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public CognitiveStatus getCs() {
		return cs;
	}
	public void setCs(CognitiveStatus cs) {
		this.cs = cs;
	}
	public Coffee getCoffee() {
		return coffee;
	}
	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	public Tea getTea() {
		return tea;
	}
	public void setTea(Tea tea) {
		this.tea = tea;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((coffee == null) ? 0 : coffee.hashCode());
		result = prime * result + ((cs == null) ? 0 : cs.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((tea == null) ? 0 : tea.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Event other = (Event) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (coffee == null) {
			if (other.coffee != null)
				return false;
		} else if (!coffee.equals(other.coffee))
			return false;
		if (cs == null) {
			if (other.cs != null)
				return false;
		} else if (!cs.equals(other.cs))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (tea == null) {
			if (other.tea != null)
				return false;
		} else if (!tea.equals(other.tea))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", time=" + time + ", date=" + date + ", amount=" + amount + ", cs=" + cs
				+ ", coffee=" + coffee + ", tea=" + tea + "]";
	}
	public Event(int id, String time, String date, CognitiveStatus cs, Coffee coffee, Tea tea) {
		super();
		this.id = id;
//		this.user = user;
		this.time = time;
		this.date = date;
		this.cs = cs;
		this.coffee = coffee;
		this.tea = tea;
		
	}
	public Event() {
		super();
	}

	
}
