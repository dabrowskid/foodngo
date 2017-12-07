package com.foodngo.recipe;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecipeParserImpl implements RecipePareser {


    private final Recipe recipe;
    private final List<IngredientMapper> mappers;

    public RecipeParserImpl(Recipe recipe, List<IngredientMapper> mappers) {
        if (recipe == null || mappers == null || mappers.isEmpty())
            throw new IllegalArgumentException();


        this.recipe = recipe;
        this.mappers = mappers;
    }

    @Override
    public List<Ingredient> parseRecipe(Recipe recipe) {
        return recipe
                .lines()
                .stream()
                .map(mapStringToIngredient())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());


    }


    private Function<String, Optional<Ingredient>> mapStringToIngredient() {
        return string -> mappers
                .stream()
                .map(mapper -> mapper.parseIngredient(string))
                .flatMap(Optional::stream)
                .findFirst();
    }
}
