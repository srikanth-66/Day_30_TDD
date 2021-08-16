package com.tdd;

public class InvoiceGenerator {

	private double totalRidesFare = 0;

	public static double calculateFare(double distance, int time) {
		double fare = 10 * distance + 1 * time;
		if (fare < 5) {
			return 5;
		} else {
			return fare;
		}
	}

	public double calculateFare(Ride[] rides) {
		for (Ride ride : rides) {
			totalRidesFare += calculateFare(ride.distance, ride.time);
		}
		return totalRidesFare;
	}

	public InvoiceSummery generateInvoiceForMultipleRides(Ride[] rides) {
		for (Ride ride : rides) {
			totalRidesFare += calculateFare(ride.distance, ride.time);
		}
		InvoiceSummery summery = new InvoiceSummery(totalRidesFare, rides.length, (totalRidesFare / rides.length));

		return summery;
	}



	public static double calculateFare(double distance, int time, String string) {
		if (string == "normal") {
			double fare = 10 * distance + 1 * time;
			if (fare < 5) {
				return 5;
			} else {
				return fare;
			}
		} else {
			double fare = 15 * distance + 2 * time;
			if (fare < 20) {
				return 20;
			} else {
				return fare;
			}

		}

	}

}
