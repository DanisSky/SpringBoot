package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.CarDto;
import ru.itis.demo.dto.CommentDto;
import ru.itis.demo.services.CarsService;
import ru.itis.demo.services.CommentsService;

import java.util.List;
import java.util.Optional;

@Controller
public class CarInfoController {

    @Autowired
    private CarsService carsService;

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/carInfo/{car-id}")
    @ResponseBody
    public ResponseEntity<Optional<CarDto>> getCarById(@PathVariable("car-id") Long carId) {
        Optional<CarDto> carDto = carsService.findById(carId);

        if (carDto.isPresent()) {
            List<CommentDto> comments = commentsService.getAllCommentsByCarId(carDto.get().getId());
            carDto.get().setCommentDtos(comments);
            return ResponseEntity.ok(carDto);
        }

        return null;
    }

    @PostMapping("/carInfo")
    @ResponseBody
    public ResponseEntity<List<CommentDto>> addComment (@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentsService.getAllCommentsByCarId(commentDto.getId()));

    }
}
