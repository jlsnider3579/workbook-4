package com.pluralsight.hotel;

import java.util.Scanner;

public class Reservation {
    String getRoomType;
    String setRoomType;
    double getPrice;
    int getNumberOfNights;
    int setNumberOfNights;
    boolean isWeekend;
    double ReservationTotal;
    Scanner scanner = new Scanner(System.in);

    public Reservation(String getRoomType, String setRoomType, double getPrice, int getNumberOfNights, int setNumberOfNights, boolean isWeekend, double reservationTotal) {
        this.getRoomType = getRoomType;
        this.setRoomType = setRoomType;
        this.getPrice = getPrice;
        this.getNumberOfNights = getNumberOfNights;
        this.setNumberOfNights = setNumberOfNights;
        this.isWeekend = isWeekend;
        ReservationTotal = reservationTotal;
    }

    public String getGetRoomType() {
        return getRoomType;
    }

    public void setGetRoomType(String getRoomType) {
        this.getRoomType = getRoomType;
    }

    public String getSetRoomType() {
        return setRoomType;
    }

    public void setSetRoomType(String setRoomType) {
        this.setRoomType = setRoomType;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(double getPrice) {
        this.getPrice = getPrice;
    }

    public int getGetNumberOfNights() {
        return getNumberOfNights;
    }

    public void setGetNumberOfNights(int getNumberOfNights) {
        this.getNumberOfNights = getNumberOfNights;
    }

    public int getSetNumberOfNights() {
        return setNumberOfNights;
    }

    public void setSetNumberOfNights(int setNumberOfNights) {
        this.setNumberOfNights = setNumberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        return ReservationTotal;
    }

    public void setReservationTotal(double reservationTotal) {
        ReservationTotal = reservationTotal;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "getRoomType='" + getRoomType + '\'' +
                ", setRoomType='" + setRoomType + '\'' +
                ", getPrice=" + getPrice +
                ", getNumberOfNights=" + getNumberOfNights +
                ", setNumberOfNights=" + setNumberOfNights +
                ", isWeekend=" + isWeekend +
                ", ReservationTotal=" + ReservationTotal +
                '}';
    }
}