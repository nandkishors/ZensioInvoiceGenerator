package com.zensio.invoice_generator;

import java.util.Scanner;

public class InvoiceGeneration {

    private static final double CONFERENCE_GST_FACTOR = 0.18;
    private static final double MEAL_GST_FACTOR = 0.12;
    private static final int CONF_USAGE_HRS_OPENING_SEATS = 5;
    private static final int CONF_USAGE_HRS_CABIN_SEATS = 10;

    private static final double OPEN_SEAT_COST = 5000.0;
    private static final double CABIN_SEAT_COST = 10000.0;
    private static final double CONF_ROOM_EXTRA_COST = 200.0;
    private static final double MEALS_COST = 100.0;

    public static void main(String[] args) {
        InvoiceGeneration invoiceGeneration = new InvoiceGeneration();
        final CustomerRequirements customerRequirements = invoiceGeneration.getCustomerRequirements();
        generateInvoice(customerRequirements);
    }

    private static void generateInvoice(CustomerRequirements requirements) {
        final double openSeatsCost = requirements.getOpenSeats() * OPEN_SEAT_COST;
        final double openSeatsGst = openSeatsCost * CONFERENCE_GST_FACTOR;
        final double cabinSeatsCost = requirements.getCabinSeats() * CABIN_SEAT_COST;
        final double cabinSeatsGst = cabinSeatsCost * CONFERENCE_GST_FACTOR;
        final int totalFreeHrs = (requirements.getOpenSeats() * CONF_USAGE_HRS_OPENING_SEATS) +
                (requirements.getCabinSeats() * CONF_USAGE_HRS_CABIN_SEATS);
        final double confRoomCost = totalFreeHrs >= requirements.getConfRoomHrs() ? 0.0 :
                (requirements.getConfRoomHrs() - totalFreeHrs) * CONF_ROOM_EXTRA_COST;
        final double confRoomHrsGst = confRoomCost * CONFERENCE_GST_FACTOR;
        final double mealsCost = requirements.getMeals() * MEALS_COST;
        final double mealsGst = mealsCost * MEAL_GST_FACTOR;
        final CustomerInvoice customerInvoice = new CustomerInvoice(openSeatsCost + openSeatsGst,
                cabinSeatsCost + cabinSeatsGst, confRoomCost + confRoomHrsGst,
                mealsCost + mealsGst, openSeatsGst + cabinSeatsGst + confRoomHrsGst + mealsGst);
        printCustomerInvoice(customerInvoice, requirements);
    }

    private static void printCustomerInvoice(CustomerInvoice customerInvoice, CustomerRequirements requirements) {
        System.out.println("\n++++++++++++++++++ Customer invoice ++++++++++++++++++");
        System.out.println(requirements.getOpenSeats() + " Open seats: " + customerInvoice.getOpenSeats());
        System.out.println(requirements.getCabinSeats() + " Cabin seats: " + customerInvoice.getCabinSeats());
        System.out.println(requirements.getConfRoomHrs() + " hours of Conferenceroom usage: " + customerInvoice.getConfRoomUsage());
        System.out.println(requirements.getMeals() + " Meals: " + customerInvoice.getMeals());
        System.out.println("Total: " + customerInvoice.getTotal());
        System.out.println("Total GST: " + customerInvoice.getTotalGst());
        System.out.println("\n++++++++++++++++++ Customer invoice ++++++++++++++++++");
    }

    private CustomerRequirements getCustomerRequirements() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Open seats: ");
        final int openSeats = Integer.parseInt(scanner.nextLine());
        System.out.print("Cabin seats: ");
        final int cabinSeats = Integer.parseInt(scanner.nextLine());
        System.out.print("Conference Room usage (In hours): ");
        final int confRoomUsage = Integer.parseInt(scanner.nextLine());
        System.out.print("Meals needed: ");
        final int meals = Integer.parseInt(scanner.nextLine());
        return new CustomerRequirements(openSeats, cabinSeats, confRoomUsage, meals);
    }
}
