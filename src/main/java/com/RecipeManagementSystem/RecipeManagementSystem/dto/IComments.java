package com.RecipeManagementSystem.RecipeManagementSystem.dto;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Comments;
import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import org.json.JSONObject;

import java.util.List;

public interface IComments {
    int createComments(Comments comments);
}
