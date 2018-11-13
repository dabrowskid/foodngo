package com.foodngo.recipe;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface IngredientMapper {

    Optional<Ingredient> parseIngredient(String line);

    default List<Ingredient> parse() {
        return Collections.emptyList();
    }

}
