package com.example.bug_tracker.repository;


import com.example.bug_tracker.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

        @Override
        <S extends UserRole> S save(S entity);

        @Override
        List<UserRole> findAll();

        @Query(value="SELECT * FROM USER_ROLE ur WHERE u.name = name", nativeQuery = true)
         UserRole findByName(@Param("name") String name);

        @Transactional
        default UserRole createRoleIfNotFound(String name) {
            UserRole userRole = findByName(name);
            if (userRole == null) {
                userRole = new UserRole(name);
                save(userRole);
            }
            return userRole;
        }
}
