package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.util.Converter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@AllArgsConstructor
public class FruitController {
    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<FruitResponse> findAll() {
        return Converter.convertFruitResponse(fruitService.findAll());
    }

    @GetMapping("/desc")
    public List<FruitResponse> findByPriceDesc() {
        return Converter.convertFruitResponse(fruitService.getByPriceDesc());
    }
    @GetMapping("/asc")
    public List<FruitResponse> findByPriceAsc() {
        return Converter.convertFruitResponse(fruitService.getByPriceAsc());
    }

    @GetMapping("/{id}")
    public FruitResponse findById(@Positive(message = "Id cannot be less than zero") @PathVariable("id") Long id) {
        return Converter.convertFruitResponse(fruitService.findById(id));
    }

    @GetMapping("/name/{name}")
    public List<FruitResponse> searchByName(@Size(min=2, max=45, message = "Name length must be between 2 and 45") @PathVariable("name") String name) {
        return Converter.convertFruitResponse(fruitService.searchByName(name));
    }

    @PostMapping
    public FruitResponse save(@Validated @RequestBody Fruit fruit) {
        return Converter.convertFruitResponse(fruitService.save(fruit));
    }

    @PutMapping("/{id}")
    public FruitResponse update (@Validated @PathVariable("id") Long id, @RequestBody Fruit fruit) {
        return Converter.convertFruitResponse(fruitService.update(id,fruit));
    }

    @DeleteMapping("/{id}")
    public FruitResponse delete(@NotNull @Positive @PathVariable("id") Long id) {
        return Converter.convertFruitResponse(fruitService.delete(id));
    }
}
