package springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springboot.demo.bean.Person;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    @Test
    public void testHelloService(){
        boolean service = ioc.containsBean("helloService");
        System.out.println(service);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
