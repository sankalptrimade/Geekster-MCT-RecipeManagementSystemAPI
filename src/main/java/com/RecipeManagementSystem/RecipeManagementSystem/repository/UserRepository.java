package com.RecipeManagementSystem.RecipeManagementSystem.repository;

import com.RecipeManagementSystem.RecipeManagementSystem.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "Select * from tbl_user where user_id = :userId and status_id = 1", nativeQuery = true)
    public User getUserByUserId(int userId);

    @Query(value = "Select * from tbl_user where status_id = 1", nativeQuery = true)
    public List<User> getAllUsers();

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set status_id = 2 where user_id = :userId",
            countQuery = "Select count(*) from tbl_user", nativeQuery = true)
    public void deleteUserByUserId(int userId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set status_id = 1 where user_id = :userId",
            countQuery = "Select count(*) from tbl_user", nativeQuery = true)
    public void updateStatus(int userId);
}
