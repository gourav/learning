package com.learning.cloud.taco.controller;

import com.learning.cloud.taco.domain.Ingredient;
import com.learning.cloud.taco.repository.impl.jpa.SmartIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final SmartIngredientRepository ingredients;

    @Autowired
    public IngredientByIdConverter(SmartIngredientRepository ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredients.findById(id).get();
    }
}
