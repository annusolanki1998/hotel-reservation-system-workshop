package com.bridgelabz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HotelReservation {

    static List<HotelData> hotelDataList = new ArrayList<>();
    static List<HotelData> specialList = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("welcome to Hotel Reservation");

        System.out.println("Normal rates for customers");
        HotelData lakeWood = new HotelData("lakeWood", 110, 90, 3);
        HotelData bridgeWood = new HotelData("BridgeWood", 150, 50, 5);
        HotelData ridgeWood = new HotelData("RidgeWood", 220, 150, 4);
        hotelDataList.add(lakeWood);
        hotelDataList.add(bridgeWood);
        hotelDataList.add(ridgeWood);
        hotelDataList.forEach(output -> System.out.println(output));

        System.out.println();

        System.out.println("Special rates for reward customer is : ");
        HotelData lakeWood1 = new HotelData("lakeWood", 80, 80, 3);
        HotelData bridgeWood2 = new HotelData("BridgeWood", 110, 50, 5);
        HotelData ridgeWood3 = new HotelData("RidgeWood", 100, 400, 4);
        specialList.add(lakeWood1);
        specialList.add(bridgeWood2);
        specialList.add(ridgeWood3);
        specialList.forEach(output -> System.out.println(output));


        findCheapestHotelWeekdays("10-Sep-2020", "11-Sep-2020");
        findCheapestHotelWeekend("11-Sep-2020", "12-Sep-2020");
        findCheapestBestRatedHotel("11-Sep-2020", "12-Sep-2020");
        findBestRatedHotel("11-Sep-2020", "12-Sep-2020");


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

    public static void findCheapestBestRatedHotel(String bookingFromDate, String leavingDate) {
        LocalDate checkInDate = LocalDate.parse(bookingFromDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        LocalDate checkOutDate = LocalDate.parse(leavingDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        int stayingDays = checkOutDate.getDayOfMonth() - checkInDate.getDayOfMonth() + 1;
        HotelData cheapBestHotel = hotelDataList.stream().filter(n -> n.hotelRating > 3)
                .min(Comparator.comparing(HotelData::getHotelRating))
                .orElse(null);

        HotelData hotelData = new HotelData();
        hotelData.setHotelName(cheapBestHotel.getHotelName());
        hotelData.setTotalPrice(cheapBestHotel.getWeekendRates() * stayingDays);
        System.out.println("Cheap best Hotel is : " + hotelData.getHotelName());
        System.out.println("Total price is : " + stayingDays + hotelData.getTotalPrice());
    }

    public static void findBestRatedHotel(String bookingFromDate, String leavingDate) {
        LocalDate checkInDate = LocalDate.parse(bookingFromDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        LocalDate checkOutDate = LocalDate.parse(leavingDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        int stayingDays = checkOutDate.getDayOfMonth() - checkInDate.getDayOfMonth() + 1;
        HotelData cheapBestHotel = hotelDataList.stream().filter(n -> n.hotelRating > 3)
                .min(Comparator.comparing(HotelData::getHotelRating))
                .orElse(null);

        HotelData hotelData = new HotelData();
        hotelData.setHotelName(cheapBestHotel.getHotelName());
        hotelData.setTotalPrice(cheapBestHotel.getWeekendRates() * stayingDays);
        System.out.println("Best Hotel is : " + hotelData.getHotelName());
        System.out.println("Total price is : " + stayingDays + hotelData.getTotalPrice());
    }
}