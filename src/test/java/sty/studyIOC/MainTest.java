package sty.studyIOC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void main() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person) ctx.getBean("person");

        System.out.println(person.toString());
    }
}