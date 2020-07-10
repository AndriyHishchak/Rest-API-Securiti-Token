package com.RestAPISecuritiToken.repository;

import com.RestAPISecuritiToken.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
