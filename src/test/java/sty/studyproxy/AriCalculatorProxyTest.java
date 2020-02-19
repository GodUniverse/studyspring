package sty.studyproxy;

import org.junit.Test;


public class AriCalculatorProxyTest {

    @Test
    public void testProxy(){
        AriCalculator target = new AriCalculatorImpl();

        Object obj = new AriCalculatorProxy(target).getProxy();

        AriCalculator proxy = (AriCalculator) obj;

        int add = proxy.add(1, 2);
        System.out.println(add);

    }

}