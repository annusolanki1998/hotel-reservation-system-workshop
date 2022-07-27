package com.bridgelabz;

public class HotelData {
    String hotelName;
    int hotelRate;

    public HotelData(String hotelName, int hotelRate) {
        this.hotelName = hotelName;
        this.hotelRate = hotelRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelRate=" + hotelRate +
                '}';
    }
}
