package com.foodngo.recipe;

import java.util.Arrays;
import java.util.List;

class StringRecipe implements Recipe {


    private final String recipe;

    public StringRecipe(String recipe) {
        this.recipe = recipe;
    }


    @Override
    public List<String> lines() {
        String[] split = this.recipe.split("\n");
        return Arrays.asList(split);
    }
}
