package com.RecipeManagementSystem.RecipeManagementSystem.utils;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Comments;
import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.RecipeRepository;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.UserRepository;
import com.RecipeManagementSystem.RecipeManagementSystem.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentsUtility {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;
    public Comments setComments(String commentsData) {
        JSONObject commentsObj = new JSONObject(commentsData);
        Comments comments = new Comments();

        int userId = commentsObj.getInt("userId");
        User user = userRepository.findById(userId).get();
        comments.setUser(user);

        int recipeId = commentsObj.getInt("recipeId");
        Recipe recipe = recipeRepository.findById(recipeId).get();
        comments.setRecipe(recipe);

        comments.setMessage(commentsObj.getString("message"));
        return comments;
    }
}
