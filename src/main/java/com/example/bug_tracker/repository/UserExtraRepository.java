package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.UserExtra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExtraRepository extends JpaRepository<UserExtra, Long> {
}
