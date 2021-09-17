package com.brigelabz.hotelreservationsystem;

import java.util.List;

public interface HotelReservationIF {
	void  addHotel(String hotelName, double weekDayRates, double weekEndRates, int rating, double rewardedWeekdayPrice, double rewardedweekendPrice);
	//void  addHotel(HotelModel hotel);
	List<HotelModel> getCheapestHotel(String date1, String date2, CustomerType cType);
	HotelModel getCheapestAndBestRatedHotel(String date1, String date2, CustomerType cType);
	HotelModel getBestRatedHotel(String date1, String date2,CustomerType cType);
}
