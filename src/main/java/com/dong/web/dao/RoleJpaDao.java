package com.dong.web.dao;

import com.dong.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaDao extends JpaRepository<Role, String> {
}
