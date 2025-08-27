package com.tradernote.Repository;

import org.springframework.stereotype.Repository;

import com.tradernote.Model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
