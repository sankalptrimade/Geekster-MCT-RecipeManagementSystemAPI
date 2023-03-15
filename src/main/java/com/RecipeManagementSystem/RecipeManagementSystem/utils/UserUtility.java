package com.RecipeManagementSystem.RecipeManagementSystem.utils;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Status;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.StatusRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserUtility {
    @Autowired
    StatusRepository statusRepository;
    public User setUser(String userData) {
        JSONObject userObj = new JSONObject(userData);
        User user = new User();
        user.setFirstName(userObj.getString("firstName"));
        user.setLastName(userObj.getString("lastName"));
        user.setAge(userObj.getInt("age"));
        user.setGender(userObj.getString("gender"));
        user.setPhoneNumber(userObj.getString("phoneNumber"));
        user.setEmail(userObj.getString("email"));
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        user.setCreatedDate(createdDate);
        Status statusId = statusRepository.findById(1).get();
        user.setStatus(statusId);
        return user;
    }

    public JSONObject saveUser(User user) {
        JSONObject userObj = new JSONObject();
        userObj.put("id", user.getId());
        userObj.put("firstName", user.getFirstName());
        userObj.put("lastName", user.getLastName());
        userObj.put("age", user.getAge());
        userObj.put("phoneNumber", user.getPhoneNumber());
        userObj.put("gender", user.getGender());
        userObj.put("email", user.getEmail());
        userObj.put("createdDate", user.getCreatedDate());
        return userObj;
    }
}
