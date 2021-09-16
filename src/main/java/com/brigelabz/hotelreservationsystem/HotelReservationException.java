package com.brigelabz.hotelreservationsystem;

public class HotelReservationException extends RuntimeException {
	enum exceptionType{
		ENTERED_NULL,ENTERED_EMPTY
	}
	exceptionType type;
	public HotelReservationException(exceptionType type, String message) {
		super(message);
		this.type = type;
	}
}