package com.hotel.booking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billId;

	private int totalDays;

	private int totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roomId")
	private Room room;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int totalDays, int totalCost) {
		super();
		this.totalDays = totalDays;
		this.totalCost = totalCost;
		
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", totalDays=" + totalDays + ", totalCost=" + totalCost + "]";
	}

}
