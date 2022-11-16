package carcompany;


import booking.BookingService;
import car.CarService;
import user.UserService;

import static Utils.CustomerInputUtil.takeCustomerInput;

public class CarCompanyService {

    {
        System.out.println("Hello, please choose what you want");
    }

    public void showStartMenu() {
        System.out.println("" +
                "1️⃣ - Book Car\n" +
                "2️⃣ - View All User Booked Cars\n" +
                "3️⃣ - View All Bookings\n" +
                "4️⃣ - View Available Cars\n" +
                "5️⃣ - View Available Electric Cars\n" +
                "6️⃣ - View all users\n" +
                "7️⃣ - Exit");

        String input = takeCustomerInput();
        makeChoice(input);
    }

    private void makeChoice(String choice) {
        BookingService bookingService = new BookingService();
        CarService carService = new CarService();
        UserService userService = new UserService();


        switch (choice) {
            case "1" -> {
                bookingService.bookCar();
                showStartMenu();
            }
            case "2" -> {
                bookingService.viewUserBookings();
                showStartMenu();
            }
            case "3" -> {
                bookingService.viewAllBookings();
                showStartMenu();
            }
            case "4" -> {
                carService.viewAvailableCars();
                showStartMenu();
            }
            case "5" -> {
                carService.viewAvailableElectricCars();
                showStartMenu();
            }
            case "6" -> {
                userService.viewAllUsers();
                showStartMenu();
            }
            case "7" -> stopSystem();//+
            default -> {
                System.out.println("Please provide correct value from 1 to 7");
                showStartMenu();
            }
        }
    }

    private void stopSystem() {

    }
}
