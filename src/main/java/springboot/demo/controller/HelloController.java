package springboot.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.demo.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @auther hyq
 * @date 2020/12/17--23:44
 */
@Controller
public class HelloController {
    private final Logger log= LoggerFactory.getLogger(HelloController.class);

    @ResponseBody
    @RequestMapping("/hello")
    public  String  hello(){
        return "hello";
    }
    @RequestMapping("/success")
    public  String  success(Map<String,Object> map){
        map.put("hello","你好妹妹!");

        return "success";
    }
    @GetMapping("/index")
    public String index(Model model) {
        List<Person> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person u = new Person();
            u.setAge(i);
            u.setName("欣欣:" + i);
            users.add(u);
        }
        log.info("模板引擎thmyeleaf");
        model.addAttribute("users", users);
        return "index";
    }


}
