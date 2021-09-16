package com.bridgelabz.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Test;

import com.brigelabz.hotelreservationsystem.HotelModel;
import com.brigelabz.hotelreservationsystem.HotelReservation;

public class HotelReservationTest {

	@Test
	public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShoulReturnTrue()
	{
		HotelReservation hotelReservationService = new HotelReservation();
		HotelModel hotelModel = new HotelModel("Lakewood",  110, "General");
		boolean isValidHotel1 = hotelReservationService.addHotel(hotelModel);
		Assert.assertTrue(isValidHotel1);
		
	}
}
