package com.RecipeManagementSystem.RecipeManagementSystem.controller;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import com.RecipeManagementSystem.RecipeManagementSystem.service.RecipeService;
import com.RecipeManagementSystem.RecipeManagementSystem.utils.RecipeUtility;
import com.RecipeManagementSystem.RecipeManagementSystem.validation.RecipeValidation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "api/v1/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeValidation recipeValidation;
    @Autowired
    RecipeUtility recipeUtility;
    @PostMapping(value = "create-recipe")
    public ResponseEntity<String> createRecipe(@RequestBody String recipeData) {
        JSONObject isRequestValid = recipeValidation.validRecipeRequest(recipeData);
        Recipe recipe = null;
        int recipeId = 0;
        if(isRequestValid.isEmpty()) {
            recipe = recipeUtility.setRecipe(recipeData);
            recipeId = recipeService.createRecipe(recipe);
        } else {
            return new ResponseEntity<String>(isRequestValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Recipe Saved with id:- "+recipeId, HttpStatus.CREATED);
    }
    @GetMapping(value = "get-recipe")
    public ResponseEntity<String> getRecipe(@Nullable @RequestParam String recipeId){
        JSONArray recipeArr = recipeService.getRecipe(recipeId);
        return new ResponseEntity<String>(recipeArr.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "update-recipe/{recipeId}")
    public ResponseEntity<String> updateRecipe(@PathVariable String recipeId, @RequestBody String recipeData){
        JSONObject isRequestValid = recipeValidation.validRecipeRequest(recipeData);
        Recipe recipe = null;
        if (isRequestValid.isEmpty()){
            recipe = recipeUtility.setRecipe(recipeData);
            recipeService.updateRecipe(recipeId, recipe);
        } else {
            return new ResponseEntity<String>(isRequestValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Recipe Updates", HttpStatus.OK);
    }
    @DeleteMapping(value = "delete-recipe/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable String recipeId){
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<String>("Deleted Recipe", HttpStatus.OK);
    }

}
