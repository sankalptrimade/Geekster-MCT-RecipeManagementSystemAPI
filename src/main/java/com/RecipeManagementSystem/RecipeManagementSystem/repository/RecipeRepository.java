package com.RecipeManagementSystem.RecipeManagementSystem.repository;

import com.RecipeManagementSystem.RecipeManagementSystem.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
