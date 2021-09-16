package com.brigelabz.hotelreservationsystem;

public class HotelModel {
	private String hotelName;
	private double hotelPrice;
	private String hotelType;
	public String getHotelName() {
		return hotelName;
	}
	public double getHotelPrice() {
		return hotelPrice;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setHotelPrice(double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public HotelModel(String hotelName, double hotelPrice, String hotelType) {
		super();
		this.hotelName = hotelName;
		this.hotelPrice = hotelPrice;
		this.hotelType = hotelType;
	}
	@Override
	public String toString() {
		return "HotelModel [hotelName=" + hotelName + ", hotelPrice=" + hotelPrice + ", hotelType=" + hotelType + "]";
	}
	
}
