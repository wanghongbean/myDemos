package com.demo.singletondemo;

/**
 * @author bean wanghb_prm@si-tech.com.cn
 * @Title SingletonClass.java
 * @Project singleton-demo
 * @Description 双重校验锁
 * @create 2018-06-11
 */
public class SingletonClass {
    private volatile static SingletonClass singleton;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (null == singleton) {
            synchronized (SingletonClass.class) {
                if (null == singleton) {
                    singleton = new SingletonClass();
                }
            }
        }
        return singleton;
    }

    public void m() {
        System.out.println(
                "singleton class "
        );
    }
}
