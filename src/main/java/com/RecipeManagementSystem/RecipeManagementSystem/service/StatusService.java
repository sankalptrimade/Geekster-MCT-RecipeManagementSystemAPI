package com.RecipeManagementSystem.RecipeManagementSystem.service;

import com.RecipeManagementSystem.RecipeManagementSystem.dto.IStatus;
import com.RecipeManagementSystem.RecipeManagementSystem.model.Status;
import com.RecipeManagementSystem.RecipeManagementSystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatus {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public int createStatus(Status newStatus) {
        Status status = statusRepository.save(newStatus);
        return status.getId();
    }
}
