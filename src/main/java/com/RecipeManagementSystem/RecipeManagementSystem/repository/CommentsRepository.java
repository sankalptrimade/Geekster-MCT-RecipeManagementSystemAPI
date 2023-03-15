package com.RecipeManagementSystem.RecipeManagementSystem.repository;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

}
