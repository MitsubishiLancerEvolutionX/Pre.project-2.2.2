package com.example.demo.dao;

import com.example.demo.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PropertySource("classpath:my.properties")
@Component
public class CarDao {

    private final List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("Infiniti QX", 70, "синий"));
        carList.add(new Car("Mitsubishi Lancer", 10, "чёрный"));
        carList.add(new Car("Lada Priora", 2, "серый"));
        carList.add(new Car("KIA Rio", 3, "белый"));
        carList.add(new Car("BMW e60", 5, "золотой"));
        carList.add(new Car("Lexus LX", 570, "чёрный"));
        carList.add(new Car("Ford Focus", 3, "белый"));
        carList.add(new Car("Mazda", 3, "красный"));
        carList.add(new Car("Volkswagen Touareg", 2, "серебристый"));
        carList.add(new Car("Ford Mustang", 6, "жёлтый"));
    }

    @Autowired
    private Environment env;

    public List<Car> getCars(int count) {

        int maxCar = Integer.parseInt(env.getProperty("maxCar"));
        if (count > maxCar) {
            return carList;
        }

        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
