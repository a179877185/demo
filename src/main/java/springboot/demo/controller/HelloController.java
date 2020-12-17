package springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther hyq
 * @date 2020/12/17--23:44
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public  String  hello(){
        return "hello";
    }

}
