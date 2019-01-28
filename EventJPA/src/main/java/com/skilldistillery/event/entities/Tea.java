package com.skilldistillery.event.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Tea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(mappedBy="tea")
	private Event event;
	private double amount;
	@ManyToOne
	@JoinColumn(name="detail_id")
	private TeaDetail teaDetail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TeaDetail getTeaDetail() {
		return teaDetail;
	}
	public void setTeaDetail(TeaDetail teaDetail) {
		this.teaDetail = teaDetail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + id;
		result = prime * result + ((teaDetail == null) ? 0 : teaDetail.hashCode());
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
		Tea other = (Tea) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		if (teaDetail == null) {
			if (other.teaDetail != null)
				return false;
		} else if (!teaDetail.equals(other.teaDetail))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tea [id=" + id + ", event=" + event + ", amount=" + amount + ", teaDetail=" + teaDetail + "]";
	}
	public Tea(int id, Event event, double amount, TeaDetail teaDetail) {
		super();
		this.id = id;
		this.event = event;
		this.amount = amount;
		this.teaDetail = teaDetail;
	}
	public Tea() {
		super();
	}

	
}
