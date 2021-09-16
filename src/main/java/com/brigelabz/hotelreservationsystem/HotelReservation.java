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
import java.util.regex.Pattern;


public class HotelReservation{
	int Weekends =0, Weekdays =0;
	LinkedList<HotelModel> hotelList = new LinkedList<HotelModel>();
	
	public void  addHotel(String hotelName, double weekDayRates, double weekEndRates, int rating, double rewardedWeekdayPrice, double rewardedweekendPrice)throws HotelReservationException 
	{
		try {
			if(hotelName.length() == 0) 
				throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_EMPTY, "Empty value entered");
		HotelModel hotel = new HotelModel();
		hotel.setHotelName(hotelName);
		hotel.setWeekDayRates(weekDayRates);
		hotel.setWeekEndRates(weekEndRates);
		hotel.setRating(rating);
		hotel.setSpecialRewardWeekdayPrice(rewardedWeekdayPrice);
		hotel.setSpecialRewardWeekendPrice(rewardedweekendPrice);
		hotelList.add(hotel);
		}
		catch(NullPointerException e) {
			throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_NULL, "NULL Value Entered");
		}	
		
	}
	
	public LinkedList<HotelModel> getHotelList() {
		// TODO Auto-generated method stub
		return this.hotelList;
	}

public List<HotelModel> getCheapestHotel(String date1, String date2,CustomerType cType) {
	try {
		if(date1.length() == 0 || date2.length() == 0) 
			throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_EMPTY, "Empty value entered");
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");
		try {
			startDate.setTime(format.parse(date1));
			endDate.setTime(format.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		do {
			if(startDate.get(Calendar.DAY_OF_WEEK) == 0 || startDate.get(Calendar.DAY_OF_WEEK) == 6) 
				Weekends++;
			else 
				{
				Weekdays++;
				}
			startDate.add(Calendar.DATE,1);
		} while(startDate.compareTo(endDate) <=0);
		
		HotelModel cheapestHotel = hotelList.stream()
							.min((h1,h2) -> h1.getPrice(Weekdays,Weekends).compareTo(h2.getPrice(Weekdays,Weekends)))
							.orElse(null);
		
		double cheapestPrice = cheapestHotel.getPrice(Weekdays,Weekends);
		System.out.println("the minimum price is : "+cheapestPrice);
		Predicate<HotelModel> isMinimum = (hotel) -> (hotel.getPrice(Weekdays,Weekends) == cheapestPrice)?true:false; 
		List<HotelModel> cheapestHotels = hotelList.stream()
									 .filter(isMinimum)
									 .collect(Collectors.toList());
		return cheapestHotels;
	}
	catch(NullPointerException e) 
	{
		throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_NULL, "NULL Value Entered");
	}
	}
	public HotelModel getCheapestAndBestRatedHotel(String date1, String date2,CustomerType cType)throws HotelReservationException {
		List<HotelModel> cheapestHotels = getCheapestHotel(date1,date2,cType);
		
	return cheapestHotels.stream()
		   .max((h1,h2) -> h1.getRating()-h2.getRating())
		   .orElse(null);
}

	public HotelModel getBestRatedHotel(String date1, String date2,CustomerType cType)throws HotelReservationException 
	{
		try {
			if(date1.length() == 0 || date2.length() == 0) 
				throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_EMPTY, "Empty value entered");
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		try {
			startDate.setTime(format.parse(date1));
			endDate.setTime(format.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		do {
			if(startDate.get(Calendar.DAY_OF_WEEK) == 0 || startDate.get(Calendar.DAY_OF_WEEK) == 6) 
				Weekends++;
			else {
				Weekdays++;
			}
			startDate.add(Calendar.DATE,1);
		} while(startDate.compareTo(endDate) <=0);
		
		HotelModel bestRatedHotel = hotelList.stream()
							   .max((h1,h2) -> h1.getRating()-h2.getRating())
							   .orElse(null);
		System.out.println("the cost is : "+bestRatedHotel.getPrice(Weekdays, Weekends));
		return bestRatedHotel;
		}
		catch(NullPointerException e) {
			throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_NULL, "NULL Value Entered");
		}
		
	}
	
	public boolean validateDate(String date) {
		
		try {
			if(date.length() == 0)
				throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_EMPTY, "Date entered Is EMPTY");
			
			String date_Reg_Ex = "^([0-9]{4})[-](([0][1-9])|([1][0-2]))[-]([0-2][0-9]|(3)[0-1])$";
			return date.matches(date_Reg_Ex);
		}
		catch(NullPointerException e) {
			throw new HotelReservationException(HotelReservationException.exceptionType.ENTERED_NULL, "Date entered	 is NULL");
		}
	
	
}
}

