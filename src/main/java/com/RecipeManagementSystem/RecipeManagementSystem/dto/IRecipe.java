package com.RecipeManagementSystem.RecipeManagementSystem.dto;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import org.json.JSONArray;

import java.util.List;

public interface IRecipe {
    int createRecipe(Recipe recipe);

    JSONArray getRecipe(String recipeId);

    void updateRecipe(String recipeId, Recipe recipe);

    void deleteRecipe(String recipeId);

}
