package com.zensio.invoice_generator;

public class CustomerInvoice {
    private static final double CONFERENCE_GST_FACTOR = 0.18;
    private static final double MEAL_GST_FACTOR = 0.12;

    private double openSeats;
    private double cabinSeats;
    private double confRoomUsage;
    private double meals;
    private double total;
    private double totalGst;

    public CustomerInvoice(double openSeats, double cabinSeats, double confRoomUsage, double meals, double totalGst) {
        this.openSeats = openSeats;
        this.cabinSeats = cabinSeats;
        this.confRoomUsage = confRoomUsage;
        this.meals = meals;
        this.total = openSeats + cabinSeats + confRoomUsage + meals;
        this.totalGst = totalGst;
    }

    public double getOpenSeats() {
        return openSeats;
    }

    public void setOpenSeats(double openSeats) {
        this.openSeats = openSeats;
    }

    public double getCabinSeats() {
        return cabinSeats;
    }

    public void setCabinSeats(double cabinSeats) {
        this.cabinSeats = cabinSeats;
    }

    public double getConfRoomUsage() {
        return confRoomUsage;
    }

    public void setConfRoomUsage(double confRoomUsage) {
        this.confRoomUsage = confRoomUsage;
    }

    public double getMeals() {
        return meals;
    }

    public void setMeals(double meals) {
        this.meals = meals;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(double totalGst) {
        this.totalGst = totalGst;
    }
}
