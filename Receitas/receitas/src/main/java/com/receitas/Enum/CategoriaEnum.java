package com.receitas.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoriaEnum {
        DOCES("Doces"),
        SALGADOS("Salgados"),
        VEGETARIANO("Vegetariano"),
        VEGANO("Vegano"),
        SEM_GLUTEN("Sem glúten"),
        ZERO_LACTOSE("Zero lactose"),
        LOW_CARB("Low Carb");

        private String categoria;
}
