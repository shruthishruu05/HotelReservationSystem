package com.brigelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HotelReservation{
	LinkedList<HotelModel> hotelList = new LinkedList<HotelModel>();
	public boolean addHotel(String hotelName,double weekDayRates,double weekEndRates ,int rating)
	{
		HotelModel hotelModel = new HotelModel(hotelName,weekDayRates,weekEndRates,rating);
		hotelList.add(hotelModel);
		System.out.println(hotelModel);
		System.out.println("\n");
		return true;
		
	}

	public HotelModel getCheapestHotel(LocalDate startDate, LocalDate endDate) {
		Period period = Period.between(startDate, endDate);
		int noOfDaysBetween = (int)ChronoUnit.DAYS.between(startDate, endDate);
		return hotelList.stream().min((h1,h2) -> h1.getPrice(noOfDaysBetween).compareTo(h2.getPrice(noOfDaysBetween))).orElse(null);
	}
}
