package sty.studyAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");

        AriCalculator ac = ctx.getBean("ariCalculatorImpl", AriCalculator.class);

        System.out.println(ac.getClass().getName());//这个AC是代理对象

        int res = ac.add(1, 1);

        int res2 = ac.del(1, 1);

//        int res3 = ac.div(5,0);

    }
}
