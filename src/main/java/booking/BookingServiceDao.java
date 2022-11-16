package booking;

import car.Car;

import java.util.UUID;

import static car.Brand.FORD;

public class BookingServiceDao {

    private static Booking[] bookings;

    public BookingServiceDao() {
        bookings = new Booking[2];

        Car car = new Car(FORD, 4055, true);
        bookings[0] = new Booking(car, UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"));
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

    public Booking[] viewUserBookings(String userId) {
        Booking[] userBookings = new Booking[bookings.length];


        for (int i = 0; i < bookings.length; i++) {
            if(bookings[i]==null) {
                continue;
            }
            if (bookings[i].getId().toString().equals(userId)) {
                userBookings[i] = bookings[i];
            }
        }

        return userBookings;
    }
}
