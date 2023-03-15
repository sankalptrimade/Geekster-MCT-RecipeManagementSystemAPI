package com.RecipeManagementSystem.RecipeManagementSystem.service;

import com.RecipeManagementSystem.RecipeManagementSystem.dto.IComments;
import com.RecipeManagementSystem.RecipeManagementSystem.model.Comments;
import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.CommentsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService implements IComments {
    @Autowired
    CommentsRepository commentsRepository;
    @Override
    public int createComments(Comments newComments) {
        Comments comments = commentsRepository.save(newComments);
        return comments.getId();
    }
}
