package com.example.log.service;

import com.example.log.entity.User;
import com.example.log.rep.UserRep;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * @Title UserService.java
 * @Project demo-log
 * @Description 
 * @author bean wanghb_prm@si-tech.com.cn
 * @create 2018-05-30 
 */
@Service
@Transactional
public class UserService implements IUserService{
    @PersistenceContext
    protected EntityManager em;

    @Resource
    private UserRep userRep;

    @Override
    public User test(int id){

        String sql="select a from User a where a.id=:id";
        TypedQuery<User> query = this.em.createQuery(sql, User.class);
        query.setParameter("id",2);
        User singleResult = query.getSingleResult();

        System.out.println("--------"+singleResult);
        return singleResult;

    }
}
