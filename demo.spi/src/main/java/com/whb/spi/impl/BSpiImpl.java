package com.whb.spi.impl;

import com.whb.spi.DemoSpi;

/**
 * @Author labu
 * @Date 2019/11/4
 * @Description
 */
public class BSpiImpl implements DemoSpi {
    public int name() {
        return 2;
    }

    public BSpiImpl (){
        System.out.println("BSpi load ....");
    }

    public void execute() {
        System.out.println("BBBBBBBBBBBBBBBBBBB");
    }
}
