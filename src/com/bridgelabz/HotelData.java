package com.bridgelabz;

public class HotelData {
    String hotelName;
    int weekdayRates;
    int weekendRates;
    int totalPrice;

    public HotelData() {
    }

    public HotelData(String hotelName, int weekdayRates, int weekendRates) {
        this.hotelName = hotelName;
        this.weekdayRates = weekdayRates;
        this.weekendRates = weekendRates;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRates() {
        return weekdayRates;
    }

    public void setWeekdayRates(int weekdayRates) {
        this.weekdayRates = weekdayRates;
    }

    public int getWeekendRates() {
        return weekendRates;
    }

    public void setWeekendRates(int weekendRates) {
        this.weekendRates = weekendRates;
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
                ", weekdayRates=" + weekdayRates +
                ", weekendRates=" + weekendRates +
                ", totalPrice=" + totalPrice +
                '}';
    }
}