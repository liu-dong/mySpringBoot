package com.dong.web.dao.impl;

import com.dong.common.ResponseResult;
import com.dong.web.dao.CommonDao;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public class CommonDaoImpl implements CommonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Map<String, Object>> findListBySql(StringBuilder sql, List<Object> param, int page, int limit) {
        Query query = entityManager.createNativeQuery(String.valueOf(sql));
        for (int i = 0; i < param.size(); i++) {
            query.setParameter(i + 1, param.get(i));
        }
        query.setFirstResult((page - 1) * limit);//起始数
        query.setMaxResults(limit);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    @Override
    public List<Map<String, Object>> findListBySql(StringBuilder sql, List<Object> param) {
        Query query = entityManager.createNativeQuery(String.valueOf(sql));
        for (int i = 0; i < param.size(); i++) {
            query.setParameter(i + 1, param.get(i));
        }
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    @Override
    public Integer getTotalBySql(StringBuilder sql, List<Object> param) {
        String sqlString = "SELECT COUNT(1) total FROM ( "+sql+" ) t";
        Query query = entityManager.createNativeQuery(sqlString);
        Object singleResult = query.getSingleResult();
        if (singleResult instanceof BigInteger) {
            return ((BigInteger) singleResult).intValue();
        } else {
            return null;
        }
    }
}
