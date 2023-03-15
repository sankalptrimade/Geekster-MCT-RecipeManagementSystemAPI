package com.RecipeManagementSystem.RecipeManagementSystem.validation;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidation {
    public JSONObject validRecipeRequest(String recipeData) {
        JSONObject recipeObj = new JSONObject(recipeData);
        JSONObject errorList = new JSONObject();

        if (recipeObj.has("name")) {
            String name = recipeObj.getString("name");
        } else {
            errorList.put("name", "Missing Parameter");
        }
        if (recipeObj.has("ingredients")) {

        } else {
            errorList.put("name", "Missing Parameter");
        }
        if (recipeObj.has("instructions")) {
            String instructions = recipeObj.getString("instructions");
        } else {
            errorList.put("instructions", "Missing Parameter");
        }
//        if (recipeObj.has("servings")) {
//            int servings = recipeObj.getInt("servings");
//        } else {
//            errorList.put("servings", "Missing Parameter");
//        }
//        if (recipeObj.has("calories")) {
//            int calories = recipeObj.getInt("calories");
//        } else {
//            errorList.put("calories", "Missing Parameter");
//        }
//        if (recipeObj.has("preparationTime")) {
//            String preparationTime = recipeObj.getString("preparationTime");
//        } else {
//            errorList.put("preparationTime", "Missing Parameter");
//        }
        return errorList;
    }
}
