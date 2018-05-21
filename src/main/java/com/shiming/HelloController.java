package com.shiming;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // TODO: 2018/5/21 怎么，垃圾，看仔细一点啊！！！   http://localhost:8081/shiming11/hello
    @Value("${girl}")
    private String girl;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "nihao shiming---ai ----fangjie +cupSize==="+girl;
       // return girl;
    }
}