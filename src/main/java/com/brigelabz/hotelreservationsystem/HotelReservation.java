package com.brigelabz.hotelreservationsystem;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.time.DayOfWeek;


public class HotelReservation{
	int weekdays =0, weekends =0;
	LinkedList<HotelModel> hotelList = new LinkedList<HotelModel>();
	public boolean addHotel(String hotelName,double weekDayRates,double weekEndRates ,int rating)
	{
		HotelModel hotelModel = new HotelModel(hotelName,weekDayRates,weekEndRates,rating);
		hotelList.add(hotelModel);
		System.out.println(hotelModel);
		System.out.println("\n");
		return true;
		
	}

public List<HotelModel> getCheapestHotel(LocalDate startDate, LocalDate endDate) {
	int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
   
    
	do {
		if(startDate.getDayOfWeek().equals("SUNDAY")||startDate.getDayOfWeek().equals("SATURDAY"))
			weekends++;
		else
		{
			weekdays++;
		}
        startDate = startDate.plusDays(1);
 
		} while(startDate.compareTo(endDate) !=0);
		
		final double cheapestPrice = hotelList.stream()
				.mapToDouble(hotel -> ((hotel.getWeekEndRates()*weekends) + hotel.getWeekDayRates()*weekdays))
				.min()
				.orElse(Double.MAX_VALUE);

		LinkedList<HotelModel> cheapestHotel = hotelList.stream()
				.filter(hotel -> (hotel.getWeekEndRates()*weekends + hotel.getWeekDayRates()*weekdays) == cheapestPrice)
				.collect(Collectors.toCollection(LinkedList::new));
		return cheapestHotel;

	}
}
