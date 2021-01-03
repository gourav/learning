package com.learning.cloud.taco.domain.converters;

import com.learning.cloud.taco.domain.Ingredient;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter( autoApply = true )
public class IngredientTypeConverter implements AttributeConverter<Ingredient.Type, String> {
    @Override
    public String convertToDatabaseColumn(Ingredient.Type attribute) {
        if( attribute == null ) {
            return null;
        }

        return attribute.toString();
    }

    @Override
    public Ingredient.Type convertToEntityAttribute(String dbData) {

        if( dbData == null ) {
            return null;
        }

        return Stream.of( Ingredient.Type.values() )
                .filter( type -> type.toString().equals( dbData ))
                .findFirst()
                .orElseThrow( IllegalAccessError::new );

    }
}
