package com.foodngo.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleIngredientMapper implements IngredientMapper {


    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+[\\/\\d. ]*|\\d)");


    private List<Unit> units = Arrays.stream(Unit.values())
            .collect(Collectors.toList());

    @Override
    public Optional<Ingredient> parseIngredient(String line) {

        Optional<Ingredient> baseIngredient = Optional.empty();

        String amount = getAmount(line);

        for (Unit unit : units) {
            Stream<String> stringStream = unit.unitNames();
            baseIngredient = stringStream
                    .filter(s -> line.contains(s))
                    .findAny()
                    .map(s -> BaseIngredient.Builder.aBaseIngredient()
                            .withAmount(amount)
                            .withName(line)
                            .withUnit(unit)
                            .build());
            if(baseIngredient.isPresent()) {
                break;
            }
        }

        return baseIngredient.or(() -> Optional.of(BaseIngredient.Builder.aBaseIngredient()
                .withUnit(Unit.UNKNOWN)
                .withName(line)
                .withAmount(amount)
                .build()));


    }

    private String getAmount(String line) {
        Matcher matcher = NUMBER_PATTERN.matcher(line);
        boolean matches = matcher.find();
        return matches ? matcher.group().trim() : "1";
    }
}
