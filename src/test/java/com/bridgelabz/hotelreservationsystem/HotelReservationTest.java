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
		boolean result = hotelReservation.addHotel("Lakewood", 110,90,2);
		boolean result1  = hotelReservation.addHotel("Bridgewood", 150, 50,1);
		boolean result2 = hotelReservation.addHotel("Ridgewood",220,150,4);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenDate_find_CheapestHotel() {
		HotelReservation hotelManagement = new HotelReservation();
		hotelManagement.addHotel("Lakewood", 110,90,2);
		hotelManagement.addHotel("Bridgewood", 150, 50,1);
		hotelManagement.addHotel("Ridgewood",220,150,4);
		LocalDate startDate = LocalDate.of(2021, 9, 10);
		LocalDate endDate = LocalDate.of(2021, 9, 11);
		HotelModel hotel = hotelManagement.getCheapestHotel(startDate, endDate);
		System.out.println("the hotel with cheapest price is "+hotel);
	}
}