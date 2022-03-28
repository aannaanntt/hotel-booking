package com.hotel.booking.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.Reservation;
import com.hotel.booking.entity.Room;

import lombok.Data;

public class CustomerDTO {

	private String firstName;

	private String lastName;

	private String mobNo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = false)
	private List<Bill> bill;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = false)
	private List<Room> Room;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = false)
	private List<Reservation> reservation;

	public List<Room> getRoom() {
		return Room;
	}

	public void setRoom(List<Room> room) {
		Room = room;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

}
