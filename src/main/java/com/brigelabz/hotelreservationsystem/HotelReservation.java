package com.brigelabz.hotelreservationsystem;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;


public class HotelReservation{
	int numOfWeekends =0, numOfWeekdays =0;
	LinkedList<HotelModel> hotelList = new LinkedList<HotelModel>();
	public boolean addHotel(String hotelName,double weekDayRates,double weekEndRates ,int rating)
	{
		HotelModel hotelModel = new HotelModel(hotelName,weekDayRates,weekEndRates,rating);
		hotelList.add(hotelModel);
		System.out.println(hotelModel);
		System.out.println("\n");
		return true;
		
	}

public List<HotelModel> getCheapestHotel(String date1, String date2) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();
		try {
			startDate.setTime(sdf.parse(date1));
			endDate.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		do {
			if(startDate.get(Calendar.DAY_OF_WEEK) == 0 || startDate.get(Calendar.DAY_OF_WEEK) == 6) numOfWeekends++;
			else numOfWeekdays++;
			startDate.add(Calendar.DATE,1);
		} while(startDate.compareTo(endDate) <=0);
		
		HotelModel cheapestHotel = hotelList.stream()
							.min((h1,h2) -> h1.getPrice(numOfWeekdays,numOfWeekends).compareTo(h2.getPrice(numOfWeekdays,numOfWeekends)))
							.orElse(null);
		
		double cheapestPrice = cheapestHotel.getPrice(numOfWeekdays,numOfWeekends);
		System.out.println("the minimum price is : "+cheapestPrice);
		Predicate<HotelModel> isMinimum = (hotel) -> (hotel.getPrice(numOfWeekdays,numOfWeekends) == cheapestPrice)?true:false; 
		List<HotelModel> cheapestHotels = hotelList.stream()
									 .filter(isMinimum)
									 .collect(Collectors.toList());
		return cheapestHotels;
	}
	public HotelModel getCheapestAndBestRatedHotel(String date1, String date2) {
		List<HotelModel> cheapestHotels = getCheapestHotel(date1,date2);
		
	return cheapestHotels.stream()
		   .max((h1,h2) -> h1.getRating()-h2.getRating())
		   .orElse(null);
}

public LinkedList<HotelModel> getHotelList() {
	// TODO Auto-generated method stub
	return this.hotelList;
}
}
