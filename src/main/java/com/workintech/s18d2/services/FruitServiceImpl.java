package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FruitServiceImpl implements FruitService{
    private final FruitRepository fruitRepository;

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll() ;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit findById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new PlantException("Plant with given id, does not exist " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit update(Long id, Fruit fruit) {
        fruitRepository.findById(id).orElseThrow(() -> new PlantException("Plant with given id, does not exist " + id, HttpStatus.NOT_FOUND));
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit foundFruit = fruitRepository.findById(id).orElseThrow(() -> new PlantException("Plant with given id, does not exist " + id, HttpStatus.NOT_FOUND));
        fruitRepository.delete(foundFruit);
        return foundFruit;
    }
}
