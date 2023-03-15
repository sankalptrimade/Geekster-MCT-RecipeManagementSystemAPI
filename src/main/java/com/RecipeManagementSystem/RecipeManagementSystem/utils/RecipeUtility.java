package com.RecipeManagementSystem.RecipeManagementSystem.utils;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.UserRepository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeUtility {
    @Autowired
    UserRepository userRepository;
    public Recipe setRecipe(String recipeData) {
        JSONObject recipeObj = new JSONObject(recipeData);
        Recipe recipe = new Recipe();
        recipe.setName(recipeObj.getString("name"));
        JSONArray ingredientsArr = recipeObj.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<>();
        for(int i=0; i<ingredientsArr.toList().size(); i++){
            String str = ingredientsArr.getString(i);
            ingredients.add(str);
        }
        recipe.setIngredients(ingredients);
        recipe.setInstructions(recipeObj.getString("instructions"));
//        recipe.setServings(recipeObj.getInt("servings"));
//        recipe.setCalories(recipeObj.getInt("calories"));
//        recipe.setPreparationTime(recipeObj.getString("preparationTime"));
        int userId = recipeObj.getInt("userId");
        User user = userRepository.findById(userId).get();
        recipe.setUser(user);
        return recipe;
    }

    public JSONObject saveRecipe(Recipe recipe) {
        JSONObject recipeObj = new JSONObject(recipe);
        recipeObj.put("id", recipe.getId());
        recipeObj.put("name", recipe.getName());
        recipeObj.put("ingredients", recipe.getIngredients());
        recipeObj.put("instructions", recipe.getInstructions());
//        recipeObj.put("servings", recipe.getServings());
//        recipeObj.put("calories", recipe.getCalories());
//        recipeObj.put("preparationTime", recipe.getPreparationTime());
        User user = recipe.getUser();
        JSONObject userObj = new JSONObject();
        userObj.put("id", user.getId());
        userObj.put("firstName", user.getFirstName());
        userObj.put("lastName", user.getLastName());
        userObj.put("age", user.getAge());
        userObj.put("phoneNumber", user.getPhoneNumber());
        userObj.put("gender", user.getGender());
        userObj.put("email", user.getEmail());
        userObj.put("createdDate", user.getCreatedDate());
        recipeObj.put("user", userObj);
        return recipeObj;
    }
}
