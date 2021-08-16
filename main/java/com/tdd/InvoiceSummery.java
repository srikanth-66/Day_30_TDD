package com.tdd;

public class InvoiceSummery {
	public double totalFare;
	public int noOFRides;
	public double averageFarePerRide;

	public InvoiceSummery(double totalFare, int noOFRides, double averageFarePerRide) {
		this.totalFare=totalFare;
		this.noOFRides=noOFRides;
		this.averageFarePerRide=averageFarePerRide;
	}
}