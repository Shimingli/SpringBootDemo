package com.shiming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Auther: shiming
 * @Date: 2018/5/23 22:43
 * @Description:
 */
@RestController
public class HelloController {
    // TODO: 2018/5/21 怎么，垃圾，看仔细一点啊！！！   http://localhost:8081/shiming11/hello
    @Value("${girl}")
    private String girl;
    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
       // return "nihao shiming---ai ----fangjie +cupSize==="+girl+"age="+age;
        return content;
    }

    //配置可以分组的写下去，这样更加的容易点
    @Autowired
    private MeProperties meProperties;// http://localhost:8081/shiming11/hello2
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String say2(){
        return meProperties.getName()+meProperties.getAge();
    }
}