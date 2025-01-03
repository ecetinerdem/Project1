package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VegetableServiceImpl implements VegetableService{

    private final VegetableRepository vegetableRepository;

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable findById(Long id) {
        vegetableRepository.findById(id).orElseThrow(() -> new PlantException("Plant with given id, does not exist " + id, HttpStatus.NOT_FOUND));
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable update(Long id, Vegetable vegetable) {
        vegetableRepository.findById(id).orElseThrow(() -> new PlantException("Plant with given id, does not exist " + id, HttpStatus.NOT_FOUND));
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable foundVegetable = vegetableRepository.findById(id).orElseThrow(() -> new PlantException("Plant with given id, does not exist " + id, HttpStatus.NOT_FOUND));
        vegetableRepository.delete(foundVegetable);
        return foundVegetable;
    }
}
