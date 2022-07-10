package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private final CarServiceImpl carService;
    private final CarDao carDao;

    @Autowired
    public CarController(CarServiceImpl carService, CarDao carDao) {
        this.carService = carService;
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String carsCount(@RequestParam(value = "count", defaultValue = "5") int count, Model cars) {
        cars.addAttribute("cars", carService.carCount(carDao.getCars(), count));
        return "first/cars";
    }
}
