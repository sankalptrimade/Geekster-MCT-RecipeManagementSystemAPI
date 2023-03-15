package com.RecipeManagementSystem.RecipeManagementSystem.controller;

import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import com.RecipeManagementSystem.RecipeManagementSystem.service.UserService;
import com.RecipeManagementSystem.RecipeManagementSystem.utils.UserUtility;
import com.RecipeManagementSystem.RecipeManagementSystem.validation.UserValidation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserUtility userUtility;
    @Autowired
    UserValidation userValidation;

    @PostMapping(value = "create-user")
    public ResponseEntity<String> createUser(@RequestBody String userData) {
        JSONObject isRequestValid = userValidation.validUserRequest(userData);
        User user = null;
        int userid = 0;
        if (isRequestValid.isEmpty()) {
            user = userUtility.setUser(userData);
            userid = userService.createUser(user);
        } else {
            return new ResponseEntity<String>(isRequestValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("User saved with Id:- " + userid, HttpStatus.CREATED);
    }

    @GetMapping(value = "get-user")
    public ResponseEntity<String> getUser(@Nullable @RequestParam String userId) {
        JSONArray userArr = userService.getUser(userId);
        return new ResponseEntity<String>(userArr.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "update-user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody String userData) {
        JSONObject isRequestValid = userValidation.validUserRequest(userData);
        User user = null;
        if (isRequestValid.isEmpty()) {
            user = userUtility.setUser(userData);
            userService.updateUser(userId, user);
        } else {
            return new ResponseEntity<String>(isRequestValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("User updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("User Deleted", HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "update-status/{userId}")
    public ResponseEntity<String> updateStatus(@PathVariable String userId){
        userService.updateStatus(userId);
        return new ResponseEntity<String>("Updated Status", HttpStatus.OK);
    }

}
