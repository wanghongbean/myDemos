package com.example.log.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title User.java
 * @Project demo-log
 * @Description 
 * @author bean wanghb_prm@si-tech.com.cn
 * @create 2018-05-30 
 */
@Entity
@Table(name = "t_user")
public class User {
    private int id;
    private String name;
    private Date birth;

    public User() {
    }

    public User(int id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    @Id
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
