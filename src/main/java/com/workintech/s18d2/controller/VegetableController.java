package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.util.Converter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
@AllArgsConstructor
public class VegetableController {
    private final VegetableService vegetableService;

    @GetMapping
    public List<VegetableResponse> findAll() {
        return Converter.convertVegetableResponse(vegetableService.findAll());
    }
    @GetMapping("/desc")
    public List<VegetableResponse> findByPriceDesc() {
        return Converter.convertVegetableResponse(vegetableService.getByPriceDesc());
    }

    @GetMapping("/asc")
    public List<VegetableResponse> findByPriceAsc() {
        return Converter.convertVegetableResponse(vegetableService.getByPriceAsc());
    }

    @GetMapping("/{id}")
    public VegetableResponse findById(@PathVariable("id") Long id) {
        return Converter.convertVegetableResponse(vegetableService.findById(id));
    }

    @GetMapping("/name/{name}")
    public List<VegetableResponse> searchByName(@Size(min = 2, max = 45, message = "Name length must be between 2 and 45") @PathVariable("name") String name) {
        return Converter.convertVegetableResponse(vegetableService.searchByName(name));
    }

    @PostMapping
    public VegetableResponse save (@Validated @RequestBody Vegetable vegetable) {
        return Converter.convertVegetableResponse(vegetableService.save(vegetable));
    }

    @PutMapping("/{id}")
    public VegetableResponse update(@Validated @PathVariable("id") Long id, @RequestBody Vegetable vegetable) {
        return Converter.convertVegetableResponse(vegetableService.update(id,vegetable));
    }

    @DeleteMapping("/{id}")
    public VegetableResponse delete(@NotNull @Positive @PathVariable("id") Long id) {
        return Converter.convertVegetableResponse(vegetableService.delete(id));
    }
}
