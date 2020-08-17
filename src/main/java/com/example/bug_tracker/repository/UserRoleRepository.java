package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.User;
import com.example.bug_tracker.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface UserRoleRepository extends JpaRepository<User, Long>, UserRoleRepositoryCustom {

    //@Query("SELECT ur FROM USER_ROLE ur WHERE ur.id=:id")
    @Query(value = "SELECT * FROM USER_ROLE ur WHERE u.id=id", nativeQuery = true)
    public UserRole getUserRoleById(@Param("id") Long id);

    @Query(value = "SELECT * FROM USER_ROLE u WHERE u.status =1", nativeQuery = true)
    public List<UserRole> getAllUserRole();

}
