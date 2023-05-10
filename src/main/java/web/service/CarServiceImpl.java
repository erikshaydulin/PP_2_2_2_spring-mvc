package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getListCars(int count, List<Car> list) {
        List<Car> result = list.stream().limit(count).collect(Collectors.toList());
        return result;
    }
}
