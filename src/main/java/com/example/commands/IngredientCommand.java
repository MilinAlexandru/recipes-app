package com.example.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientCommand {
    private Long ingredientId;
    private String description;
    private double amount;
    private UnitOfMeasurementCommand uom;
    private Long recipeId;

}
