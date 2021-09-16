package com.bridgelabz.hotelreservationsystem;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

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
	public void givenHotel_WhenProper_shouldReturnTrue(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("bridge", 100, 150, 3);
		LinkedList<HotelModel> hotelList = hotelReservation.getHotelList();
		assertEquals(3, hotelList.get(0).getRating());
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",110.0,90.0,3);
		hotelReservation.addHotel("Bridgewood",150.0,50.0,4);
		hotelReservation.addHotel("Ridgewood",220.0,150.0,5);
		
		List<HotelModel> hotels = hotelReservation.getCheapestHotel("11-9-2020","12-9-2020");
		System.out.println("the cheapest hotel is/are ");
		System.out.println(hotels);
		System.out.println();
	}
	@Test
	public void givenDateRange_find_CheapestAndBestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",110.0,90.0,3);
		hotelReservation.addHotel("Bridgewood",150.0,50.0,4);
		hotelReservation.addHotel("Ridgewood",220.0,150.0,5);
		
		HotelModel hotel = hotelReservation.getCheapestAndBestRatedHotel("11-9-2020","12-9-2020");
		System.out.println("the cheapest and best rated hotel is ");
		System.out.println(hotel);
		System.out.println();
	}
	@Test
	public void givenDateRange_find_BestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",110.0,90.0,3);
		hotelReservation.addHotel("Bridgewood",150.0,50.0,4);
		hotelReservation.addHotel("Ridgewood",220.0,150.0,5);
		
		HotelModel hotel = hotelReservation.getBestRatedHotel("11-9-2020","12-9-2020");
		System.out.println("the best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
	}
	
}
