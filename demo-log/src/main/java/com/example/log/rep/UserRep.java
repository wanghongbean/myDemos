package com.example.log.rep;

import com.example.log.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRep
 *
 * @Description :
 * @Auther bean wanghb_prm@si-tech.com.cn
 * @Date 2018/5/30
 */
@Repository
public interface UserRep extends JpaRepository<User,Integer> {
}
