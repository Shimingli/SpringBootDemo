package com.shiming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Auther: shiming
 * @Date: 2018/5/23 22:43
 * @Description:  RestController注解等同于
 */
@Controller//把RestController 该我Controller
@ResponseBody//不加注解  http://localhost:8081/shiming11/hello3 返回一个index.html
@RequestMapping("/lei")//也可以这样子去使用，这样的话，连接起来就可以去访问了  http://localhost:8081/shiming11/lei/hello22-A
public class HelloController {
    // TODO: 2018/5/21 怎么，垃圾，看仔细一点啊！！！   http://localhost:8081/shiming11/hello
    @Value("${girl}")
    private String girl;
    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;
    //配置url的映射
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
    //http://localhost:8081/shiming11/hello3
    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public String say3(){
        return "index";//注意查看，templates 文件下的 ，index.html 。不推荐使用，前后端分离
    }
    //这里使用的一个集合
   // http://localhost:8081/shiming11/hello22-B   http://localhost:8081/shiming11/hello22-A
    @RequestMapping(value = {"/hello22-B","hello22-A"},method = RequestMethod.GET)
    public String say4(){
        return meProperties.getName()+meProperties.getAge();
    }
    /*
    如果使用  @RequestMapping(value = {"/POST1","/POST2"})  get和post都可以 请求的到
     */
    @RequestMapping(value = {"/POST1","/POST2"},method = RequestMethod.POST)
    public String say5(){
        return meProperties.getName()+meProperties.getAge();
    }
    //http://localhost:8081/shiming11/lei/shis/23  获取url中的 id  也可以写成这样 value = {"/{id}/shis","/shi"}
    @RequestMapping(value = {"/shis/{id}","/shi"},method = RequestMethod.GET)
    public String say6(@PathVariable("id") Integer id){
        return meProperties.getName()+meProperties.getAge()+"url中获取到的id==="+id;
    }
    //http://localhost:8081/shiming11/lei/shisss?id=1000  注意shissss后面没有的哦
    @RequestMapping(value = {"/shisss","/shisssss"},method = RequestMethod.GET)
    public String say7(@RequestParam("id") Integer id){
        return meProperties.getName()+meProperties.getAge()+"url中获取到的id==="+id;
    }
    //http://localhost:8081/shiming11/lei/say8?id=10
    //required 是否必须传这个值，false  defaultValue 默认值为0
    @RequestMapping(value = "/say8",method = RequestMethod.GET)
    public String say8(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return meProperties.getName()+meProperties.getAge()+"url中获取到的id==="+id;
    }

    @GetMapping(value = "/say9")
    public String say9(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return meProperties.getName()+meProperties.getAge()+"url中获取到的id==="+id;
    }
}