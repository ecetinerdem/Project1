package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAll();
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);
    Fruit findById(Long id);
    Fruit save(Fruit fruit);
    Fruit update(Long id, Fruit fruit);
    Fruit delete(Long id);

}
