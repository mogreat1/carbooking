package car;


public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car(1234, Brand.BMW, 100, true, true),
                new Car(2345, Brand.FORD, 500, false, false),
                new Car(3456, Brand.MERCEDES, 123, false, false),
                new Car(4567, Brand.TOYOTA, 321, true, false),
                new Car(5678, Brand.BMW, 444, true, false),
        };
    }

    public Car[] getCars() {
        return cars;
    }

    public static void takeCar(int regNumber) {
        for (Car car : cars) {
            if (car.getRegNumber() == regNumber) {
                if (car.isTaken()) {
                    System.out.println("This car is already taken");
                    break;
                }
                car.setTaken(true);
                break;
            }
        }
    }
}
