package com.bridgelabz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HotelReservation {

    static List<HotelData> hotelDataList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("welcome to Hotel Reservation");


        HotelData lakeWood = new HotelData("LakeWood", 110, 90);
        HotelData bridgeWood = new HotelData("BridgeWood", 150, 50);
        HotelData ridgeWood = new HotelData("RidgeWood", 220, 150);
        hotelDataList.add(lakeWood);
        hotelDataList.add(bridgeWood);
        hotelDataList.add(ridgeWood);

        hotelDataList.forEach(output -> System.out.println(output));

        findCheapestHotelWeekdays("06-Dec-2021", "09-Dec-2021");
        findCheapestHotelWeekend("11-Jan-2022", "14-Jan-2022");


    }

    public static void findCheapestHotelWeekdays(String bookingFromDate, String leavingDate) {
        LocalDate checkInDate = LocalDate.parse(bookingFromDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        LocalDate checkOutDate = LocalDate.parse(leavingDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        int stayingDays = checkOutDate.getDayOfMonth() - checkInDate.getDayOfMonth() + 1;
        Optional<HotelData> cheapestHotel = hotelDataList.stream().sorted(Comparator.comparing(HotelData::getWeekdayRates))
                .findFirst();

        HotelData hotelData = new HotelData();
        hotelData.setHotelName(cheapestHotel.get().getHotelName());
        hotelData.setTotalPrice(cheapestHotel.get().getWeekdayRates() * stayingDays);
        System.out.println("Hotel Name " + hotelData.getHotelName());
        System.out.println("Total price in weekdays : " + stayingDays + hotelData.getTotalPrice());
    }

    public static void findCheapestHotelWeekend(String bookingFromDate, String leavingDate) {
        LocalDate checkInDate = LocalDate.parse(bookingFromDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        LocalDate checkOutDate = LocalDate.parse(leavingDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        int stayingDays = checkOutDate.getDayOfMonth() - checkInDate.getDayOfMonth() + 1;
        Optional<HotelData> cheapestHotel = hotelDataList.stream().sorted(Comparator.comparing(HotelData::getWeekdayRates))
                .findFirst();

        HotelData hotelData = new HotelData();
        hotelData.setHotelName(cheapestHotel.get().getHotelName());
        hotelData.setTotalPrice(cheapestHotel.get().getWeekendRates() * stayingDays);
        System.out.println("Hotel Name " + hotelData.getHotelName());
        System.out.println("Total price in weekends : " + stayingDays + hotelData.getTotalPrice());
    }
}