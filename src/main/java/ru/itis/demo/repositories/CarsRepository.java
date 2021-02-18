package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Car;

public interface CarsRepository extends JpaRepository<Car, Long> {
}
