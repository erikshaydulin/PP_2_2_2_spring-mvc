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
        List<Car> list = new ArrayList<>();
        list.add(new Car("Vaz", 2112, "1.5L - 91 horse power"));
        list.add(new Car("Toyota", 4, "v6"));
        list.add(new Car("Ford", 2, "2.0L - 129 horse power"));
        list.add(new Car("Nissan", 2007, "v8"));
        list.add(new Car("Vaz", 2114, "1.5L - 91 horse power"));
        CarService carService = new CarServiceImpl();
        List<Car> list2 = null;
        if (count != null) {
            list2 = carService.getListCars(count.intValue(), list);
        } else {
            list2 = carService.getListCars(list.size(), list);
        }
//        List<Car> list2 = carService.getListCars(count, list);
        model.addAttribute("cars", list2);
        return "cars";
    }
}
