package com.RecipeManagementSystem.RecipeManagementSystem.utils;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Status;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class StatusUtility {

    public Status setStatus(String statusData) {
        JSONObject statusObj = new JSONObject(statusData);
        Status status = new Status();
        status.setStatus(statusObj.getString("status"));
        status.setDescription(statusObj.getString("description"));
        return status;
    }
}
