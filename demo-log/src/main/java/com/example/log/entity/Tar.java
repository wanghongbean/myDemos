package com.example.log.entity;

import java.util.Date;

/**
 * @author bean wanghb_prm@si-tech.com.cn
 * @Title Tar.java
 * @Project demo-log
 * @Description
 * @create 2018-05-30
 */
public class Tar {
    private int id;
    private Date birth;

    public Tar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Tar{" +
                "id=" + id +
                ", birth=" + birth +
                '}';
    }
}
