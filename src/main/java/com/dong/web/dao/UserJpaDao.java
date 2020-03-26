package com.dong.web.dao;

import com.dong.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaDao extends JpaRepository<User, String> {

    User getUserByUsername(String username);
}
