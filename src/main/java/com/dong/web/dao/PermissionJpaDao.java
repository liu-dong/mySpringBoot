package com.dong.web.dao;

import com.dong.web.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionJpaDao extends JpaRepository<Permission, String> {

}