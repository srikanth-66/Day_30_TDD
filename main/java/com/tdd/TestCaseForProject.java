package com.tdd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestCaseForProject {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateFare() {
		new InvoiceGenerator();
		InvoiceGenerator generator = new InvoiceGenerator();
		double distance = 10;
		int time = 60;
		double getFare = InvoiceGenerator.calculateFare(distance, time);
		assertEquals(160, getFare);
	}

	@Test
	void testAgainCalculateFare() {
		InvoiceGenerator generator = new InvoiceGenerator();
		double getFare = InvoiceGenerator.calculateFare(0, 2);
		assertEquals(5, getFare);
	}

	@Test
	void totalFareForMultipleRides() {
		InvoiceGenerator generator = new InvoiceGenerator();
		Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };

		double totalFare = generator.calculateFare(rides);
		assertEquals(1532, totalFare);
	}

	@Test
	void EnhancedInvoice() {
		InvoiceGenerator generator = new InvoiceGenerator();
		Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };

		InvoiceSummery invoiceSummery = generator.generateInvoiceForMultipleRides(rides);
		assertEquals(1532, invoiceSummery.totalFare);
		assertEquals(3, invoiceSummery.noOFRides);
		assertEquals(510, (int) invoiceSummery.averageFarePerRide);
	}

	@Test
	void InvoiceService() {
		InvoiceGenerator generator=new InvoiceGenerator();
		Map<Integer,InvoiceSummery> map= new HashMap<Integer, InvoiceSummery>();

		Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };
		InvoiceSummery invoiceSummery = generator.generateInvoiceForMultipleRides(rides);
		map.put(1, invoiceSummery);

		InvoiceSummery invoiceSummery1 = generator.generateInvoiceForMultipleRides(rides);
		map.put(1, invoiceSummery1);

		InvoiceSummery invoiceSummery2 = generator.generateInvoiceForMultipleRides(rides);
		map.put(1, invoiceSummery2);
		InvoiceSummery invoiceSummery3=map.get(1);
		assertEquals(4596, invoiceSummery3.totalFare);
		assertEquals(3, invoiceSummery3.noOFRides);
		assertEquals(1532, (int)invoiceSummery3.averageFarePerRide);
	}

	@Test
	void calculateFareForRides() {
		InvoiceGenerator generator = new InvoiceGenerator();
		double distance = 10;
		int time = 60;
		double getFareForNormalRide = InvoiceGenerator.calculateFare(distance, time, "normal");
		assertEquals(160, getFareForNormalRide);
		double getFareForPremiumRide= InvoiceGenerator.calculateFare(distance, time, "premium");
		assertEquals(270, getFareForPremiumRide);
	}

}