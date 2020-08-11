package com.example.bug_tracker.service;

import com.example.bug_tracker.model.User;
import com.example.bug_tracker.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService {
    public List<UserRole> getAllUserRole();

    public List<UserRole> getUnexistingDistinctUserRolesForUser(Long id);
    
}
