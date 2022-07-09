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

    private final CarServiceImpl cs;
    private final CarDao cd;

    @Autowired
    public CarController(CarServiceImpl cs, CarDao cd) {
        this.cs = cs;
        this.cd = cd;
    }

    @GetMapping("/cars")
    public String carsCount(@RequestParam(value = "count", defaultValue = "5") int count, Model cars) {
        cars.addAttribute("cars", cs.carCount(cd.getCars(), count));
        return "first/cars";
    }
}
