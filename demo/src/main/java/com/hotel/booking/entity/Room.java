package com.hotel.booking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;

	private int totalPersons;

	private int rating;

	private String category;

	@OneToOne(mappedBy = "room")
	private Bill bill;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="reservationId")
	private Reservation reservation;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Room(Reservation reservation) {
		super();
		this.reservation = reservation;
	}

	public Room(int totalPersons, int rating, String category) {
		super();
		this.totalPersons = totalPersons;
		this.rating = rating;
		this.category = category;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public int getTotalPersons() {
		return totalPersons;
	}

	public void setTotalPersons(int totalPersons) {
		this.totalPersons = totalPersons;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", totalPersons=" + totalPersons + ", rating=" + rating + ", category="
				+ category + ", bill=" + bill + ", reservation=" + reservation + "]";
	}

}
