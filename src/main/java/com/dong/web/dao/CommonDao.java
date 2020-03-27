package com.dong.web.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao {

    /**
     * 分页列表查询
     *
     * @param sql
     * @param param
     * @param page
     * @param limit
     * @return
     */
    List<Map<String, Object>> findListBySql(StringBuilder sql, List<Object> param, int page, int limit);

    /**
     * 列表查询
     *
     * @param sql
     * @param param
     * @return
     */
    List<Map<String, Object>> findListBySql(StringBuilder sql, List<Object> param);

}
