package com.foodngo.recipe;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RecipeParserImplTest {



    @Test
    public void parseRecipe() throws Exception {
        String recipe = "300 g mąki pszennej\n" +
                "200 g masła (zimnego)\n" +
                "50 g smalcu (lub masła)\n" +
                "2 łyżeczki proszku do pieczenia\n" +
                "70 g cukru\n" +
                "1 op. cukru wanilinowego\n" +
                "1 jajko\n" +
                "1,5 kg jabłek*\n" +
                "1/2 łyżeczki cynamonu\n" +
                "cukier puder";


        StringRecipe stringRecipe = new StringRecipe(recipe);




        RecipePareser recipePareser = new RecipeParserImpl(stringRecipe, Collections.singletonList(new SimpleIngredientMapper()));

        List<Ingredient> ingredients = recipePareser.parseRecipe(stringRecipe);


        ingredients.forEach(ingredient -> System.out.println(ingredient));




    }

}