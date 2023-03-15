package com.RecipeManagementSystem.RecipeManagementSystem.controller;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Comments;
import com.RecipeManagementSystem.RecipeManagementSystem.service.CommentsService;
import com.RecipeManagementSystem.RecipeManagementSystem.utils.CommentsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/v1/comments")
public class CommentsController {
    @Autowired
    CommentsService commentsService;
    @Autowired
    CommentsUtility commentsUtility;
    @PostMapping(value = "create-comment")
    public ResponseEntity<String> createComments(@RequestBody String commentsData){
        Comments comments = commentsUtility.setComments(commentsData);
        int commentId = commentsService.createComments(comments);
        return new ResponseEntity<String>("Comment created with id:- "+commentId, HttpStatus.CREATED);
    }


}
