package com.adminUserManagementSystem.repository;

import com.adminUserManagementSystem.beans.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

