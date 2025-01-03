package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
     List<Vegetable> findAll();
     List<Vegetable> getByPriceDesc();
     List<Vegetable> getByPriceAsc();
     List<Vegetable> searchByName(String name);
     Vegetable findById(Long id);
     Vegetable save(Vegetable vegetable);
     Vegetable update(Long id, Vegetable vegetable);
     Vegetable delete(Long id);

}
