package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.*;

@Component
public class CarDao {
    List<Car> cars = new ArrayList<>();
    {
        cars.add(new Car("Blue", "V8", 2));
        cars.add(new Car("Black", "V6", 4));
        cars.add(new Car("White", "V6", 2));
        cars.add(new Car("rusty", "None", 0));
        cars.add(new Car("Purple", "V10", 2));
    }

    public List<Car> getCars() {
        return cars;
    }
}
