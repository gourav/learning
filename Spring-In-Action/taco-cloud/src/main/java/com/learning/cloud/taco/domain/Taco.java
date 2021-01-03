package com.learning.cloud.taco.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @NotNull
    @Size( min = 5, message = "Name must be at least 5 characters long." )
    private String name;

    @NotNull
    @Size( min = 1, message = "You must choose at least 1 ingredient." )
    @ManyToMany( targetEntity = Ingredient.class )
    private List<Ingredient> ingredients;

    private Date createdAt;

    @PrePersist
    public void setCreatedAtDateToNow() {
        this.createdAt = new Date();
    }

}
