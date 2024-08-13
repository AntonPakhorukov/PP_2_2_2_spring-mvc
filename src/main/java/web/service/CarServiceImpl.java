package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>(List.of(
            new Car("BMW", "X5", "Black"),
            new Car("Range Rover", "Sport", "Red"),
            new Car("Jeep", "Grand Cherokee", "Black"),
            new Car("Lexus", "RX350", "White"),
            new Car("Audi", "Q7", "Blue")));
    @Override
    public List<Car> getCars(int value) {
        if (value < 0) {
            return null;
        } else if (value > 4) {
            return cars;
        }
        return new ArrayList<>(cars.subList(0, value));
    }
}
