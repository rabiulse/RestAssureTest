package rabiul.test.resassure;

public class bookingIds {

	private int bookingid;
	private Booking booking;

	public bookingIds(int bookingid, Booking booking) {

		this.bookingid = bookingid;
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "bookingIds [bookingid=" + bookingid + ", booking=" + booking
				+ "]";
	}

	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public bookingIds() {

	}

}
