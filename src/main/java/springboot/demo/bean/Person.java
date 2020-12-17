package springboot.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @auther hyq
 * @date 2020/12/18--0:26
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private  Integer age;
    private Map<String,Object> maps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map <String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map <String, Object> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", maps=" + maps +
                '}';
    }
}
