package com.RecipeManagementSystem.RecipeManagementSystem.service;

import com.RecipeManagementSystem.RecipeManagementSystem.dto.IUser;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.UserRepository;
import com.RecipeManagementSystem.RecipeManagementSystem.utils.UserUtility;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService implements IUser {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserUtility userUtility;

    @Override
    public int createUser(User newUser) {
        User user = userRepository.save(newUser);
        return user.getId();
    }

    @Override
    public JSONArray getUser(String userId) {
        JSONArray userArr = new JSONArray();
        if(null != userId && userRepository.findById(Integer.parseInt(userId)).isPresent()){
            User user = userRepository.getUserByUserId(Integer.parseInt(userId));
            JSONObject userObj = userUtility.saveUser(user);
            userArr.put(userObj);
        } else {
            List<User> userList = userRepository.getAllUsers();
            for(User user :userList){
                JSONObject userObj = userUtility.saveUser(user);
                userArr.put(userObj);
            }
        }
        return userArr;
    }

    @Override
    public void updateUser(String userId, User newUser) {
        if (userRepository.findById(Integer.parseInt(userId)).isPresent()){
            User user = userRepository.findById(Integer.parseInt(userId)).get();
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setAge(newUser.getAge());
            user.setPhoneNumber(newUser.getPhoneNumber());
            user.setGender(newUser.getGender());
            user.setEmail(newUser.getEmail());
            Timestamp updatedDate = new Timestamp(System.currentTimeMillis());
            user.setUpdatedDate(updatedDate);
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteUserByUserId(Integer.parseInt(userId));
    }

    @Override
    public void updateStatus(String userId) {
        userRepository.updateStatus(Integer.parseInt(userId));
    }
}
