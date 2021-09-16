package com.brigelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
	static ArrayList<HotelModel> hotelsArrayList = new ArrayList<HotelModel>();
public static void main(String [] args)
{
	
	System.out.println("Welcome to hotel reservation");
	System.out.println("Enter Hotel Name");
	Scanner scanner = new Scanner(System.in);
	String hotelName = scanner.next();
	System.out.println("Enter Hotel Type");
	String hotelType= scanner.next();
	System.out.println("Enter Hotel Price");
	double hotelPrice = scanner.nextInt();
	HotelModel hotelModel = new HotelModel(hotelName, hotelPrice, hotelType);
	hotelsArrayList.add(hotelModel);
}
public boolean addHotel(HotelModel hotelModel) {
	hotelsArrayList.add(hotelModel);
	return true;
}
}
