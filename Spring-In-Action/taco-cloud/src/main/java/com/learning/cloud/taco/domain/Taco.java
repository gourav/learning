package com.learning.cloud.taco.domain;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private final String name;
    private final List<Ingredient> ingredients;

}
