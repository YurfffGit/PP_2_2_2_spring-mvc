package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private final CarDao carDao = new CarDao();

    @Override
    public List<Car> carCount(List<Car> cars, int count) {
        cars = carDao.getCars();
        if (count > 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
