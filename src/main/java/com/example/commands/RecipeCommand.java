package com.example.commands;

import com.example.model.Difficulty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RecipeCommand {
    private Long recipeId;
    @Min(20)
    @Max(1000)
    private String description;
    private int prepTime;
    private int cookingTime;
    private int servings;
    private String source;
    @URL
    private String url;
    @Size(min = 10, max = 500)
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();


}
