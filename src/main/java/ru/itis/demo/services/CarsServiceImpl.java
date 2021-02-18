package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.CarDto;
import ru.itis.demo.models.Car;
import ru.itis.demo.repositories.CarsRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.demo.dto.CarDto.from;

@Component
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<CarDto> getAllCars() {
        return from(carsRepository.findAll());
    }

    @Override
    public Optional<CarDto> findById(Long id) {
        Optional<Car> car = carsRepository.findById(id);

        return Optional.ofNullable(CarDto.from(car.orElse(Car.builder().build())));
    }

    @Override
    public Long findByMark(String mark) {
        return  null;
    }

    @Override
    public void save(Car car) {
        carsRepository.save(car);
    }
}
