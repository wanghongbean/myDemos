package com.whb.spi;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        StrategyService service = new StrategyService();

        service.execute(1);
    }
}
