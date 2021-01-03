package com.learning.cloud.taco.repository.impl.jpa;

import com.learning.cloud.taco.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface SmartIngredientRepository extends CrudRepository<Ingredient, String> {
}
