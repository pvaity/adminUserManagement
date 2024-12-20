package com.adminUserManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adminUserManagementSystem.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

