package com.learning.cloud.taco.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Ingredient {

    @Id
    private String id;
    private String name;

    private Type type;

    public Ingredient() {

    }

    public Ingredient( String id, String name, Type type ) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
