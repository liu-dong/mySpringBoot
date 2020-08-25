package com.dong.web.dao;

import com.dong.web.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaDao extends JpaRepository<Person, String> {

}