package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        CarService carService = new CarServiceImpl();

        Integer limit = null;
        if (count != null) {
            limit = count.intValue();
        }

        List<Car> list = carService.getListCars(limit);
        model.addAttribute("cars", list);
        return "cars";
    }
}
