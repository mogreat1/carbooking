package car;

import java.util.Arrays;

public class CarService {

    private CarDao carDao;

    {
        carDao = new CarDao();
    }

    public Car[] viewAvailableCars() {
        System.out.println("Here is all available cars");

        Car[] cars = carDao.getCars();

        Arrays.stream(cars)
                .forEach(System.out::println);

        return carDao.getCars();
    }

    public Car[] viewAvailableElectricCars() {
        System.out.println("Here is all available electric cars:");
        Car[] cars = carDao.getCars();
        Car[] electricalCars = new Car[cars.length];

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].isElectrical()) {
                electricalCars[i] = cars[i];
            }
        }

        Arrays.stream(electricalCars)
                .forEach(System.out::println);

        return electricalCars;
    }
}
