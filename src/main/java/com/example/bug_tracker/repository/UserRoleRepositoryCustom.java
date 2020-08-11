package com.example.bug_tracker.repository;


import com.example.bug_tracker.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepositoryCustom {

    public List<UserRole> getUnexistingDistinctUserRolesForUser(Long id);
}
