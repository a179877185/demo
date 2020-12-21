package springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.demo.service.HelloService;

/**
 * @auther hyq
 * @date 2020/12/20--19:21
 */
@Configuration
public class MyAppConfig {

    //默认id就是方法名
    @Bean
    public HelloService helloService(){
        return  new HelloService();

    }
}
