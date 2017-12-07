package com.foodngo.recipe;

public class BaseIngredient implements Ingredient {


    private final String name;
    private final Unit unit;
    private final String amount;

    public BaseIngredient(String name, Unit unit, String  amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }


    @Override
    public Unit unit() {
        return this.unit;
    }

    @Override
    public String amount() {
        return this.amount;
    }

    @Override
    public String name() {
        return this.name;
    }

    public static final class Builder {
        private String name;
        private Unit unit;
        private String amount;

        private Builder() {
        }

        public static Builder aBaseIngredient() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUnit(Unit unit) {
            this.unit = unit;
            return this;
        }

        public Builder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Ingredient build() {
            BaseIngredient baseIngredient = new BaseIngredient(name, unit, amount);
            return baseIngredient;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseIngredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", unit=").append(unit);
        sb.append(", amount='").append(amount).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
