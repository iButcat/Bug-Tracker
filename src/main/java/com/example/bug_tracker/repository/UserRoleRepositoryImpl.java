package com.example.bug_tracker.repository;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.model.User;
import com.example.bug_tracker.repository.UserRoleRepositoryCustom;
import com.example.bug_tracker.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepositoryCustom{

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    public UserRepository userRepository;

    @Override
    @Transactional
    public List<UserRole> getUnexistingDistinctUserRolesForUser(Long id) {
        User user = null;
        List newUrList = null;

        try {
            user = userRepository.getUserById(id);
            Set<UserRole> urList = null;

            if (user != null) {
                urList = user.getUserRolesList();
            }

            if (urList == null) {
                urList = (Set<UserRole>) entityManager.createQuery("SELECT ur FROM user_role ur").getResultList();
            } else {

                List<String> urTypeList = new ArrayList<>();

                for(UserRole ur: urList) {
                    urTypeList.add(ur.getType());
                }

                newUrList = entityManager
                        .createQuery("SELECT ur FROM user_role ur WHERE ur.type NOT IN (:user_role)")
                        .setParameter("user_role", urTypeList).getResultList();
            }
        } catch (NoResultException e) {

        }

        return newUrList;
    }
}
