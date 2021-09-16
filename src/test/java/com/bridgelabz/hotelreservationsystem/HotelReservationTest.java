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
	/*@Test
	public void addedHotel_WhenProper_ShouldReturnTrue()
	{
		HotelReservation hotelReservation = new HotelReservation();
		boolean result = hotelReservation.addHotel("Lakewood",100.0,110.0,3,80.0,80.0);
		//boolean result1  = hotelReservation.addHotel("Bridgewood", 150, 50,1);
		//boolean result2 = hotelReservation.addHotel("Ridgewood",220,150,4);
		Assert.assertTrue(result);
	}
	*/
	@Test
	public void givenHotelName_shouldReturnProperHotelName(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",100.0,110.0,3,80.0,80.0);
		LinkedList<HotelModel> hotelList = hotelReservation.getHotelList();
		assertEquals("Lakewood", hotelList.get(0).getHotelName());
	}

	
	@Test
	public void givenHotelRating_WhenProper_shouldReturnTrue(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("bridge",100.0,110.0,3,80.0,80.0);
		LinkedList<HotelModel> hotelList = hotelReservation.getHotelList();
		assertEquals(3, hotelList.get(0).getRating());
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		List<HotelModel> hotels = hotelReservation.getCheapestHotel("11-9-2020","12-9-2020");
		System.out.println("the cheapest hotel is--> ");
		System.out.println(hotels);
		System.out.println();
	}
	@Test
	public void givenDateRange_find_CheapestAndBestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		HotelModel hotel = hotelReservation.getCheapestAndBestRatedHotel("11-9-2020","12-9-2020");
		System.out.println("the cheapest and best rated hotel is-->");
		System.out.println(hotel);
		System.out.println();
	}
	@Test
	public void givenDateRange_find_BestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		HotelModel hotel = hotelReservation.getBestRatedHotel("11-9-2020","12-9-2020");
		System.out.println("the best rated hotel-->");
		System.out.println(hotel);
		System.out.println();
	}
	
}
