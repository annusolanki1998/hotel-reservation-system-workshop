package com.bridgelabz;

public class HotelData {
    String hotelName;
    int hotelRates;

    int totalPrice;

    public HotelData() {
    }

    public HotelData(String hotelName, int hotelRates) {
        this.hotelName = hotelName;
        this.hotelRates = hotelRates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRates() {
        return hotelRates;
    }

    public void setHotelRates(int hotelRates) {
        this.hotelRates = hotelRates;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "HotelData{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelRates=" + hotelRates +
                ", totalPrice=" + totalPrice +
                '}';
    }
}