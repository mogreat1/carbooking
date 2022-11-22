package car;

import java.util.Arrays;

public class CarService {

    private final CarDao carDao;

    {
        carDao = new CarDao();
    }

    public Car[] viewAvailableCars() {
        System.out.println("Here is all available cars");

        Car[] cars = carDao.getCars();

        Arrays.stream(cars)
                .filter(car -> !car.isTaken())
                .forEach(System.out::println);

        return carDao.getCars();
    }

    public Car[] viewAvailableElectricCars() {
        System.out.println("Here is all available electric cars:");
        Car[] cars = carDao.getCars();
        Car[] electricalCars = new Car[cars.length];

        Arrays.stream(cars)
                .filter(Car::isElectrical)
                .filter(car -> !car.isTaken())
                .forEach(System.out::println);

        return electricalCars;
    }
}
