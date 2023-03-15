package com.RecipeManagementSystem.RecipeManagementSystem.model;

import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private int id;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
    @JoinColumn(name = "recipe_id")
    @ManyToOne
    private Recipe recipe;
    @Column(name = "message")
    private String message;
}
