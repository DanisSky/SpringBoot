package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Car;
import ru.itis.demo.models.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private Long id;
    private String mark;
    private String model;
    private Double price;
    private String description;
    private Long mileage;
    private Long fileId;
    private List<CommentDto> commentDtos;

    public static CarDto from(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .mark(car.getMark())
                .model(car.getModel())
                .price(car.getPrice())
                .description(car.getDescription())
                .mileage(car.getMileage())
                .fileId(car.getFileId())
                .build();
    }

    public static List<CarDto> from(List<Car> cars) {
        return cars.stream().map(CarDto::from).collect(Collectors.toList());
    }
}
