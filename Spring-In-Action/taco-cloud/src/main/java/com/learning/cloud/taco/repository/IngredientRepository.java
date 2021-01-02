package com.learning.cloud.taco.repository;

import com.learning.cloud.taco.domain.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findOne( String id );
    Ingredient save( Ingredient ingredient );

}
