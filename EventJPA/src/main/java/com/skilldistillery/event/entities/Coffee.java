package com.skilldistillery.event.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Coffee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;
	@OneToOne
	@JoinColumn(name="event_id")
	private Event event;
	@ManyToOne
	@JoinColumn(name="detail_id")
	private CoffeeDetail coffeeDetail;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public CoffeeDetail getCoffeeDetail() {
		return coffeeDetail;
	}
	public void setCoffeeDetail(CoffeeDetail coffeeDetail) {
		this.coffeeDetail = coffeeDetail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((coffeeDetail == null) ? 0 : coffeeDetail.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
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
		Coffee other = (Coffee) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (coffeeDetail == null) {
			if (other.coffeeDetail != null)
				return false;
		} else if (!coffeeDetail.equals(other.coffeeDetail))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Coffee [id=" + id + ", amount=" + amount + ", event=" + event + ", coffeeDetail=" + coffeeDetail + "]";
	}
	public Coffee(int id, double amount, Event event, CoffeeDetail coffeeDetail) {
		super();
		this.id = id;
		this.amount = amount;
		this.event = event;
		this.coffeeDetail = coffeeDetail;
	}
	public Coffee() {
		super();
	}
	
	

}
