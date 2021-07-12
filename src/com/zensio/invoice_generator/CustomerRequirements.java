package com.zensio.invoice_generator;

public class CustomerRequirements {
    private int openSeats;
    private int cabinSeats;
    private int confRoomHrs;
    private int meals;

    public CustomerRequirements(int openSeats, int cabinSeats, int confRoomHrs, int meals) {
        this.openSeats = openSeats;
        this.cabinSeats = cabinSeats;
        this.confRoomHrs = confRoomHrs;
        this.meals = meals;
    }
    public int getOpenSeats() {
        return openSeats;
    }

    public void setOpenSeats(int openSeats) {
        this.openSeats = openSeats;
    }

    public int getCabinSeats() {
        return cabinSeats;
    }

    public void setCabinSeats(int cabinSeats) {
        this.cabinSeats = cabinSeats;
    }

    public int getConfRoomHrs() {
        return confRoomHrs;
    }

    public void setConfRoomHrs(int confRoomHrs) {
        this.confRoomHrs = confRoomHrs;
    }

    public int getMeals() {
        return meals;
    }

    private void setMeals(int meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "CustomerRequirements{" +
                "openSeats=" + openSeats +
                ", cabinSeats=" + cabinSeats +
                ", confRoomHrs=" + confRoomHrs +
                ", meals=" + meals +
                '}';
    }

}
