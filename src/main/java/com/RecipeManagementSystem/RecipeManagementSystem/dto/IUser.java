package com.RecipeManagementSystem.RecipeManagementSystem.dto;

import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import org.json.JSONArray;

public interface IUser {
    int createUser(User user);

    JSONArray getUser(String userId);


    void updateUser(String userId, User user);

    void deleteUser(String userId);

    void updateStatus(String userId);
}
