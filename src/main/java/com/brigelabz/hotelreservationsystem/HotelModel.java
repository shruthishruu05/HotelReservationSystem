package com.brigelabz.hotelreservationsystem;

public class HotelModel {
	private String hotelName;
	private int  rating;
	private double price;
	public String getHotelName() {
		return hotelName;
	}
	public int getRating() {
		return rating;
	}
	public Double getPrice() {
		return price;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public HotelModel(String hotelName, double price, int rating) {
		super();
		this.hotelName = hotelName;
		this.price = price;
		this.rating = rating;
		
	}
	@Override
	public String toString() {
		return "HotelModel [hotelName=" + hotelName + ", rating=" + rating + ", price=" + price + "]";
	}
	
}