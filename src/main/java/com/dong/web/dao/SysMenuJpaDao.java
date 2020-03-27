package com.dong.web.dao;

import com.dong.web.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuJpaDao extends JpaRepository<SysMenu, String> {

    List<SysMenu> getAllByParentId(String parentId);
}
