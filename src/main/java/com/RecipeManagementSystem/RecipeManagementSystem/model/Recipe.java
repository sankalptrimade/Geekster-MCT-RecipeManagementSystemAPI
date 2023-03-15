package com.RecipeManagementSystem.RecipeManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int id;
    @Column(name = "recipe_name")
    private String name;
    @Column(name = "ingredients")
    private List<String> ingredients;
    @Column(name = "instructions")
    private String instructions;
//    @Column(name = "servings")
//    private int servings;
//    @Column(name = "calories")
//    private int calories;
//    @Column(name = "preparationTime")
//    private String preparationTime;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
