package com.bridgelabz;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HotelReservation {

    static List<HotelData> hotelDataList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("welcome to Hotel Reservation");

        HotelData lakeWood = new HotelData("LakeWood", 110);
        HotelData bridgeWood = new HotelData("BridgeWood", 160);
        HotelData ridgeWood = new HotelData("RidgeWood", 220);
        hotelDataList.add(lakeWood);
        hotelDataList.add(bridgeWood);
        hotelDataList.add(ridgeWood);

        hotelDataList.forEach(output -> System.out.println(output));

        findCheapestHotel("06-Dec-2021", "09-Dec-2021");


    }

    public static void findCheapestHotel(String bookingFromDate, String leavingDate) {
        LocalDate checkInDate = LocalDate.parse(bookingFromDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        LocalDate checkOutDate = LocalDate.parse(leavingDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        int stayingDays = checkOutDate.getDayOfMonth() - checkInDate.getDayOfMonth() + 1;
        Optional<HotelData> cheapestHotel = hotelDataList.stream().sorted(Comparator.comparing(HotelData::getHotelRates)).findFirst();

        HotelData hotelData = new HotelData();
        hotelData.setHotelName(cheapestHotel.get().getHotelName());
        hotelData.setTotalPrice(cheapestHotel.get().getHotelRates() * stayingDays);
        System.out.println("Hotel Name " + hotelData.getHotelName());
        System.out.println("Total price for : " + stayingDays + " days is " + hotelData.getTotalPrice());
    }
}