package com.RecipeManagementSystem.RecipeManagementSystem.service;

import com.RecipeManagementSystem.RecipeManagementSystem.dto.IRecipe;
import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.RecipeRepository;
import com.RecipeManagementSystem.RecipeManagementSystem.utils.RecipeUtility;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService implements IRecipe {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeUtility recipeUtility;

    @Override
    public int createRecipe(Recipe newRecipe) {
        Recipe recipe = recipeRepository.save(newRecipe);
        return recipe.getId();
    }

    @Override
    public JSONArray getRecipe(String recipeId) {
        JSONArray recipeArr = new JSONArray();
        if (null != recipeId) {
            Recipe recipe = recipeRepository.findById(Integer.parseInt(recipeId)).get();
            JSONObject recipeObj = recipeUtility.saveRecipe(recipe);
            recipeArr.put(recipeObj);
        } else {
            List<Recipe> recipeList = recipeRepository.findAll();
            for (Recipe recipe : recipeList){
                JSONObject recipeObj = recipeUtility.saveRecipe(recipe);
                recipeArr.put(recipeObj);
            }
        }
        return recipeArr;
    }

    @Override
    public void updateRecipe(String recipeId, Recipe newRecipe) {
        if(recipeRepository.findById(Integer.parseInt(recipeId)).isPresent()){
            Recipe recipe = recipeRepository.findById(Integer.parseInt(recipeId)).get();
            recipe.setName(newRecipe.getName());
            recipe.setIngredients(newRecipe.getIngredients());
            recipe.setInstructions(newRecipe.getInstructions());
//            recipe.setServings(newRecipe.getServings());
//            recipe.setCalories(newRecipe.getCalories());
//            recipe.setPreparationTime(newRecipe.getPreparationTime());
            recipe.setUser(newRecipe.getUser());
            recipeRepository.save(recipe);
        }
    }

    @Override
    public void deleteRecipe(String recipeId) {
        recipeRepository.deleteById(Integer.parseInt(recipeId));
    }
}
