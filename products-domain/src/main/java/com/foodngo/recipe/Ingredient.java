package com.foodngo.recipe;

import java.math.BigDecimal;

public interface Ingredient {

    Unit unit();

    BigDecimal amount();

    String name();

}
