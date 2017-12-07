package com.foodngo.recipe;

import java.util.Optional;

public interface IngredientMapper {

    Optional<Ingredient> parseIngredient(String line);

}
