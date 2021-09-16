package com.bridgelabz.hotelreservationsystem;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.brigelabz.hotelreservationsystem.HotelModel;
import com.brigelabz.hotelreservationsystem.HotelReservation;


public class HotelReservationTest
{
	@Test
	public void addedHotel_WhenProper_ShouldReturnTrue()
	{
		HotelReservation hotelReservation = new HotelReservation();
		boolean result = hotelReservation.addHotel("Lakewood", 300, 3);
		boolean result1  = hotelReservation.addHotel("Bridgewood", 400, 5);
		boolean result2 = hotelReservation.addHotel("Ridgewood", 500, 5);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenDate_find_CheapestHotel() {
		HotelReservation hotelManagement = new HotelReservation();
		hotelManagement.addHotel("Lakewood", 300, 3);
		hotelManagement.addHotel("Bridgewood", 400, 5);
		hotelManagement.addHotel("Ridgewood", 500, 5);
		LocalDate startDate = LocalDate.of(2021, 9, 10);
		LocalDate endDate = LocalDate.of(2021, 9, 11);
		HotelModel hotel = hotelManagement.getCheapestHotel(startDate, endDate);
		System.out.println("the hotel with cheapest price is "+hotel);
	}
}