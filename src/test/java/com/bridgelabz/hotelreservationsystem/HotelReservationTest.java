package com.bridgelabz.hotelreservationsystem;
import static org.junit.Assert.assertEquals;

	
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.brigelabz.hotelreservationsystem.CustomerType;
import com.brigelabz.hotelreservationsystem.HotelModel;
import com.brigelabz.hotelreservationsystem.HotelReservationException;
import com.brigelabz.hotelreservationsystem.HotelReservationImpl;




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
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",100.0,110.0,3,80.0,80.0);
		LinkedList<HotelModel> hotelList = hotelReservation.getHotelList();
		assertEquals("Lakewood", hotelList.get(0).getHotelName());
	}

	
	@Test
	public void givenHotelRating_WhenProper_shouldReturnTrue(){
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("bridge",100.0,110.0,3,80.0,80.0);
		LinkedList<HotelModel> hotelList = hotelReservation.getHotelList();
		assertEquals(3, hotelList.get(0).getRating());
	}
	
	@Test
	public void givenDate_WhenProper_findCheapestHotel() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		List<HotelModel> hotels = hotelReservation.getCheapestHotel("11-9-2020","12-9-2020",CustomerType.REGULAR);
		System.out.println("the cheapest hotel is--> ");
		System.out.println(hotels);
		System.out.println();
	}
	@Test
	public void givenDateRange_WhenProper_findCheapestAndBestRatedHotel() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		HotelModel hotel = hotelReservation.getCheapestAndBestRatedHotel("11-9-2020","12-9-2020",CustomerType.REGULAR);
		System.out.println("the cheapest and best rated hotel is-->");
		System.out.println(hotel);
		System.out.println();
	}
	@Test
	public void givenDate_WhenProper_FindBestRatedHotel() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		HotelModel hotel = hotelReservation.getBestRatedHotel("11-9-2020","12-9-2020",CustomerType.REGULAR);
		System.out.println("the best rated hotel-->");
		System.out.println(hotel);
		System.out.println();
	
	}
	
	@Test
	public void givenDateAndRewardUser_Shoulffind_BestRatedHotel() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		
		HotelModel hotel = hotelReservation.getBestRatedHotel("11-9-2020","12-9-2020",CustomerType.REWARDED);
		System.out.println("the best rated hotel is -->");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}
	
	@Test
	public void givenDateRange_IfIsEmpty_ShouldThrowException() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelReservationException.class);
		try {
			HotelModel hotel = hotelReservation.getBestRatedHotel(null,"12-9-2020",CustomerType.REWARDED);
		}
		catch(HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	
	@Test
	public void givenDate_IfIsNull_ShouldThrowException() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelReservationException.class);
		try {
			HotelModel hotel = hotelReservation.getBestRatedHotel(null,"12-9-2020",CustomerType.REWARDED);
		}
		catch(HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		
	}
	@Test
	public void givenDateRangeAndCustomerType_IfEmpty_ShouldThrowException() {
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		hotelReservation.addHotel("Lakewood",110,90,3,80,80);
		hotelReservation.addHotel("Bridgewood",150,50,4,110,50);
		hotelReservation.addHotel("Ridgewood",220,150,5,100,40);
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelReservationException.class);
		try {
			HotelModel hotel = hotelReservation.getBestRatedHotel("","12-9-2020",CustomerType.REWARDED);
		}
		catch(HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	@Test
	public void givenDate_WhenProper_ShouldReturnTrue() {
		
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		boolean result = hotelReservation.validateDate("2021-12-13");
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenDate_WhenNotProperFormat_ShouldReturnFalse() 
	{
		
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		boolean result = hotelReservation.validateDate("4-10-2016");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenDate_WhenSeperatedBySlashes_ShouldReturnFalse() {
		
		HotelReservationImpl hotelReservation = new HotelReservationImpl();
		boolean result = hotelReservation.validateDate("2015/\10\2021");
		Assert.assertFalse(result);
	}
	
		
}
