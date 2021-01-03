package com.learning.cloud.taco.repository.impl.jdbc;

import com.learning.cloud.taco.domain.Ingredient;
import com.learning.cloud.taco.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate template;

    @Autowired
    public JdbcIngredientRepository( JdbcTemplate template ) {
        this.template = template;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return this.template.query( "select id, name, type from ingredient ",
                this::mapRowToIngredient );
    }

    @Override
    public Ingredient findOne(String id) {
        return this.template.queryForObject( "select id, name, type from ingredient where id = ?",
                this::mapRowToIngredient, id );
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        this.template.update( "insert into ingredient( id, name, type ) values( ?, ?, ? )",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );

        return ingredient;
    }

    private Ingredient mapRowToIngredient( ResultSet resultSet, int rowNumber ) throws SQLException {
        return new Ingredient(
                resultSet.getString( "id" ),
                resultSet.getString( "name" ),
                Ingredient.Type.valueOf( resultSet.getString( "type" ))
        );
    }
}
