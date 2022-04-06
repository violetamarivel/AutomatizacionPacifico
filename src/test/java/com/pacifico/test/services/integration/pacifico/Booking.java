package com.pacifico.test.services.integration.pacifico;

public class Booking{
	private Booking booking;
	private int bookingid;
	private String firstname;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;
	private String lastname;

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	public void setBookingdates(Bookingdates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Booking getBooking(){
		return booking;
	}

	public int getBookingid(){
		return bookingid;
	}

	public String getFirstname(){
		return firstname;
	}

	public String getAdditionalneeds(){
		return additionalneeds;
	}

	public Bookingdates getBookingdates(){
		return bookingdates;
	}

	public int getTotalprice(){
		return totalprice;
	}

	public boolean isDepositpaid(){
		return depositpaid;
	}

	public String getLastname(){
		return lastname;
	}
}
