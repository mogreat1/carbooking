package booking;

import car.Car;
import car.CarDao;
import car.CarService;
import user.User;
import user.UserDao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static Utils.CustomerInputUtil.takeCustomerInput;

public class BookingService {

    private static final BookingServiceDao bookingServiceDao;

    static {
        bookingServiceDao = new BookingServiceDao();

    }

    public void bookCar() {
        String customerId = takeCustomerId();

        Car car = chooseCarByRegNumber();

        CarDao.takeCar(car.getRegNumber());

        Booking booking = new Booking();
        booking.setId(UUID.randomUUID());
        booking.setLocalDateTime(LocalDateTime.now());
        booking.setCar(car);
        booking.setUser(UserDao.getUser(customerId));



        bookingServiceDao.addBooking(booking);
    }

    public void viewAllBookings() {
        Booking[] bookings = bookingServiceDao.viewAllBookings();

        List<Booking> filteredBookings = Arrays.stream(bookings)
                .filter(Objects::nonNull)
                .toList();

        printBookings(filteredBookings);
    }

    public void viewUserBookings() {
        Booking[] bookings = bookingServiceDao.viewAllBookings();

        String customerId = takeCustomerId();

        List<Booking> filteredBookings = Arrays.stream(bookings)
                .filter(Objects::nonNull)
                .filter(booking -> booking.getUser().getId().toString().equals(customerId))
                .toList();

        printBookings(filteredBookings);
    }

    private String takeCustomerId() {
        System.out.println("Please provide your ID");
        String customerID = takeCustomerInput();

        UserDao userDao = new UserDao();
        User[] users = userDao.getUsers();

        String customer = null;

        for (User user : users) {
            if (user.getId().toString().equals(customerID)) {
                customer = user.getId().toString();
                break;
            }
        }

        if (customer == null) {
            takeCustomerId();
        }
        return customer;
    }

    private Car chooseCarByRegNumber() {
        CarService carService = new CarService();
        Car[] cars = carService.viewAvailableCars();
        System.out.println("Please specify registration number");

        String regNumber = takeCustomerInput();
        for (Car car : cars) {
            if (car.getRegNumber() == Integer.parseInt(regNumber)) {
                return car;
            }
        }
        return null;
    }

    private static void printBookings(List<Booking> filteredBookings) {
        if (filteredBookings.size() == 0) {
            System.out.println("There is no bookings");
        } else {
            filteredBookings
                    .forEach(System.out::println);
        }
    }
}
