package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation");

        List<HotelData> hotelDataList = new ArrayList<>();
        HotelData lakeWood = new HotelData("LakeWood", 110);
        HotelData bridgeWood = new HotelData("BridgeWood", 150);
        HotelData ridgeWood = new HotelData("RidgeWood", 220);
        hotelDataList.add(lakeWood);
        hotelDataList.add(bridgeWood);
        hotelDataList.add(ridgeWood);
        hotelDataList.forEach(System.out::println);

    }
}
