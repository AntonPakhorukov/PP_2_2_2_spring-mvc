package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCars(List<Car> cars, int value) {
        if (value < 0) {
            return null;
        } else if (value > 4) {
            return cars;
        }
        return new ArrayList<>(cars.subList(0, value));
    }
}
