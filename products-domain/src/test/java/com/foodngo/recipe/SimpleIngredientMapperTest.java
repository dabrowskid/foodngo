package com.foodngo.recipe;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpleIngredientMapperTest {



    @Test
    public void parseIngredient() throws Exception {
        SimpleIngredientMapper simpleIngredientMapper = new SimpleIngredientMapper();

        String line = "300 g mąki";
        Optional<Ingredient> ingredient = simpleIngredientMapper.parseIngredient(line);

        assertThat(ingredient.isPresent()).isTrue();
        Ingredient value = ingredient.get();
        assertThat(value.amount()).isEqualTo("300");
        assertThat(value.name()).isEqualTo(line);
        assertThat(value.unit()).isEqualTo(Unit.GRAM);


    }

}