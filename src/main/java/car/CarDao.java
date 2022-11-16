package car;

public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car(Brand.BMW, 100, true),
                new Car(Brand.FORD, 500, false),
                new Car(Brand.MERCEDES, 123, false),
                new Car(Brand.TOYOTA, 321, true),
                new Car(Brand.BMW, 444, true),
        };
    }

    public Car[] getCars() {
        return cars;
    }
}
