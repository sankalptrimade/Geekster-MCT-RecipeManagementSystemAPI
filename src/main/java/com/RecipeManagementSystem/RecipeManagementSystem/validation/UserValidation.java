package com.RecipeManagementSystem.RecipeManagementSystem.validation;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidation {
    public JSONObject validUserRequest(String userData) {
        JSONObject userObj = new JSONObject(userData);
        JSONObject errorList = new JSONObject();

        if (userObj.has("firstName")) {
            String firstName = userObj.getString("firstName");
        } else {
            errorList.put("firstName", "Missing Parameter");
        }
        if (userObj.has("lastName")) {
            String lastName = userObj.getString("lastName");
        } else {
            errorList.put("lastName", "Missing Parameter");
        }
        if (userObj.has("age")) {
            int age = userObj.getInt("age");
        } else {
            errorList.put("age", "Missing Parameter");
        }
        if (userObj.has("phoneNumber")) {
            String phoneNumber = userObj.getString("phoneNumber");
            if (!validPhoneNumber(phoneNumber)) {
                errorList.put("phoneNumber", "Please enter a valid Phone Number");
            }
        } else {
            errorList.put("phoneNumber", "Missing Parameter");
        }
        if (userObj.has("email")) {
            String email = userObj.getString("email");
            if (!validEmail(email)) {
                errorList.put("email", "Please enter a valid email");
            }
        } else {
            errorList.put("email", "Missing Parameter");
        }
        return errorList;
    }

    private boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private boolean validPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");
        Matcher m = p.matcher(phoneNumber);
        return (m.find() && m.group().equals(phoneNumber));
    }
}
