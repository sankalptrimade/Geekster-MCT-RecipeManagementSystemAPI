package com.RecipeManagementSystem.RecipeManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "createdDate")
    private Timestamp createdDate;
    @Column(name = "updatedDate")
    private Timestamp updatedDate;
    @JoinColumn(name = "status_id")
    @ManyToOne
    private Status status;
}
