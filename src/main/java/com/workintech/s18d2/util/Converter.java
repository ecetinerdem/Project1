package com.workintech.s18d2.util;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<FruitResponse> convertFruitResponse(List<Fruit> fruits) {
        List<FruitResponse> fruitResponses = new ArrayList<>();
        for(Fruit fruit: fruits) {
            fruitResponses.add(new FruitResponse("Fruits are successfully brought ", fruit));
        }
        return fruitResponses;
    }

    public static FruitResponse convertFruitResponse(Fruit fruit) {
        return new FruitResponse("Fruits are successfully brought ", fruit);
    }

    public static List<VegetableResponse> convertVegetableResponse(List<Vegetable> vegetables) {
        List<VegetableResponse> vegetableResponses = new ArrayList<>();
        for(Vegetable vegetable: vegetables) {
            vegetableResponses.add(new VegetableResponse("Fruits are successfully brought ", vegetable));
        }
        return vegetableResponses;
    }
    public static VegetableResponse convertVegetableResponse(Vegetable vegetable) {
        return new VegetableResponse("Fruits are successfully brought ", vegetable);
    }
}
