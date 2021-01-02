package com.learning.cloud.taco.controller;

import com.learning.cloud.taco.domain.Ingredient;
import com.learning.cloud.taco.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private final IngredientRepository ingredients;

  @Autowired
  public IngredientByIdConverter( IngredientRepository ingredients ) {
    this.ingredients = ingredients;
  }

  @Override
  public Ingredient convert(String id) {
    return ingredients.findOne( id );
  }
}