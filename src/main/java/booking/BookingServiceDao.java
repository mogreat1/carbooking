package booking;


public class BookingServiceDao {

    private static Booking[] bookings;

    public BookingServiceDao() {
        bookings = new Booking[10];
    }

    public void addBooking(Booking booking) {

        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                bookings[i] = booking;
                return;
            }
        }
    }

    public Booking[] viewAllBookings() {
        return bookings;
    }
}
