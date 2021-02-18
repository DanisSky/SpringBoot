package ru.itis.demo.services;

import ru.itis.demo.dto.CarDto;
import ru.itis.demo.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarsService {
    List<CarDto> getAllCars();
    Optional<CarDto> findById(Long id);
    Long findByMark(String mark);
    void save(Car car);
}
