package com.brigelabz.hotelreservationsystem;

public class HotelModel 
{
	private String hotelName;
	private double weekDayRates;
	private double  weekEndRates;
	private int  rating;
	public String getHotelName() {
		return hotelName;
	}
	public double getWeekDayRates() {
		return weekDayRates;
	}
	public double getWeekEndRates() {
		return weekEndRates;
	}
	public int getRating() {
		return rating;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setWeekDayRates(double weekDayRates) {
		this.weekDayRates = weekDayRates;
	}
	public void setWeekEndRates(double weekEndRates) {
		this.weekEndRates = weekEndRates;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Double getPrice(int weekdays, int weekends) {
		return weekDayRates*weekdays + weekEndRates*weekends;
	}
	public HotelModel(String hotelName, double weekDayRates, double weekEndRates, int rating) {
		super();
		this.hotelName = hotelName;
		this.weekDayRates = weekDayRates;
		this.weekEndRates = weekEndRates;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "HotelModel [hotelName=" + hotelName + ", weekDayRates=" + weekDayRates + ", weekEndRates="
				+ weekEndRates + ", rating=" + rating + "]";
	}
	
}