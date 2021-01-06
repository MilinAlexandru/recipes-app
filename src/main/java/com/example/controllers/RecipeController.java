package com.example.controllers;

import com.example.commands.RecipeCommand;
import com.example.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<Set<RecipeCommand>> getAll() {
        return ResponseEntity.ok(recipeService.findAllRecipes());
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeCommand> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.findRecipeById(id));
    }
}
