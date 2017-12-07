package com.foodngo.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimpleIngredientMapper implements IngredientMapper {


    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+[\\/\\d. ]*|\\d)");


    private List<Unit> units = Arrays.stream(Unit.values())
            .collect(Collectors.toList());

    @Override
    public Optional<Ingredient> parseIngredient(String line) {

        Optional<Ingredient> baseIngredient = Optional.empty();

        Matcher matcher = NUMBER_PATTERN.matcher(line);
        boolean matches = matcher.matches();
        String amount = matches ? matcher.group() : "1";

        for (Unit unit : units) {
            baseIngredient = unit.unitNames()
                    .filter(unitName -> line.contains(unitName))
                    .findFirst()
                    .map(s -> BaseIngredient.Builder.aBaseIngredient()
                            .withAmount(amount)
                            .withName(line)
                            .withUnit(unit)
                            .build());
        }

        return baseIngredient.or(() -> Optional.of(BaseIngredient.Builder.aBaseIngredient()
                .withUnit(Unit.UNKNOWN)
                .withName(line)
                .withAmount(amount)
                .build()));


    }
}
