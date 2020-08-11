package com.example.bug_tracker.service;


import com.example.bug_tracker.model.UserRole;
import com.example.bug_tracker.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAllUserRole() {
        return userRoleRepository.getAllUserRole();
    }

    @Override
    public List<UserRole> getUnexistingDistinctUserRolesForUser(Long id) {
        return userRoleRepository.getUnexistingDistinctUserRolesForUser(id);
    }
}
