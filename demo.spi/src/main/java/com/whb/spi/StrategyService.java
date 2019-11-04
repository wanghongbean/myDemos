package com.whb.spi;


import com.sun.tools.javac.util.ServiceLoader;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author labu
 * @Date 2019/11/4
 * @Description
 */
public class StrategyService {
    private static Map<Integer,DemoSpi> spis= new HashMap<Integer,DemoSpi>();

    static {
        loadSpi();
    }

    private static void loadSpi(){
        ServiceLoader<DemoSpi> demoSpis = AccessController.doPrivileged(new PrivilegedAction<ServiceLoader<DemoSpi>>() {

            public ServiceLoader<DemoSpi> run() {
                return ServiceLoader.load(DemoSpi.class);
            }
        });

        for (Iterator<DemoSpi> it =demoSpis.iterator();it.hasNext();){
            DemoSpi next = it.next();
            spis.put(next.name(),next);
        }
    }


    public void execute(int spi){
        spis.get(spi).execute();
    }
}
