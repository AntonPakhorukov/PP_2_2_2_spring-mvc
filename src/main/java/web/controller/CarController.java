package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", required = false) String count, Model model) {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("BMW", "X5", "Black"),
                new Car("Range Rover", "Sport", "Red"),
                new Car("Jeep", "Grand Cherokee", "Black"),
                new Car("Lexus", "RX350", "White"),
                new Car("Audi", "Q7", "Blue")));
        if (count != null && count.matches("\\d+")) {
            model.addAttribute("cars", carService.getCars(cars, Integer.parseInt(count)));
        }
        return "cars";
    }
}
