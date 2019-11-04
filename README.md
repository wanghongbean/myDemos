# myDemos
所有测试用例

# demo.spi
* 策略模式 解耦
* 路径 META-INF/services
```java
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
```
