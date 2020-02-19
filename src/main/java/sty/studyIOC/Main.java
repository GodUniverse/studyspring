package sty.studyIOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person1 = ctx.getBean("person",Person.class);
        Person person2 = ctx.getBean("person",Person.class);
        System.out.println(person1 == person2);

        System.out.println(person1.toString());
    }
}
