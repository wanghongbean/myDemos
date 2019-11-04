package com.whb.spi.impl;

import com.whb.spi.DemoSpi;

/**
 * @Author labu
 * @Date 2019/11/4
 * @Description
 */
public class ASpiImpl implements DemoSpi {
    public int name() {
        return 1;
    }

    public ASpiImpl (){
        System.out.println("ASpi load ....");
    }

    public void execute() {
        System.out.println("AAAAAAAAAAAAAAAA");
    }
}
