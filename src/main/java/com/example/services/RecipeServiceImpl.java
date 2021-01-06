package com.example.services;

import com.example.commands.RecipeCommand;
import com.example.converters.RecipeCommandToRecipe;
import com.example.converters.RecipeToRecipeCommand;
import com.example.model.Recipe;
import com.example.repositories.RecipeRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public Set<RecipeCommand> findAllRecipes() {
        Set<RecipeCommand> recipeCommands = new HashSet<>();
        recipeRepository.findAll().forEach(r -> recipeCommands.add(recipeToRecipeCommand.convert(r)));
        return recipeCommands;
    }

    @Override
    public RecipeCommand findRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("recipe with id " + id.toString() + " was not found"));
        return recipeToRecipeCommand.convert(recipe);
    }

    @Override
    public RecipeCommand createRecipe(RecipeCommand recipeCommand) {
        return null;
    }

    @Override
    public void deleteRecipeById(Long id) {

    }
}
