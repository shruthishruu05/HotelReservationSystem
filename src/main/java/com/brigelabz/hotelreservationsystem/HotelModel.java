package com.brigelabz.hotelreservationsystem;

public class HotelModel 
{
	private String hotelName;
	private double weekDayRates;
	private double  weekEndRates;
	private int  rating;
	private double specialRewardWeekdayPrice;
	private double specialRewardWeekendPrice;

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
	public Double getSpecialRewardWeekdayPrice() {
		return specialRewardWeekdayPrice;
	}
	public Double getSpecialRewardWeekendPrice() {
		return specialRewardWeekendPrice;
	}
	public void setSpecialRewardWeekdayPrice(double specialRewardWeekdayPrice) {
		this.specialRewardWeekdayPrice = specialRewardWeekdayPrice;
	}
	public void setSpecialRewardWeekendPrice(double specialRewardWeekendPrice) {
		this.specialRewardWeekendPrice = specialRewardWeekendPrice;
	}
	@Override
	public String toString() {
		return "HotelModel [hotelName=" + hotelName + ", weekDayRates=" + weekDayRates + ", weekEndRates="
				+ weekEndRates + ", rating=" + rating + ", specialRewardWeekdayPrice=" + specialRewardWeekdayPrice
				+ ", specialRewardWeekendPrice=" + specialRewardWeekendPrice + "]";
	}
	
}