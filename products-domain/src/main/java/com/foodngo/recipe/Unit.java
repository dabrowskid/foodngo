package com.foodngo.recipe;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Unit {

    ML(new String[] {"ml"}, "milliters"),
    GRAM(new String[] {"g", "gr"}, "grmas"),
    UNKNOWN(new String[]{}, "unknown" );

    private final String unitShort[];
    private final String fullName;

    Unit(String unitShort[], String fullName) {
        this.unitShort = unitShort;
        this.fullName = fullName;
    }


    public Stream<String> unitNames() {
        return Arrays.stream(unitShort);
    }
}
