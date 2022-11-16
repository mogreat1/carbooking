package booking;

import car.Car;
import car.CarService;
import user.User;
import user.UserService;

import java.util.Arrays;
import java.util.UUID;

import static Utils.CustomerInputUtil.takeCustomerInput;

public class BookingService {

    private BookingServiceDao bookingServiceDao;

    {
        bookingServiceDao = new BookingServiceDao();
    }

    public void bookCar() {
        String customerId = takeCustomerId();
        Car[] cars = doYouWantElectricalCar();
        Car car = takeCarBrand(cars);

        Booking booking = new Booking();
        booking.setCar(car);
        booking.setId(UUID.fromString(customerId));

        bookingServiceDao.addBooking(booking);
    }

    private String takeCustomerId() {
        System.out.println("Please provide your ID");
        String customerID = takeCustomerInput();

        UserService userService = new UserService();
        User[] users = userService.viewAllUsers();

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

    private Car[] doYouWantElectricalCar() {
        System.out.println("Do you want to get an electrical car?");
        String isElectrical = takeCustomerInput();

        CarService carService = new CarService();

        if (isElectrical.equals("true")) {
            return carService.viewAvailableElectricCars();
        } else if (isElectrical.equals("false")) {
            return carService.viewAvailableCars();
        } else {
            System.out.println("Please provide correct answer true or false");
            doYouWantElectricalCar();
            return null;
        }
    }

    private Car takeCarBrand(Car[] cars) {
        System.out.println("Please specify what brand you want to book");
        String carBrand = takeCustomerInput();
        for (Car car : cars) {
            if (car.getBrand().toString().equals(carBrand)) {
                return car;
            }
        }
        return null;
    }

    public void viewAllBookings() {
        Booking [] bookings =bookingServiceDao.viewAllBookings();
        Arrays.stream(bookings)
                .forEach(System.out::println);
    }

    public void viewUserBookings() {
        System.out.println("Please provide your ID");
        Booking [] bookings =bookingServiceDao.viewUserBookings(takeCustomerInput());
        Arrays.stream(bookings)
                .forEach(System.out::println);
    }
}
