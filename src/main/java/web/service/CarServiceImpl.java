package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getListCars(Integer count) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Vaz", 2112, "1.5L - 91 horse power"));
        list.add(new Car("Toyota", 4, "v6"));
        list.add(new Car("Ford", 2, "2.0L - 129 horse power"));
        list.add(new Car("Nissan", 2007, "v8"));
        list.add(new Car("Vaz", 2114, "1.5L - 91 horse power"));

        List<Car> result;
        if (count != null) {
            result = list.stream().limit(count.intValue()).collect(Collectors.toList());
        } else {
            result = list;
        }
        return result;
    }
}
